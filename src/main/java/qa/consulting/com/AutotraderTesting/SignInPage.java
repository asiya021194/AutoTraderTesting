package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	
	@FindBy(css = "#js-social__signup-tab > span")
	private WebElement signUp;
	
	public void signUpTab() {
		signUp.click();
	}
	
	@FindBy(css = "#email")
	private WebElement addEmail;
	
	public WebElement createEmail() {
		return addEmail;
	}
	
	@FindBy(css = "#password")
	private WebElement addPassword;
	
	public WebElement createPassword() {
		return addPassword;
	}
	
	@FindBy(css = "#social--signup--submit")
	private WebElement submit;
	
	public void signUpButton() {
		submit.click();
	}

}
