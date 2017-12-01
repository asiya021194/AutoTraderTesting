package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealerPage {

	@FindBy(css= "#postcode")
	private WebElement postcode;
	
	public WebElement insertPostcode() {
		return postcode;
	}
	
	@FindBy(css = "body > section.landingForm > div > form > div.cf > div:nth-child(5) > div > select")
	private WebElement make;
	
	public WebElement selectMake() {
		return make;
	}
	
	@FindBy(css = "body > section.landingForm > div > form > div.cf > div:nth-child(6) > div > select")
	private WebElement model;
	
	public WebElement selectModel() {
		return model;
	}
	
	@FindBy(css = "#submit")
	private WebElement search;
	
	public WebElement searchButton() {
		return search;
	}
	
	@FindBy(css = "body > section.dealerResults.js-results.dealerResults--formHidden > section.js-dealer-search-results.dealerList > ul > li:nth-child(1) > article > header > a > span")
	private WebElement dealer;
	
	public WebElement selectDealer() {
		return dealer;
	}
}
