package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurance {
	
	@FindBy(css = "body > section.compare-insurance.top-section.section-dark > div > div > div > a.tracking-motoring-products-link.compare-insurance-cta__button.external")
	private WebElement getQuote;
	
	public WebElement getQuoteButton() {
		return getQuote;
	}
}
