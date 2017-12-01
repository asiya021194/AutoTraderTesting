package qa.consulting.com.AutotraderTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarReviewsVideos {

	@FindBy(css = "body > div.content__search-bar > div > form > div:nth-child(1) > select")
	private WebElement make;

	public WebElement searchMake() {
		return make;
	}

	@FindBy(css = "body > div.content__search-bar > div > form > div:nth-child(2) > select")
	private WebElement model;

	public WebElement searchModel() {
		return model;
	}

	@FindBy(css = "body > div.content__search-bar > div > form > button")
	private WebElement search;

	public WebElement searchButton() {
		return search;
	}

	@FindBy(css = "body > main > section.content-page__main.cf > article.article1.review-page--review-all-article.cf > span.review-page--review-all-text.cf > h2 > a")
	private WebElement article;

	public WebElement reviewArticle() {
		return article;
	}

}
