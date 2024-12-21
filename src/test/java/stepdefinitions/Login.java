package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	@Given("User has navigates to login page")
	public void user_has_navigates_to_login_page() {
		driver= DriverFactory.getDriver();
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage= homePage.selectLoginOption();
	}

	@When("^User has enters valid email address (.+) into email field$")
	public void user_has_enters_valid_email_address_into_email_field(String validEmailText) {
		loginPage.enterEmailAddress(validEmailText);
	}

	@When("^User has enters valid password (.+) into password field$")
	public void user_has_enters_valid_password_into_password_field(String validPasswordText) {
		loginPage.enterPassword(validPasswordText);  
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	    Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInfoOption());
	}

	@When("User has enters invalid email address into email field")
	public void user_has_enters_invalid_email_address_into_email_field() {
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	}

	@When("User has enters invalid password {string} into password field")
	public void user_has_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
	}

	@Then("USer should get a proper warning message about credentials mismatch")
	public void u_ser_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont entered email address into email field")
	public void user_dont_entered_email_address_into_email_field() {
		loginPage.enterEmailAddress("");
		
	}

	@When("User dont entered password into password field")
	public void user_dont_entered_password_into_password_field() {
		loginPage.enterPassword("");
	}

	
}
