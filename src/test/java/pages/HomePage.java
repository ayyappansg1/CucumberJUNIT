package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import driverManager.DriverManager;
import helper.LocalHelper;
import net.bytebuddy.asm.Advice.This;

public class HomePage extends LocalHelper{
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	private volatile static HomePage instance;

	private HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static HomePage getInstance() {
		if (instance == null) {
			synchronized (HomePage.class) {
				if (instance == null) {
					instance = new HomePage();
				}
			}
		}
		return instance;
	}

	@FindBy(xpath = "//a[contains(@href,'add')]")
	private WebElement addRemoveElement;
	@FindBy(xpath = "//button[text()='Add Element']")
	private WebElement addElementButton;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteElementButton;
	@FindBy(xpath = "//a[text()='Basic Auth']")
	private WebElement basicAuthButton;
	@FindBy(css = "div p")
	private WebElement authSuccessMessage;
	@FindBy(xpath = "//a[text()='Broken Images']")
	private WebElement brokenImageButton;
	@FindBy(xpath = "//a[text()='Challenging DOM']")
	private WebElement challengingDomButton;
	@FindBy(xpath = "//a[@class='button alert']")
	private WebElement randomButton;
	@FindBy(xpath = "//a[text()='Checkboxes']")
	private WebElement checkBoxButton;
	@FindBy(xpath = "//a[text()='Context Menu']")
	private WebElement ContextMenuButton;
	@FindBy(xpath = "//a[text()='Disappearing Elements']")
	private WebElement disappearingButton;
	@FindBy(css = "#hot-spot")
	private WebElement rectangleBox;
	@FindBy(css = "#checkboxes input")
	private List<WebElement> checkBoxes;
	@FindBy(xpath = "//ul//li")
	private List<WebElement> pageHeaders;
	By seventhRow = By.xpath("//tr[5]//td");
	By rowHeader = By.xpath("//thead//th");
	@FindBy(css = "#column-a")
	private WebElement ABox;
	@FindBy(css = "#column-b")
	private WebElement BBox;
	@FindBy(xpath = "//a[text()='Drag and Drop']")
	private WebElement dragAndDropButton;
	@FindBy(xpath = "//a[text()='Dropdown']")
	private WebElement dropDownButton;
	@FindBy(id = "dropdown")
	private WebElement dropdownLocator;
	@FindBy(xpath = "//a[text()='Dynamic Content']")
	private WebElement dynamicContentButton;
	@FindBy(xpath = "//div[@id='content']//div[@class='large-10 columns']")
	private List<WebElement> dynamicContents;
	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	private WebElement dynamicControlButton;
	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	private WebElement dynamicLoadingButton;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement inputCheckBox;
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeButton;
	@FindBy(xpath = "//button[text()='Add']//following::p")
	private WebElement goneText;
	@FindBy(xpath = "//button[text()='Remove']//following::p")
	private WebElement backText;
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputTextBox;
	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement enableButton;
	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement disableButton;
	@FindBy(xpath = "//button[text()='Enable']//following::p")
	private WebElement disabledMessage;
	@FindBy(xpath = "//button[text()='Disable']//following::p")
	private WebElement enabledMessage;
	@FindBy(xpath = "//a[contains(@href,'loading/1')]")
	private WebElement example1;
	@FindBy(xpath = "//a[contains(@href,'loading/2')]")
	private WebElement example2;
	@FindBy(xpath = "//button[text()='Start']")
	private WebElement startButton;
	@FindBy(xpath = "//div[@id='finish']/h4")
	private WebElement helloWorldMessage;
	@FindBy(xpath = "//a[text()='Entry Ad']")
	private WebElement entryAd;
	@FindBy(xpath = "//a[text()='Exit Intent']")
	private WebElement exitIntent;
	@FindBy(xpath = "//div[@class='modal-footer']//p")
	private WebElement closebutton;
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement modalTitle;
	@FindBy(css = ".example h3")
	private WebElement verificationPurpose;
	@FindBy(xpath = "//a[text()='File Download']")
	private WebElement fileDownload;
	@FindBy(xpath = "//a[text()='File Upload']")
	private WebElement fileUpload;
	@FindBy(xpath = "//a[text()='Floating Menu']")
	private WebElement floatingMenu;
	@FindBy(xpath = "//a[text()='Forgot Password']")
	private WebElement forgotPassword;
	@FindBy(xpath = "//a[text()='Form Authentication']")
	private WebElement formAuthentication;
	@FindBy(xpath = "//a[text()='Frames']")
	private WebElement frames;
	@FindBy(xpath = "//a[text()='Geolocation']")
	private WebElement geoLocation;
	@FindBy(xpath = "//a[text()='Horizontal Slider']")
	private WebElement horizontalSlider;
	@FindBy(xpath = "//a[text()='Hovers']")
	private WebElement hovers;
	@FindBy(xpath = "//a[text()='Infinite Scroll']")
	private WebElement infiniteScroll;
	@FindBy(xpath = "//a[text()='Inputs']")
	private WebElement inputs;
	@FindBy(xpath = "//a[text()='JQuery UI Menus']")
	private WebElement jqueryUIMenus;
	@FindBy(xpath = "//a[text()='JavaScript Alerts']")
	private WebElement javaScriptAlerts;
	@FindBy(xpath = "//a[text()='JavaScript onload event error']")
	private WebElement javaScriptOnloadEventError;
	@FindBy(xpath = "//a[text()='Key Presses']")
	private WebElement keyPresses;
	@FindBy(xpath = "//a[text()='Large & Deep DOM']")
	private WebElement largeAndDeepDom;
	@FindBy(xpath = "//a[text()='Multiple Windows']")
	private WebElement multipleWindows;
	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFramees;
	@FindBy(xpath = "//a[text()='Notification Messages']")
	private WebElement notificationMessages;
	@FindBy(xpath = "//a[text()='Redirect Link']")
	private WebElement redirectLink;
	@FindBy(xpath = "//a[text()='Secure File Download']")
	private WebElement secureFileDownload;
	@FindBy(xpath = "//a[text()='Shadow DOM']")
	private WebElement shadowDom;
	@FindBy(xpath = "//a[text()='Shifting Content']")
	private WebElement shiftingContent;
	@FindBy(xpath = "//a[text()='Slow Resources']")
	private WebElement slowResources;
	@FindBy(xpath = "//a[text()='Sortable Data Tables']")
	private WebElement sortableDataTables;
	@FindBy(xpath = "//a[text()='Status Codes']")
	private WebElement statusCodes;
	@FindBy(xpath = "//a[text()='Typos']")
	private WebElement typos;
	@FindBy(xpath = "//a[text()='WYSIWYG Editor']")
	private WebElement WYSIWYGEditor;
	@FindBy(css = "#file-upload")
	private WebElement chooseFileButton;
	@FindBy(css = ".example a")
	private List<WebElement> allFiles;
	@FindBy(xpath = "//h3[text()='File Uploaded!']")
	private WebElement fileUploadedSuccessMessage;
	@FindBy(css = "#file-submit")
	private WebElement uploadButton;
	@FindBy(css = "#uploaded-files")
	private WebElement uploadedFileName;
	@FindBy(xpath = "//a[@href='#home']")
	private WebElement homeTab;
	@FindBy(xpath = "//a[@href='#news']")
	private WebElement newsTab;
	@FindBy(xpath = "//a[@href='#contact']")
	private WebElement contactTab;
	@FindBy(xpath = "//a[@href='#about']")
	private WebElement aboutTab;
	@FindBy(css = "body h1")
	private WebElement forgotPasswordMessage;
	@FindBy(css = "#email")
	private WebElement emailTextBox;
	@FindBy(xpath = "//i[text()='Retrieve password']")
	private WebElement retrivePassword;
	@FindBy(xpath = "//div[@class='flash success']")
	private WebElement loginSuccessMessage;
	@FindBy(css = "#username")
	private WebElement usernameBox;
	@FindBy(css = "#password")
	private WebElement passwordBox;
	@FindBy(css = ".radius")
	private WebElement loginButton;
	@FindBy(css = ".subheader em")
	private List<WebElement> usernamePassword;
	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFrame;
	@FindBy(xpath = "//a[text()='iFrame']")
	private WebElement iFrame;
	@FindBy(xpath = "//iframe")
	private WebElement insideIFrame;
	@FindBy(css = "#tinymce")
	private WebElement frameContent;
	@FindBy(xpath = "//frame[@src='/frame_top']")
	private WebElement mainFrame;
	@FindBy(xpath = "//frame[@src='/frame_middle']")
	private WebElement middleFrame;
	@FindBy(css = "#content")
	private WebElement middleContent;

	public void clickAddRemoveElementButton() {
		logger.info("Trying to Click Add Remove Element Button from the homepage");
		clickElement(addRemoveElement, DriverManager.getDriver());
		logger.info("Element Clicked SuccessFully");
	}

	public void clickAddElementButton() {
		logger.info("Trying to Click Add Element Button from the inside page");
		clickElement(addElementButton, DriverManager.getDriver());
		logger.info("Element Clicked SuccessFully");
	}

	public boolean verifyDeleteElementPresentOrNot() {
		logger.info("Verifying the Delete element button Disabled");
		return verifyElement(deleteElementButton);
	}

	public void clickDeleteElementButton() {
		logger.info("Trying to Click Delete Element Button from the inside page");
		clickElement(deleteElementButton, DriverManager.getDriver());
		logger.info("Element Clicked SuccessFully");
	}

	public void clickBasicAuthButton() {
		logger.info("Trying to Click Basic auth Button from the inside page");
		clickElement(basicAuthButton, DriverManager.getDriver());
	}

	public void sendValuesToTheAuthenticationBoxUsingRobot(String username, String password) throws AWTException {
		logger.info("Trying to Enter the Username and password");
		passingValuesInWindowPopup(username, password);
	}

	public void sendValuesToTheAuthenticationBox(String username, String password) {
		logger.info("Trying to Enter the Username and password");
		handlingAlert(DriverManager.getDriver(), username, password, "accept");
	}

	public boolean verifySuccessMessage() {
		logger.info("Grabing success Message");
		String textContent = getTextContent(authSuccessMessage);
		return textContent.contains("Congratulations! You must have");
	}

	public void clickBrokenImageButton() {
		logger.info("Trying to Click Broken image Button from the inside page");
		clickElement(brokenImageButton, DriverManager.getDriver());
	}

	public int fetchBrokenImageLinks(List<String> useDevToolstoGrabAPINetworks) throws IOException {
		List<String> fetchOnlyImageUrls = fetchOnlyImageUrls(useDevToolstoGrabAPINetworks);
		return returnBrokenImagesUrl(fetchOnlyImageUrls);
	}

	public void clickChallengingDomButton() {
		logger.info("Trying to Click Random Button from the inside page");
		clickElement(challengingDomButton, DriverManager.getDriver());
	}

	public void clickRandomButton() {
		logger.info("Trying to Click Random Button from the inside page");
		clickElement(randomButton, DriverManager.getDriver());
	}

	public Map<String, String> fetchColumnValues() {
		logger.info("Trying to Fetch row Values");
		List<String> seventhRowValues = getAllTextContents(seventhRow);
		List<String> rowHeaderValues = getAllTextContents(rowHeader);
		Map<String, String> combineTwoListAndReturnMap = combineTwoListAndReturnMap(rowHeaderValues, seventhRowValues);
		Set<Entry<String, String>> entrySet = combineTwoListAndReturnMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			logger.info(entry);
		}
		return combineTwoListAndReturnMap;
	}

	public void clickCheckboxesButton() {
		logger.info("Trying to Click Checkboxes Button from the inside page");
		clickElement(checkBoxButton, DriverManager.getDriver());
	}

	public void checkAllCheckboxOptions() {
		logger.info("Trying to Click All the checkboxes");
		clickAllCheckboxes(checkBoxes);
	}

	public boolean verifyFirstAndSecondBox() {
		boolean flag = false;
		for (WebElement webElement : checkBoxes) {
			if (webElement.isSelected()) {
				flag = true;
			}
		}
		return flag;
	}

	public void clickContextMenuButton() {
		logger.info("Trying to Click Checkboxes Button from the inside page");
		clickElement(ContextMenuButton, DriverManager.getDriver());
	}

	public void rightClickOnRectangleBox() {
		rightClickOnElement(rectangleBox, DriverManager.getDriver());
	}

	public String handlingAlert() {
		return handlingAlertWithGetText();
	}

	public void clickDisappearingElementsButton() {
		logger.info("Trying to Click Disappearing Button from the inside page");
		clickElement(disappearingButton, DriverManager.getDriver());
	}

	public int compareTheCountings() {
		return refreshThePageWithPreviousElementsCount(pageHeaders);
	}

	public void clickDragAndDropButton() {
		logger.info("Trying to Click Drog and Drop Button from the Home page");
		clickElement(dragAndDropButton, DriverManager.getDriver());
	}

	public void performDragDropInPage() {
		logger.info("Dragging and dropping box A to B");
		performDragAndDrop(ABox, BBox, DriverManager.getDriver());

	}

	public String verifyVisibilityOfINterchangedBoxes() {
		return extractTextFromParticularElement(ABox, DriverManager.getDriver());
	}

	public void clickDropDownButton() {
		logger.info("Trying to Click DropDown Button from the Home page");
		clickElement(dropDownButton, DriverManager.getDriver());
	}

	public void selectGivenOptionFromDropdown(String option) {
		logger.info("Selecting particular Option From Dropdown");
		handlingDropdown(dropdownLocator, option, DriverManager.getDriver());
	}

	public String fetchSelectedOptionFromDropdown() {
		logger.info("Fetching Selected Dropdown option");
		return selectedOptionFromDropdown(dropdownLocator, DriverManager.getDriver());
	}

	public void clickDynamicContentButton() {
		logger.info("Trying to Click dynamicContentButton Button from the Home page");
		clickElement(dynamicContentButton, DriverManager.getDriver());
	}

	public boolean dynamicContentsComparision() {
		List<String> allTextContents1 = getAllTextContents(dynamicContents);
		refreshTheCurrentPage();
		List<String> allTextContents2 = getAllTextContents(dynamicContents);
		return allTextContents1.contains(allTextContents2);
	}

	public void clickDynamicControlsButton() {
		logger.info("Trying to Click dynamicControlButton Button from the Home page");
		clickElement(dynamicControlButton, DriverManager.getDriver());
	}

	public void performActionsOnCheckBox() {
		logger.info("Click Checkbox");
		clickElement(inputCheckBox, DriverManager.getDriver());
		Assert.assertTrue(verifyCheckBoxChecked(inputCheckBox, DriverManager.getDriver()));
		logger.info("Click Remove Button");
		clickElement(removeButton, DriverManager.getDriver());
	}

	public boolean verifyGoneText(String text) {
		logger.info("Verify Gone Text");
		return getTextContent(goneText).equalsIgnoreCase(text);
	}

	public void performAddButtonAgain() {
		logger.info("Click Add Button");
		clickElement(addButton, DriverManager.getDriver());
	}

	public boolean verifyBackText(String text) {
		logger.info("Verify Back Text");
		return getTextContent(backText).equalsIgnoreCase(text);
	}

	public boolean verifyTextBoxDisabled() {
		logger.info("Verify Text Box disabled");
		return verifyEnabledElement(inputTextBox);
	}

	public void clickEnableButton() {
		logger.info("Trying to Click Enable Button from the Home page");
		clickElement(enableButton, DriverManager.getDriver());
		sendValue(inputTextBox, DriverManager.getDriver(), "SANGAR");
	}

	public boolean verifyEnabledMessage(String text) {
		logger.info("Verifying Enabled Message");
		return getTextContent(enabledMessage).equals(text);
	}

	public void clickDisableButton() {
		logger.info("Trying to Click Disable Button from the Home page");
		clickElement(disableButton, DriverManager.getDriver());
	}

	public boolean verifyDisabledMessage(String text) {
		logger.info("Verifying Disabled Message");
		return getTextContent(disabledMessage).equals(text);
	}

	public void clickDynamicLoadingButton() {
		logger.info("Trying to Click dynamicLoadingButton Button from the Home page");
		clickElement(dynamicLoadingButton, DriverManager.getDriver());
	}

	public void clickElement1WithActions() {
		logger.info("Trying to Click Example1");
		clickElement(example1, DriverManager.getDriver());
		clickElement(startButton, DriverManager.getDriver());
	}

	public boolean verifyHelloWorldMessage(String text) {
		logger.info("Fetch HeloWorld text");
		return getTextContent(helloWorldMessage).equals(text);
	}

	public void clickElement2WithActions() {
		logger.info("Go back to main page");
		getBackToPreviousPage(DriverManager.getDriver());
		logger.info("Trying to Click Example2");
		clickElement(example2, DriverManager.getDriver());
		clickElement(startButton, DriverManager.getDriver());
	}

	public void clickEntryAdButton() {
		logger.info("Trying to Click EntryAd Button from the Home page");
		clickElement(entryAd, DriverManager.getDriver());
	}

	public boolean verifyModelTitle(String text) {
		logger.info("Model box opened");
		return getTextContent(modalTitle).contains(text);
	}

	public boolean clickCloseButtonAndVerifyPopupClosed() {
		clickElement(closebutton, DriverManager.getDriver());
		return verifyElement(verificationPurpose);
	}

	public void clickExitIntentButton() {
		logger.info("Trying to Click ExitIntent Button from the Home page");
		clickElement(exitIntent, DriverManager.getDriver());
	}

	public void movingCursorAwayFromPage() throws AWTException {
		logger.info("Cursor move away");
		mouseHoverAwayFromPage(DriverManager.getDriver());
	}

	public boolean verifyModalWindowOpened(String text) {
		logger.info("Checking Model Window Opened");
		return getTextContent(modalTitle).contains(text);
	}

	public void clickFileDownloadButton() {
		logger.info("Trying to Click File Download Button from the Home page");
		clickElement(fileDownload, DriverManager.getDriver());
	}

	public void clickFileUploadButton() {
		logger.info("Trying to Click File Upload Button from the Home page");
		clickElement(fileUpload, DriverManager.getDriver());
	}

	public void clickFloatingMenuButton() {
		logger.info("Trying to Click Floating Menu Button from the Home page");
		clickElement(floatingMenu, DriverManager.getDriver());
	}

	public void clickForgotPasswordButton() {
		logger.info("Trying to Click Forgot password Button from the Home page");
		clickElement(forgotPassword, DriverManager.getDriver());
	}

	public void clickFormAuthenticationButton() {
		logger.info("Trying to Click Form Authenitication Button from the Home page");
		clickElement(formAuthentication, DriverManager.getDriver());
	}

	public void clickFramesButton() {
		logger.info("Trying to Click frame Button from the Home page");
		clickElement(frames, DriverManager.getDriver());
	}

	public void clickGeoLocationButton() {
		logger.info("Trying to Click GeoLocation Button from the Home page");
		clickElement(geoLocation, DriverManager.getDriver());
	}

	public void clickHorizontalSliderButton() {
		logger.info("Trying to Click Horizontal Slider Button from the Home page");
		clickElement(horizontalSlider, DriverManager.getDriver());
	}

	public void clickHoversButton() {
		logger.info("Trying to Click Hovers Button from the Home page");
		clickElement(hovers, DriverManager.getDriver());
	}

	public void clickInfiniteScrollButton() {
		logger.info("Trying to Click InfiniteScroll Button from the Home page");
		clickElement(infiniteScroll, DriverManager.getDriver());
	}

	public void clickInputsButton() {
		logger.info("Trying to Click Inputs Button from the Home page");
		clickElement(inputs, DriverManager.getDriver());
	}

	public void clickJQueryUIMenusButton() {
		logger.info("Trying to Click JQueryUIMenus Button from the Home page");
		clickElement(jqueryUIMenus, DriverManager.getDriver());
	}

	public void clickJavaScriptAlertsButton() {
		logger.info("Trying to Click JavaScript Alerts Button from the Home page");
		clickElement(javaScriptAlerts, DriverManager.getDriver());
	}

	public void clickJavaScriptOnloadEventErrorButton() {
		logger.info("Trying to Click JavaScript Alerts OnLoadEvent error from the Home page");
		clickElement(javaScriptOnloadEventError, DriverManager.getDriver());
	}

	public void clickKeyPressesButton() {
		logger.info("Trying to Click KeyPresses from the Home page");
		clickElement(keyPresses, DriverManager.getDriver());
	}

	public void clickLargeAndDeepDOMButton() {
		logger.info("Trying to Click Large and Deep from the Home page");
		clickElement(largeAndDeepDom, DriverManager.getDriver());
	}

	public void clickMultipleWindowsButton() {
		logger.info("Trying to Click MultipleWindows from the Home page");
		clickElement(multipleWindows, DriverManager.getDriver());
	}

	public void clickNestedFramesButton() {
		logger.info("Trying to Click NestedFrames from the Home page");
		clickElement(nestedFramees, DriverManager.getDriver());
	}

	public void clickNotificationMessageButton() {
		logger.info("Trying to Click NotificationMessages from the Home page");
		clickElement(notificationMessages, DriverManager.getDriver());
	}

	public void clickRedirectLinkButton() {
		logger.info("Trying to Click RedirectLink from the Home page");
		clickElement(redirectLink, DriverManager.getDriver());
	}

	public void clickSecurefiledownloadButton() {
		logger.info("Trying to Click SecureFileDownload from the Home page");
		scrollToLast();
		clickElement(secureFileDownload, DriverManager.getDriver());
	}

	public void clickShadowDomButton() {
		logger.info("Trying to Click ShaodwDom from the Home page");
		clickElement(shadowDom, DriverManager.getDriver());
	}

	public void clickShiftingContentButton() {
		logger.info("Trying to Click Shifting Content from the Home page");
		clickElement(shiftingContent, DriverManager.getDriver());
	}

	public void clickSlowResourcesButton() {
		List<String> useDevToolstoGrabAPINetworks = useDevToolstoGrabAPINetworks();
		logger.info("Trying to Click SlowResourcesfrom the Home page");
		clickElement(slowResources, DriverManager.getDriver());
	}

	public void clickSortableDataTablesButton() {
		logger.info("Trying to Click SortableDataTables the Home page");
		clickElement(sortableDataTables, DriverManager.getDriver());
	}

	public void clickStatusCodesButton() {
		logger.info("Trying to Click statusCodes the Home page");
		clickElement(statusCodes, DriverManager.getDriver());
	}

	public void clickTyposButton() {
		logger.info("Trying to Click Typos the Home page");
		clickElement(typos, DriverManager.getDriver());
	}

	public void clickWYSIWYGEditorButton() {
		logger.info("Trying to Click WYSIWYGEditor from the Home page");
		clickElement(WYSIWYGEditor, DriverManager.getDriver());
	}

	public String downloadRandomFile() {
		logger.info("trying to click random file");
		return clickRandomElement(allFiles);
	}

	public boolean verifyDownloadedFile(String fileName) throws InterruptedException {
		logger.info("Fetching File name");
		Thread.sleep(5000);
		return verifyFileName(fileName);
	}

	public void selectButton() {
		logger.info("Trying to Click WYSIWYGEditor from the Home page");
		clickElement(WYSIWYGEditor, DriverManager.getDriver());
	}

	public String clickAndUploadFile() throws AWTException {
		logger.info("Clicking File upload Button");
		String uploadFileUsingSendKeys = uploadFileUsingSendKeys(chooseFileButton);
		// String uploadFileUsingRobot =
		// uploadFileUsingRobot();
		clickElement(uploadButton, DriverManager.getDriver());
		return uploadFileUsingSendKeys;
	}

	public boolean verifyFilesUpload(String successMessage) {
		logger.info("Verifying the success message");
		return getTextContent(fileUploadedSuccessMessage).contains(successMessage);
	}

	public boolean verifyFileName(String fileName) {
		logger.info("Verifying the uploaded File");
		return getTextContent(uploadedFileName).contains(fileName);
	}

	public void clickHomeTab() {
		logger.info("Trying to HomeTab");
		clickElement(homeTab, DriverManager.getDriver());
	}

	public void clickNewsTab() {
		logger.info("Trying to NewsTab");
		clickElement(newsTab, DriverManager.getDriver());
	}

	public void clickcontactTab() {
		logger.info("Trying to contactTab");
		clickElement(contactTab, DriverManager.getDriver());
	}

	public void clickaboutTab() {
		logger.info("Trying to aboutTab");
		clickElement(aboutTab, DriverManager.getDriver());
	}

	public boolean verifyUrlForEachClickTab(String tab) {
		return verifyUrlContainsExpectedText(tab, DriverManager.getDriver());
	}

	public void enterPasswordAndClickRetrivePassword() {
		logger.info("Enter Email");
		sendValue(emailTextBox, DriverManager.getDriver(),
				new Faker().name().firstName() + "@yopmail.com");
		clickElement(retrivePassword, DriverManager.getDriver());
	}

	public boolean verifyRetrivePasswordMessage() {
		return getTextContent(forgotPasswordMessage).contains("Internal Server");
	}

	public void enterUsernameAndPasswordGrabbedFromwebPage() {
		logger.info("Grab username and password from web page");
		List<String> allTextContents = getAllTextContentsPlain(usernamePassword);
		sendValue(usernameBox, DriverManager.getDriver(), allTextContents.get(0));
		sendValue(passwordBox, DriverManager.getDriver(), allTextContents.get(1));
		logger.info("Cick  Login button");
		clickElement(loginButton, DriverManager.getDriver());
	}

	public boolean verifySuccessMessageAfterLogin(String message) {
		String textContent = getTextContent(loginSuccessMessage);
		logger.info("Text content from web page:" + textContent);
		logger.info("Feature file content:" + message);
		return textContent.contains(message);
	}

	public void clickNestedFrame() {
		clickElement(nestedFrame, DriverManager.getDriver());
	}

	public void clickIFrame() {
		getBackToPreviousPage(DriverManager.getDriver());
		clickElement(iFrame, DriverManager.getDriver());
	}

	public String getTextFromIFrame() {
		switchToFrame(DriverManager.getDriver(), insideIFrame);
		String textContent = getTextContent(frameContent);
		switchToParent(DriverManager.getDriver());
		return textContent;
	}

	public String getTextFromNestedFrameMiddle() {
		switchToFrame(DriverManager.getDriver(), mainFrame);
		switchToFrame(DriverManager.getDriver(), middleFrame);
		String textContent = getTextContent(middleContent);
		switchToParent(DriverManager.getDriver());
		return textContent;
	}

}
