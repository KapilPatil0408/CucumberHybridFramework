package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement continueBtn;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement selectNewLetterYesOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsg;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private List <WebElement> errorMessages;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningMsgForMandatory(int no) {
		return elementUtils.getTextOfWebelement(errorMessages.get(no), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningMsg() {
		return elementUtils.getTextOfWebelement(warningMsg,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmail(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephone(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPasswordConfirm(String passwordConfirmText) {
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordConfirmText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void selectPrivacyPolicyOption() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountSuccessPage clickContinueBtn() {
		elementUtils.clickOnElement(continueBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void selectNewLetterYesOption() {
		elementUtils.clickOnElement(selectNewLetterYesOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
