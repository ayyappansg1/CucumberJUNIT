package stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import baseClass.BaseClass;
import constants.Constants;
import driverManager.DriverManager;
import helper.LocalHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SecondPage;

/**
 * This is a Step Definitions Class where All Steps has implemented codes
 */
public class Step_Definitions extends BaseClass {
	List<String> useDevToolstoGrabAPINetworks;
	Map<String, String> tableValues;
	String downloadRandomFile;
	String clickAndUploadFile;

	@When("the user launched the Web application")
	public void the_user_launched_the_web_application() {
		launchApplication(Constants.application_url);
	}

	@Given("the user clicks the {string} Button")
	public void the_user_clicks_the_add_remove_elements_button(String buttonName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = HomePage.class.getMethods();
		Method[] methods2 = SecondPage.class.getMethods();
		List<Method> list = new ArrayList<Method>();
		list.addAll(Arrays.asList(methods));
		list.addAll(Arrays.asList(methods2));

		for (Method method : list) {
			if (method.getName().contains(buttonName)) {
				if (method.getDeclaringClass().equals(HomePage.class))
					method.invoke(HomePage.getInstance());
				else if (method.getDeclaringClass().equals(SecondPage.class))
					method.invoke(SecondPage.getInstance());
				break;
			}
		}
	}

	@When("the user clicks on Add element Button")
	public void the_user_clicks_on_add_element_button() {
		HomePage.getInstance().clickAddElementButton();
	}

	@Then("the User should be able to view the Delete button")
	public void the_user_should_be_able_to_view_the_delete_button() {
		boolean verifyDeleteElementPresentOrNot = HomePage.getInstance().verifyDeleteElementPresentOrNot();
		Assert.assertTrue("ELement is Not displayed", verifyDeleteElementPresentOrNot);
	}

	@Then("the user clicks on Delete Button")
	public void the_user_clicks_on_delete_button() {
		HomePage.getInstance().clickDeleteElementButton();
	}

	@Then("the user should not see the Delete Button")
	public void the_user_should_not_see_the_delete_button() {
		boolean verifyDeleteElementPresentOrNot = HomePage.getInstance().verifyDeleteElementPresentOrNot();
		Assert.assertFalse("ELement is Still displaying", verifyDeleteElementPresentOrNot);
	}

	@When("the user passing {string} and  {string} and press enter")
	public void the_user_passing_and_and_press_enter(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) throws AWTException {
		List<List<String>> asList = dataTable.asLists();
		HomePage.getInstance().sendValuesToTheAuthenticationBoxUsingRobot(asList.get(0).get(0), asList.get(0).get(1));
	}

	@Then("the user should be able to see the success message")
	public void the_user_should_be_able_to_see_the_success_message() {
		boolean verifySuccessMessage = HomePage.getInstance().verifySuccessMessage();
		Assert.assertTrue("Not authorised", verifySuccessMessage);
	}

	@Given("the user clicks the Broken image Button")
	public void the_user_clicks_the_broken_image_button() throws InterruptedException {
		// Thread.sleep(5000);
		useDevToolstoGrabAPINetworks = LocalHelper.useDevToolstoGrabAPINetworks();
		HomePage.getInstance().clickBrokenImageButton();
	}

	@When("the user landing on the landing page")
	public void the_user_landing_on_the_landing_page() throws IOException {
		int fetchBrokenImageLinks = HomePage.getInstance().fetchBrokenImageLinks(useDevToolstoGrabAPINetworks);
		Assert.assertTrue("Count is Zero", fetchBrokenImageLinks > 0);
	}

	@When("the User clicks the Random button from Side Menu")
	public void the_user_clicks_the_random_button_from_side_menu() {
		HomePage.getInstance().clickRandomButton();
	}

	@When("the user able to see the table fetch the 7th row")
	public void the_user_able_to_see_the_table_fetch_the_7th_row() {
		tableValues = HomePage.getInstance().fetchColumnValues();
	}

	@Then("the user should be able to fetch the row values")
	public void the_user_should_be_able_to_fetch_the_row_values() {
		Assert.assertFalse("Map contains empty Value", tableValues.isEmpty());
	}

	@When("the User clicks the first Checkbox and second checkbox")
	public void the_user_clicks_the_first_checkbox_and_second_checkbox() {
		HomePage.getInstance().checkAllCheckboxOptions();
	}

	@Then("the user should see first checkbox is checked and second is unchecked")
	public void the_user_should_see_first_checkbox_is_checked_and_second_is_unchecked() {
		boolean verifyFirstAndSecondBox = HomePage.getInstance().verifyFirstAndSecondBox();
		Assert.assertTrue("Any one checkbox is irrelavant", verifyFirstAndSecondBox);
	}

	@When("the User rightClick inside the rectangle Box")
	public void the_user_right_click_inside_the_rectangle_box() {
		HomePage.getInstance().rightClickOnRectangleBox();
	}

	@Then("the user should see the alert")
	public void the_user_should_see_the_alert() {
		String handlingAlert = HomePage.getInstance().handlingAlert();
		Assert.assertTrue("Text is not matching", handlingAlert.contains("You selected a context menu"));
	}

	@When("the User Refreshes the page")
	public void the_user_refreshes_the_page() {
	}

	@Then("the user should see decrease in count of elements")
	public void the_user_should_see_decrease_in_count_of_elements() {
		int compareTheCountings = HomePage.getInstance().compareTheCountings();
		Assert.assertTrue(compareTheCountings != 0);
	}

	@When("the user click A and Drops in B")
	public void the_user_click_a_and_drops_in_b() {
		HomePage.getInstance().performDragDropInPage();
	}

	@Then("the user shoud see the interchange in A and B")
	public void the_user_shoud_see_the_interchange_in_a_and_b() {
		String verifyVisibilityOfINterchangedBoxes = HomePage.getInstance().verifyVisibilityOfINterchangedBoxes();
		Assert.assertTrue("A not droped in B", verifyVisibilityOfINterchangedBoxes.equals("B"));

	}

	@When("the user click on Dropdown options and select {string}")
	public void the_user_click_on_dropdown_options_and_select(String string) {
		HomePage.getInstance().selectGivenOptionFromDropdown(string);
	}

	@Then("the user shoud see the {string} Selected")
	public void the_user_shoud_see_the_option2_selected(String string) {
		String fetchSelectedOptionFromDropdown = HomePage.getInstance().fetchSelectedOptionFromDropdown();
		Assert.assertTrue("Selected option is something else", fetchSelectedOptionFromDropdown.equals(string));
	}

	@When("the user landed in the page and Gathers the text and refresh the page")
	public void the_user_landed_in_the_page_and_gathers_the_text_and_refresh_the_page() {
		boolean dynamicContentsComparision = HomePage.getInstance().dynamicContentsComparision();
		Assert.assertFalse("Contents matching even after refresh", dynamicContentsComparision);
	}

	@Then("the user shoud not see the same content for every Refresh")
	public void the_user_shoud_not_see_the_same_content_for_every_refresh() {
		boolean dynamicContentsComparision = HomePage.getInstance().dynamicContentsComparision();
		Assert.assertFalse("Contents matching even after refresh", dynamicContentsComparision);
	}

	@When("the user clicks on Checkbox and clicks Remove Button")
	public void the_user_clicks_on_checkbox_and_clicks_remove_button() {
		HomePage.getInstance().performActionsOnCheckBox();
	}

	@Then("the user should not see checkbox and {string} Text should appear")
	public void the_user_should_not_see_checkbox(String text) {
		Assert.assertTrue(HomePage.getInstance().verifyGoneText(text));
	}

	@When("the user clicks Add Button")
	public void the_user_clicks_add_button() {
		HomePage.getInstance().performAddButtonAgain();
	}

	@Then("the user should see {string}  text")
	public void the_user_should_see_text(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyBackText(string));
	}

	@Then("the user verify the disabled textbox")
	public void the_user_verify_the_disabled_textbox() {
		Assert.assertFalse(HomePage.getInstance().verifyTextBoxDisabled());
	}

	@Then("the user clicks on enable button and then the user should be able to enter text")
	public void the_user_clicks_on_enable_button_and_then_the_user_should_be_able_to_enter_text() {
		HomePage.getInstance().clickEnableButton();
	}

	@Then("the user shoud see {string}")
	public void the_user_shoud_see(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyEnabledMessage(string));
	}

	@Then("the user clicks on Disable button")
	public void the_user_clicks_on_disable_button() {
		HomePage.getInstance().clickDisableButton();
	}

	@Then("the user should see {string}")
	public void the_user_should_see(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyDisabledMessage(string));
	}

	@When("the user clicks on Example1 and click start")
	public void the_user_clicks_on_example1_and_click_start() {
		HomePage.getInstance().clickElement1WithActions();
	}

	@Then("the user see {string} message")
	public void the_user_see_message(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyHelloWorldMessage(string));
	}

	@Then("the user clicks on Example2 and click start")
	public void the_user_clicks_on_example2_and_click_start() {
		HomePage.getInstance().clickElement2WithActions();
	}

	@Then("the user should see {string} message again")
	public void the_user_should_see_message_again(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyHelloWorldMessage(string));
	}

	@When("the user see Modal window and title should be {string}")
	public void the_user_see_modal_window_and_title_should_be(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyModelTitle(string));
	}

	@Then("the user see close button and able to click")
	public void the_user_see_close_button_and_able_to_click() {
		Assert.assertTrue(HomePage.getInstance().clickCloseButtonAndVerifyPopupClosed());
	}

	@When("the user is on exit intent page and moves cursor out of page")
	public void the_user_is_on_exit_intent_page_and_moves_cursor_out_of_page() throws AWTException {
		HomePage.getInstance().movingCursorAwayFromPage();
	}

	@Then("the user should see modal window with title {string}")
	public void the_user_should_see_modal_window_with_title(String string) {
		Assert.assertTrue(HomePage.getInstance().verifyModalWindowOpened(string));
	}

	@When("the user clicks on random file to download")
	public void the_user_clicks_on_random_file_to_download() {
		downloadRandomFile = HomePage.getInstance().downloadRandomFile();
	}

	@Then("the user should see the downloaded file in download folder")
	public void the_user_should_see_the_downloaded_file_in_download_folder() throws InterruptedException {
		Assert.assertTrue("file is not present", HomePage.getInstance().verifyDownloadedFile(downloadRandomFile));
	}

	@When("the user clicks choose File button and selects the file to be upload")
	public void the_user_clicks_choose_file_button_and_selects_the_file_to_be_upload() throws AWTException {
		clickAndUploadFile = HomePage.getInstance().clickAndUploadFile();
	}

	@Then("the user should see the success message {string} for File uploaded and file name should appear here")
	public void the_user_should_see_the_success_message_for_file_uploaded_and_file_name_should_appear_here(
			String successMessage) {
		Assert.assertTrue("Success Message not matches", HomePage.getInstance().verifyFilesUpload(successMessage));
		Assert.assertTrue("Uploaded file name not matching", HomePage.getInstance().verifyFileName(clickAndUploadFile));
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = HomePage.class.getMethods();
		for (Method method : methods) {
			if (method.getName().contains(string)) {
				method.invoke(HomePage.getInstance());
				break;
			}
		}
	}

	@Then("the user should see the {string} in url")
	public void the_user_should_see_the_in_url(String string) {
		Assert.assertTrue("Url not contain:" + string, HomePage.getInstance().verifyUrlForEachClickTab(string));
	}

	@When("the user enter their email address and clicks retrive password")
	public void the_user_enter_their_email_address_and_clicks_retrive_password() {
		HomePage.getInstance().enterPasswordAndClickRetrivePassword();
	}

	@Then("the user should see the internal server error message")
	public void the_user_should_see_the_internal_server_error_message() {
		Assert.assertTrue("Invalid message", HomePage.getInstance().verifyRetrivePasswordMessage());
	}

	@When("the user grabs username and password from webpage and clicks login button")
	public void the_user_grabs_username_and_password_from_webpage_and_clicks_login_button() {
		HomePage.getInstance().enterUsernameAndPasswordGrabbedFromwebPage();
	}

	@Then("the user should see the login success message {string}")
	public void the_user_should_see_the_login_success_message(String message) {
		Assert.assertTrue("Invalid Login  message", HomePage.getInstance().verifySuccessMessageAfterLogin(message));
	}

	@When("the user clicks on nested frame")
	public void the_user_clicks_on_nested_frame() {
		HomePage.getInstance().clickNestedFrame();
	}

	@Then("the user should see the text of {string} in middle frame")
	public void the_user_should_see_the_text_of_in_middle_frame(String string) {
		Assert.assertTrue("Nested Frame Content mismatch",
				HomePage.getInstance().getTextFromNestedFrameMiddle().contains(string));
	}

	@Then("the user clicks on iframe")
	public void the_user_clicks_on_iframe() {
		HomePage.getInstance().clickIFrame();

	}

	@Then("the user should see the {string} text inside frame")
	public void the_user_should_see_the_text_inside_frame(String string) {
		Assert.assertTrue("Iframe Content mismatch", HomePage.getInstance().getTextFromIFrame().contains(string));
	}

	@When("the user clicks on WhereAmI button")
	public void the_user_clicks_on_where_am_i_button() {
		SecondPage.getInstance().clickWhereAmIButton();
	}

	@Then("the user should see the Latitude {string} and Longitude {string}")
	public void the_user_should_see_the_latitude_and_longitude(String latitude, String longititude) {
		Assert.assertTrue("Both Values are mismatch",
				SecondPage.getInstance().verifyBothLongtitudeAndLatitude(latitude, longititude));
	}

	@When("the user clicks and move the slider to last")
	public void the_user_clicks_and_move_the_slider_to_last() {
		SecondPage.getInstance().performActionOnSlider();
	}

	@Then("the user should see the range text as {int}")
	public void the_user_should_see_the_range_text_as(Integer int1) {
		Assert.assertTrue("Sliding not happened", SecondPage.getInstance().verifySliderText(int1));
	}

	@When("the user mouse hover to all three images")
	public void the_user_mouse_hover_to_all_three_images() {
	}

	@Then("the user should see names of <first> and <second> and <third> names as below")
	public void the_user_should_see_names_of_first_and_second_and_third_names_as_below(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Assert.assertTrue("Profile not matches", SecondPage.getInstance().mouseHoverToEachImage(asMaps));
	}

	@When("the user scroll {int} times")
	public void the_user_scroll_five_times(Integer num) throws InterruptedException {
		SecondPage.getInstance().scrollFiveTimes(num);
	}

	@Then("the user should see the contents")
	public void the_user_should_see_the_contents() {
	}

	@When("the user Enters {int} in the textbox and click increase button")
	public void the_user_enters_in_the_textbox_and_click_increase_button(Integer int1) {
		SecondPage.getInstance().enterNumberAndClickAdd(int1);
	}

	@Then("the user should see the count should be increased by one")
	public void the_user_should_see_the_count_should_be_increased_by_one() {
	}

	@When("the user mouse hover to enabled")
	public void the_user_mouse_hover_to_enabled() {
		SecondPage.getInstance().mouseHoverToEnabled();
	}

	@Then("the user should see the {string} and {string} tab")
	public void the_user_should_see_the_and_tab(String string, String string2) {
		Assert.assertTrue("Enabled Tab options mismatch",
				SecondPage.getInstance().verifyAfterMouseHoverToEnabledTab(string, string2));
	}

	@Then("the user clicks on Back to JQuery ui tab and landed on respective page")
	public void the_user_clicks_on_back_to_j_query_ui_tab_and_landed_on_respective_page() {
		SecondPage.getInstance().clickOnJQueryBackUI();
	}

	@Then("the user should see {string} hyperlink")
	public void the_user_should_see_hyperlink(String string) {
		Assert.assertTrue("Menu hyperLink is not visible", SecondPage.getInstance().verifyMenuHyperLink());
	}

	@Then("the user clicks on it")
	public void the_user_clicks_on_it() {
		SecondPage.getInstance().clickMenuRedirectLink();
	}

	@Then("the user should redirect to menu page again")
	public void the_user_should_redirect_to_menu_page_again() {
		SecondPage.getInstance().verifyRedirectionLink("menu");
	}

	@Then("the user mouse hover to downloads tab")
	public void the_user_mouse_hover_to_downloads_tab() {
		SecondPage.getInstance().mouseHoverToDownloadsPage();
	}

	@Then("the user should see {string} and {string} and {string} tab")
	public void the_user_should_see_and_and_tab(String first, String second, String third) {
		Assert.assertTrue("Downloads tab not having all these three options",
				SecondPage.getInstance().verifyDownloadsTabOptions(first, second, third));
	}

	@Then("the user clicks on pdf")
	public void the_user_clicks_on_pdf() {
		SecondPage.getInstance().clicksOnPdfOption();
	}

	@Then("the user should be able to download sample pdf")
	public void the_user_should_be_able_to_download_sample_pdf() {
		Assert.assertTrue("PDF file is not downloaded", SecondPage.getInstance().verifyDownloadedFile());
	}

	@When("the user clicks on click for JS alert")
	public void the_user_clicks_on_click_for_js_alert() {
		SecondPage.getInstance().clickJSAlertButton();
	}

	@Then("the user should see {string} in result")
	public void the_user_should_see_in_result(String string) {
		Assert.assertTrue("JS Alert text is not matching", SecondPage.getInstance().verifyJSAlertButton(string));
	}

	@Then("the user clicks on click for JS Confirm")
	public void the_user_clicks_on_click_for_js_confirm() {
		SecondPage.getInstance().clickJSAlertConfirmButton();
	}

	@Then("the user should be see {string}")
	public void the_user_should_be_see(String string) {
		Assert.assertTrue("JS Alert Confirm text is not matching",
				SecondPage.getInstance().verifyJSAlertButton(string));
	}

	@Then("the user clicks on JS Confirm alert and clicks dismiss")
	public void the_user_clicks_on_js_confirm_alert_and_clicks_dismiss() {
		SecondPage.getInstance().clickJSAlertConfirmWithCancelButton();
	}

	@Then("the user should be see the {string}")
	public void the_user_should_be_see_the(String string) {
		Assert.assertTrue("JS Alert Confirm text is not matching",
				SecondPage.getInstance().verifyJSAlertButton(string));
	}

	@Then("the user clicks on JS prompt alert and enters the {string} text")
	public void the_user_clicks_on_js_prompt_alert_and_enters_the_text(String string) {
		SecondPage.getInstance().clickJSAlertPromptButton(string);
	}

	@Then("the user should see prompt alert {string}")
	public void the_user_should_see_prompt_alert(String string) {
		Assert.assertTrue("JS Alert Prompt text is not matching", SecondPage.getInstance().verifyJSAlertButton(string));
	}

	@When("the user clicks on the landing page")
	public void the_user_clicks_on_the_landing_page() {
		Assert.assertTrue("User landed in unexpected page",
				SecondPage.getInstance().verifyUserLandingPageAfterClickJSOnloadError());
	}

	@Then("the user should see the error message contains {string}")
	public void the_user_should_see_the_error_message_contains(String string) {
		Assert.assertTrue("Error mismatch or not found", SecondPage.getInstance().verifyJavascriptErrorOnPage(string));
	}

	@When("the user Enters different keyboard actions like {string} {string} {string} {string} {string}")
	public void the_user_enters_different_keyboard_actions_like(String string, String string2, String string3,
			String string4, String string5) {
		List<String> asList = Arrays.asList(string, string2, string3, string4, string5);
		SecondPage.getInstance().pressKeysBasedOnGiven(asList);

	}

	@Then("the user should see these texts {string} {string} {string} {string} {string} in UI")
	public void the_user_should_see_these_texts_in_ui(String string, String string2, String string3, String string4,
			String string5) {
		List<String> asList = Arrays.asList(string, string2, string3, string4, string5);
		Assert.assertTrue("List Mismatches", SecondPage.getInstance().verifyKeysPressed(asList));
	}

	@When("the user fetches particular value from the table using proper xpath")
	public void the_user_fetches_particular_value_from_the_table_using_proper_xpath() {
		SecondPage.getInstance().fetchValueFromTable();
	}

	@Then("the user should see that value should be {double}")
	public void the_user_should_see_that_value_should_be(Double double1) {
		Assert.assertTrue("Value matching with exact value",SecondPage.getInstance().verifyingTheValueWithTableValue(double1));
	}
	@When("the user clicks the clickhere button")
	public void the_user_clicks_the_clickhere_button() {
		SecondPage.getInstance().clickClickHereNewWindow();
	}
	@Then("the user should navigate to new window and {string} text")
	public void the_user_should_navigate_to_new_window_and_text(String string) {
		Assert.assertTrue("Value Mismatches in both",SecondPage.getInstance().switchToNewWindowAndGrabText(string));
	}

	@When("the user on the landing page and validate bottom text {string}")
	public void the_user_on_the_landing_page_and_validate_bottom(String text) {
		Assert.assertTrue("Bottom Frame has issue",SecondPage.getInstance().fetchingBottomFrameTextAndVerify(text));
	}
	@Then("the user on the topframe and should see right frame text {string}")
	public void the_user_on_the_topframe_and_should_see_right_frame(String text) {
		Assert.assertTrue("Right frame has issue",SecondPage.getInstance().fetchingRightFrameTextAndVerify(text));
	}
	@When("the user clicks Click here button")
	public void the_user_clicks_click_here_button() {
		SecondPage.getInstance().clickClickHereNotification();
	}
	@Then("the user should see {string} or {string} message")
	public void the_user_should_see_message(String string,String string2) {
		Assert.assertTrue("First message not equal",SecondPage.getInstance().verifyTheFirstNotificationMessage(string,string2));
	}
	@Then("the user clicks again until new message appears not be same as above one")
	public void the_user_clicks_again_until_new_message_appears_not() {
		SecondPage.getInstance().clickClickHereNotificationUntilNewMessageAppears();
	}
	@Then("the user should see opposite to previous one")
	public void the_user_should_see_this() {
		Assert.assertTrue("second message not equal",SecondPage.getInstance().verifyTheSecondNotification());
	}
	@When("the user enters the credentials")
	public void the_user_enters_the_credentials() throws AWTException {
		SecondPage.getInstance().enterCredentialsUsingRobot();
	}
	@Given("the user clicks the {string} Button with scrollToLast")
	public void the_user_clicks_the_button_with_scroll_to_last(String string) {
		HomePage.getInstance().clickSecurefiledownloadButton();
	}


@Then("the user should see the downloaded file in Local download folder")
public void the_user_should_see_the_downloaded_file_in_local_download_folder() throws InterruptedException {
	Assert.assertTrue("file is not present",SecondPage.getInstance().checkDownloadedFileInLocal(downloadRandomFile));
}

@When("the user Extracting text from first paragraph it should match with {string}")
public void the_user_extracting_text_from_first_paragraph_it_should_match_with(String string) {
	Assert.assertTrue("first para has non matching text",SecondPage.getInstance().gettingTextFromFirstParagraphShadowDom(string));
}
@Then("the user Extracting text from second paragraph it should match with {string} and {string}")
public void the_user_extracting_text_from_second_paragraph_it_should_match_with_and(String string, String string2) {
	Assert.assertTrue("SecondPara not matching",SecondPage.getInstance().gettingTextFromSeconddParagraphShadowDom(string, string2));
}

@When("the user clicks menu Element he should see Menus {string} {string} {string} {string} {string}")
public void the_user_clicks_menu_element_he_should_see_menus(String string, String string2, String string3, String string4, String string5) {
	List<String> asList = Arrays.asList(string,string2,string3,string4,string5);
	Assert.assertTrue("Menus are mismatch",SecondPage.getInstance().clickMenuElementAndVerifyTabs(asList));
}
@When("the user clicks the click home button and it should redirect to home page")
public void the_user_clicks_the_click_home_button_and_it_should_redirect_to_home_page() {
	Assert.assertTrue("Not landed on home page",SecondPage.getInstance().clickHomeElementAndRedirectToHomePage());
}
@When("the user clicks the An image element and clicks the Click here button")
public void the_user_clicks_the_an_image_element_and_clicks_the_click_here_button() {
	SecondPage.getInstance().clickAnImageButtonAndGetBeforeClickCssValue();
}
@When("the user should be able to see the image moved to new location")
public void the_user_should_be_able_to_see_the_image_moved_to_new_location() {
	Assert.assertFalse("Image not moved to new location",SecondPage.getInstance().verifyImageMovedAfterReload());
}
@When("the user clicks on list")
public void the_user_clicks_on_list() {
	SecondPage.getInstance().clickList();
}
@When("the user should see lists dynamically changes for every refresh")
public void the_user_should_see_lists_dynamically_changes_for_every_refresh() {
	Assert.assertTrue("",SecondPage.getInstance().compareContentsForEveryLoad());
}


@When("the user noticing the slowResourceAPI it should give {int}")
public void the_user_noticing_the_slow_resource_api_it_should_give(Integer int1) throws URISyntaxException, IOException {
	Assert.assertTrue("Status Code is not as expected",SecondPage.getInstance().captureAndReturnUrls(int1));
}
@When("the user clicks sorting in LastName table all the elements should be in sorting order from first table")
public void the_user_clicks_sorting_in_last_name_table_all_the_elements_should_be_in_sorting_order_from_first_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyLastNameFirstTable());
	
}
@When("the user clicks sorting in Firstname table all the elements should be in sorting order from first table")
public void the_user_clicks_sorting_in_firstname_table_all_the_elements_should_be_in_sorting_order_from_first_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyFirstNameFirstTable());

}
@When("the user clicks sorting in Email table all the elements should be in sorting order from first table")
public void the_user_clicks_sorting_in_email_table_all_the_elements_should_be_in_sorting_order_from_first_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyEmailFirstTable());

}
@When("the user clicks sorting in Due table all the elements should be in sorting order from first table")
public void the_user_clicks_sorting_in_due_table_all_the_elements_should_be_in_sorting_order_from_first_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyDueFirstTable());
}
@When("the user clicks sorting in WebSite table all the elements should be in sorting order from first table")
public void the_user_clicks_sorting_in_web_site_table_all_the_elements_should_be_in_sorting_order_from_first_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyWebSiteFirstTable());
}
@When("the user clicks sorting in LastName table all the elements should be in sorting order from second table")
public void the_user_clicks_sorting_in_last_name_table_all_the_elements_should_be_in_sorting_order_from_second_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyLastNameSecondTable());
}
@When("the user clicks sorting in Firstname table all the elements should be in sorting order from second table")
public void the_user_clicks_sorting_in_firstname_table_all_the_elements_should_be_in_sorting_order_from_second_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyFirstNameSecondTable());
}
@When("the user clicks sorting in Email table all the elements should be in sorting order from second table")
public void the_user_clicks_sorting_in_email_table_all_the_elements_should_be_in_sorting_order_from_second_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyEmailSecondTable());
}
@When("the user clicks sorting in Due table all the elements should be in sorting order from second table")
public void the_user_clicks_sorting_in_due_table_all_the_elements_should_be_in_sorting_order_from_second_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyDueSecondTable());
}
@When("the user clicks sorting in WebSite table all the elements should be in sorting order from second table")
public void the_user_clicks_sorting_in_web_site_table_all_the_elements_should_be_in_sorting_order_from_second_table() {
	Assert.assertTrue("Mismatch after sorting",SecondPage.getInstance().verifyWebSiteSecondTable());
}

@When("the user clicks the {int} hyperlink api should return {int}")
public void the_user_clicks_the_hyperlink_api_should_return(Integer int1, Integer int2) throws URISyntaxException, IOException {
	Assert.assertTrue("Status Code is not as expected",SecondPage.getInstance().clickAndValidate200StatusCode(int1));
}
@When("the user clicks the {int} hyperlink api should return the {int} redirection")
public void the_user_clicks_the_hyperlink_api_should_return_the_redirection(Integer int1, Integer int2) throws URISyntaxException, IOException {
	Assert.assertTrue("Status Code is not as expected",SecondPage.getInstance().clickAndValidate301StatusCode(int1));
}
@When("the user clicks the {int} hyperlink api should return {int} not found")
public void the_user_clicks_the_hyperlink_api_should_return_not_found(Integer int1, Integer int2) throws URISyntaxException, IOException {
	Assert.assertTrue("Status Code is not as expected",SecondPage.getInstance().clickAndValidate404StatusCode(int1));

}
@When("the user clicks the {int} hyperlink api should return {int} server side issue")
public void the_user_clicks_the_hyperlink_api_should_return_server_side_issue(Integer int1, Integer int2) throws URISyntaxException, IOException {
	Assert.assertTrue("Status Code is not as expected",SecondPage.getInstance().clickAndValidate500StatusCode(int1));

}









}
