package qa.consulting.com.AutotraderTesting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qa.consulting.com.AutotraderTesting.ScreenShot;
import qa.consulting.com.AutotraderTesting.SpreadSheetReader;

public class AutoTraderTest {

	private static ExtentReports report;
	private WebDriver webDriver;
	private SpreadSheetReader spreadSheetReader;
	private ScreenShot screenShot;

	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "AutoTraderReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}

	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		spreadSheetReader = new SpreadSheetReader("autotrader.xlsx");
		screenShot = new ScreenShot();
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@AfterClass
	public static void cleanUp() {
		report.flush();
	}

	public void timePause(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void signUpTest() {

		ExtentTest test = report.createTest("SignUpTest");
		test.log(Status.INFO, "My test for creating an account is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		homePage.toSignIn();
		test.log(Status.INFO, "Navigating to the sign in page");

		SignInPage signInPage = PageFactory.initElements(webDriver, SignInPage.class);
		signInPage.signUpTab();
		test.log(Status.INFO, "Navigating to the sign up tab");

		traderList = spreadSheetReader.readRow(1, "auto");
		String email = traderList.get(1);
		test.log(Status.DEBUG, "Email: " + email);
		signInPage.createEmail().sendKeys(email);
		test.log(Status.INFO, "Inserting email");

		traderList = spreadSheetReader.readRow(2, "auto");
		String password = traderList.get(1);
		test.log(Status.DEBUG, "Password: " + password);
		signInPage.createPassword().sendKeys(password);
		test.log(Status.INFO, "Inserting password");

		timePause(2);

		signInPage.signUpButton();
		test.log(Status.INFO, "Sign up");
	}

	@Test
	public void findCarTest() {

		ExtentTest test = report.createTest("FindNewUsedCarTest");
		test.log(Status.INFO, "My test for finding a used or new car is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

		traderList = spreadSheetReader.readRow(3, "auto");
		String postcode = traderList.get(1);
		test.log(Status.DEBUG, "Postcode: " + postcode);
		homePage.insertPostcode().sendKeys(postcode);
		test.log(Status.INFO, "Inserting postcode");

		traderList = spreadSheetReader.readRow(4, "auto");
		String distance = traderList.get(1);
		test.log(Status.DEBUG, "Select distance: " + distance);
		homePage.selectDistance().sendKeys(distance);
		test.log(Status.INFO, "Selecting distance");

		traderList = spreadSheetReader.readRow(5, "auto");
		String make = traderList.get(1);
		test.log(Status.DEBUG, "Make: " + make);
		homePage.selectMake().sendKeys(make);
		test.log(Status.INFO, "Selecting make");

		timePause(5);

		traderList = spreadSheetReader.readRow(7, "auto");
		String minPrice = traderList.get(1);
		test.log(Status.DEBUG, "Minimum Price: " + minPrice);
		homePage.selectMinPrice().sendKeys(minPrice);
		test.log(Status.INFO, "Selecting minimum price");

		timePause(2);

		traderList = spreadSheetReader.readRow(8, "auto");
		String maxPrice = traderList.get(1);
		test.log(Status.DEBUG, "Maximum Price: " + maxPrice);
		homePage.selectMaxPrice().sendKeys(maxPrice);
		test.log(Status.INFO, "Selecting maximum price");

		timePause(3);

		homePage.searchButton().click();
		test.log(Status.INFO, "Cars found according to preference");

		timePause(5);

		try {
			screenShot.take(webDriver, "Cars");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void newCarTest() {

		ExtentTest test = report.createTest("NewCarTest");
		test.log(Status.INFO, "My test for finding new car using navigation bar is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		homePage.buyCarNavBar().click();
		timePause(2);
		homePage.buyNewCar().click();
		timePause(2);

		ViewNewCar newCar = PageFactory.initElements(webDriver, ViewNewCar.class);

		traderList = spreadSheetReader.readRow(3, "auto");
		String postcode = traderList.get(1);
		test.log(Status.DEBUG, "Postcode: " + postcode);
		newCar.insertPostcode().sendKeys(postcode);
		test.log(Status.INFO, "Inserting postcode");

		traderList = spreadSheetReader.readRow(5, "auto");
		String make = traderList.get(1);
		test.log(Status.DEBUG, "Make: " + make);
		newCar.selectMake().sendKeys(make);
		test.log(Status.INFO, "Selecting make");

		timePause(2);

		traderList = spreadSheetReader.readRow(8, "auto");
		String maxPrice = traderList.get(1);
		test.log(Status.DEBUG, "Maximum Price: " + maxPrice);
		newCar.selectMaxPrice().sendKeys(maxPrice);
		test.log(Status.INFO, "Selecting maximum price");

		timePause(2);

		newCar.searchButton().click();
		test.log(Status.INFO, "Cars found according to preference from navigation bar");
		try {
			screenShot.take(webDriver, "FindingCar");
		} catch (IOException e) {
			e.printStackTrace();
		}
		timePause(2);
	}

	@Test
	public void carGalleryTest() {
		ExtentTest test = report.createTest("GalleryTest");
		test.log(Status.INFO, "My test for car gallery is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		homePage.carReviewsBar().click();
		test.log(Status.INFO, "Navigate to Car Reviews using the navigation bar");
		timePause(2);
		homePage.latestReviews().click();
		test.log(Status.INFO, "Navigate to Latest Reviews using the navigation bar");
		timePause(2);

		CarReviewsVideos carGallery = PageFactory.initElements(webDriver, CarReviewsVideos.class);

		traderList = spreadSheetReader.readRow(5, "auto");
		String make = traderList.get(1);
		test.log(Status.DEBUG, "Make: " + make);
		carGallery.searchMake().sendKeys(make);
		test.log(Status.INFO, "Selecting make");
		timePause(2);
		traderList = spreadSheetReader.readRow(6, "auto");
		String model = traderList.get(1);
		test.log(Status.DEBUG, "Model: " + model);
		carGallery.searchModel().sendKeys(model);
		test.log(Status.INFO, "Selecting model");
		timePause(2);
		carGallery.searchButton().click();
		test.log(Status.INFO, "Search");
		timePause(2);

		carGallery.reviewArticle().click();
		test.log(Status.INFO, "Selecting the article");

		FiatNewsArticle news = PageFactory.initElements(webDriver, FiatNewsArticle.class);
		news.fullScreenButton().click();
		timePause(2);
		for (int i = 0; i < 10; i++) {
			news.nextButton().click();
			test.log(Status.INFO, "Next image");
			try {
				screenShot.take(webDriver, "Car" + i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			timePause(2);
		}
	}
	
	@Test
	public void carInsuranceTest() {
		
		ExtentTest test = report.createTest("CarInsuranceTest");
		test.log(Status.INFO, "My test for to get a quote for my car is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		homePage.financeBar().click();
		test.log(Status.INFO, "Navigating to Finance, Insurance & More tab on the navigation bar");
		timePause(2);
		homePage.insuranceTab().click();
		test.log(Status.INFO, "Navigating to Car Insurance page from the navigation bar");
		timePause(2);
		
		CarInsurance quote = PageFactory.initElements(webDriver, CarInsurance.class);
		
		try {
			quote.getQuoteButton().click();
			screenShot.take(webDriver, "ExternalWebsite");
			timePause(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Navigating to external website to obtain a quote for my car");
	}
	
	@Test
	public void imageLinkTest() {
		
		ExtentTest test = report.createTest("DealerTest");
		test.log(Status.INFO, "My test for to find a dealer is starting.");
		List<String> traderList = new ArrayList<String>();

		traderList = spreadSheetReader.readRow(0, "auto");
		webDriver.navigate().to(traderList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");

		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		homePage.toDealerPage().click();
		test.log(Status.INFO, "Navigating to finding a dealer page using an image");
		
		DealerPage dealer = PageFactory.initElements(webDriver, DealerPage.class);
		
		traderList = spreadSheetReader.readRow(3, "auto");
		String postcode = traderList.get(1);
		test.log(Status.DEBUG, "Postcode: " + postcode);
		dealer.insertPostcode().sendKeys(postcode);
		test.log(Status.INFO, "Inserting postcode");

		timePause(2);
		
		traderList = spreadSheetReader.readRow(5, "auto");
		String make = traderList.get(1);
		test.log(Status.DEBUG, "Make: " + make);
		dealer.selectMake().sendKeys(make + "\n");
		test.log(Status.INFO, "Selecting make");

		timePause(2);
		
		traderList = spreadSheetReader.readRow(6, "auto");
		String model = traderList.get(1);
		test.log(Status.DEBUG, "Model: " + model);
		dealer.selectModel().sendKeys(model + "\n");
		test.log(Status.INFO, "Selecting model");
		
		timePause(2);
		
		dealer.searchButton().click();
		test.log(Status.INFO, "Search");
		timePause(2);
		
		dealer.selectDealer().click();
		try {
			screenShot.take(webDriver, "Dealer");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Selecting a dealer");
		
		
	}
	
	
}
