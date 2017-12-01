package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiatNewsArticle {

	@FindBy(css = "body > main > div.grid-right-mpu.grid-outer.grid-outer-full > div.cut-1-2-mpu > div.review-page__mainimage.tracking-standard-link.js-images-view-gallery > span.review-page__gallery.body-3.js-images-view-gallery")
	private WebElement fullScreen;
	
	public WebElement fullScreenButton() {
		return fullScreen;
	}
	
	@FindBy(css = "#js-gallery-holder > div.gallery-holder-outer > div.gallery-holder-inner > div > div.initialise__slider.slick-slider.slick-initialized > button.slick-next.tracking-standard-link")
	private WebElement next;
	
	public WebElement nextButton() {
		return next;
	}
}
