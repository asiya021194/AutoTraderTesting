package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div > a")
	private WebElement signIn;
	
	public void toSignIn() {
		signIn.click();
	}
	
	@FindBy(css = "#postcode")
	private WebElement postcode;
	
	public WebElement insertPostcode() {
		return postcode;
	}
	
	@FindBy(css = "#radius")
	private WebElement distance;
	
	public WebElement selectDistance() {
		return distance;
	}
	
	@FindBy(css = "#searchVehiclesMake")
	private WebElement make;
	
	public WebElement selectMake() {
		return make;
	}
	
	@FindBy(css = "#searchVehiclesModel")
	private WebElement model;
	
	public WebElement selectModel() {
		return model;
	}
	
	@FindBy(css = "#searchVehiclesPriceFrom")
	private WebElement minPrice;
	
	public WebElement selectMinPrice() {
		return minPrice;
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
	
	@FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-buying > a")
	private WebElement buyingNewUsedCar;
	
	public WebElement buyCarNavBar() {
		return buyingNewUsedCar;
	}
	
	@FindBy(css = "#buying-new-used > li.header__sub-nav-listing.header__sub-nav-listing--2 > a")
	private WebElement newCar;
	
	public WebElement buyNewCar() {
		return newCar;
	}
	
	@FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-content > a")
	private WebElement carReviews;
	
	public WebElement carReviewsBar() {
		return carReviews;
	}
	
	@FindBy(css = "#car-reviews > li.header__sub-nav-listing.header__sub-nav-listing--1 > a")
	private WebElement latest;
	
	public WebElement latestReviews() {
		return latest;
	}
	
	@FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-product > a")
	private WebElement finance;
	
	public WebElement financeBar() {
		return finance;
	}
	
	@FindBy(css = "#other-services > li.header__sub-nav-listing.header__sub-nav-listing--1 > a")
	private WebElement insurance;
	
	public WebElement insuranceTab() {
		return insurance;
	}
	
	@FindBy(css = "body > main > div > section.is-non-critical > section.alt-search__nav.t-row > a:nth-child(3) > figure > div > img")
	private WebElement dealerLink;
	
	public WebElement toDealerPage() {
		return dealerLink;
	}
}
