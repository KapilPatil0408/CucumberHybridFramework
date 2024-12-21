package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSucess;
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	    driver = DriverFactory.getDriver();
	    HomePage homePage= new HomePage(driver);
	    homePage.clickOnMyAccount();
	    registerPage = homePage.selectRegisterOption();
	}

	@When("User enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(CommonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterPasswordConfirm(dataMap.get("password"));
	}
	
	@When("User enters details into below fields with duplicate email")
	public void user_enters_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterPasswordConfirm(dataMap.get("password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivacyPolicyOption();
	}

	@When("User Clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountSucess = registerPage.clickContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	  Assert.assertEquals("Your Account Has Been Created!", accountSucess.getAccountCreatedMsg());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectNewLetterYesOption();
	    
	}

	@Then("User account should get proper warning about duplicate email")
	public void user_account_should_get_proper_warning_about_duplicate_email() {	
	  Assert.assertTrue(registerPage.getWarningMsg().contains("Warning: E-Mail Address is alredy registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterPasswordConfirm("");

	}

	@Then("User account should get proper warning message for every manadatory field")
	public void user_account_should_get_proper_warning_message_for_every_manadatory_field() {
		Assert.assertTrue(registerPage.getWarningMsgForMandatory(0).contains("First Name must be between 1 and 32 characters!"));
		Assert.assertEquals(registerPage.getWarningMsgForMandatory(1),"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getWarningMsgForMandatory(2),"E-Mail Address does not appear to be valid!");
		Assert.assertTrue(registerPage.getWarningMsgForMandatory(3).contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerPage.getWarningMsgForMandatory(4).contains("Password must be between 4 and 20 characters!"));
		Assert.assertTrue(registerPage.getWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));
	}

}
