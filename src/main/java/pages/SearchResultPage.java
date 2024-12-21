package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchResultPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/child::h1")
	private WebElement validHPPRoduct;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement noProductText;
	
	public boolean displayStatusOfValidProduct() {
		return elementUtils.displayStatusOFElement(validHPPRoduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getNoProdcutText() {
		return elementUtils.getTextOfWebelement(noProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
