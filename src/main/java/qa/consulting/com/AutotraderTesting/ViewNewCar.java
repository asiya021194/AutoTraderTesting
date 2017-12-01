package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewNewCar {
	
	@FindBy(css = "#postcode")
	private WebElement postcode;
	
	public WebElement insertPostcode() {
		return postcode;
	}
	
	@FindBy(css = "#searchVehiclesMake")
	private WebElement make;
	
	public WebElement selectMake() {
		return make;
	}
	
	@FindBy(css = "#searchVehiclesPriceTo")
	private WebElement maxPrice;
	
	public WebElement selectMaxPrice() {
		return maxPrice;
	}

	@FindBy(css = "#searchVehiclesCount")
	private WebElement search;
	
	public WebElement searchButton() {
		return search;
	}
}
