package QA.TestingWeek;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import QA.TestingWeek.AutoTraderHomePage;
import QA.TestingWeek.ExtentReport;
import junit.framework.Assert;

public class AutoTraderMain {

	String url = "https://www.autotrader.co.uk";
	private WebDriver webDriver;
	SpreadSheetReader userinfo = new SpreadSheetReader("UserInfo.xlsx");

	@Before
	public void setUp() {

		webDriver = new ChromeDriver();

		JavascriptExecutor js;
		if (webDriver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) webDriver;
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	/**
	 * Given a postcode should show a list of cars near that postcode
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void searchviavalidpostCode() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.setpostcode("CV77UG");
		home.searchcarsClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals(
				"https://www.autotrader.co.uk/car-search?advertising-location=at_cars&search-target=usedcars&is-quick-search"
						+ "=true&radius=&onesearchad=used&onesearchad=nearlynew&onesearchad=new&make=&price-from=&price-to=&postcode=cv77ug")) {
			report.Pass();
			report.cleanUp();
			Assert.assertTrue(true);
		} else {
			report.Error();
			report.cleanUp();
			Assert.fail();
		}
	}

	/**
	 * Given an illegal postcode an error box should be thrown
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void searchviainvalidpostCode() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.setpostcode("M505SD");
		home.searchcarsClick();
		Thread.sleep(1000);

		AutoTraderSearchCars search = PageFactory.initElements(webDriver, AutoTraderSearchCars.class);

		try {
			if (search.getpostcodeerror()
					.equals("Please enter a valid UK postcode to see accurate results.\n" + "Continue")) {
				System.out.println("Invalid PostCode");
				ScreenShot screenshot = new ScreenShot();
				report.Pass();
				report.cleanUp();
				screenshot.take(webDriver, "Invalid Post Code");
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println("Is a valid postCode");
			report.Error();
			report.cleanUp();
			Assert.fail();
		}
	}

	/**
	 * Given a postcode and using the make selector
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	public void searchforanAudi() throws InterruptedException, IOException {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> cars = new ArrayList<String>();
		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.setpostcode("CV77UG");

		Select droplistMake = new Select(home.vehiclemake);
		 droplistMake.selectByValue("AUDI");
		

		home.searchcarsClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals(
				"https://www.autotrader.co.uk/car-search?advertising-location=at_cars&search-target=usedcars&is-quick-search=true&radius=&onesearchad=used&onesearchad=nearlynew&onesearchad=new&make=AUDI&price-from=&price-to=&postcode=cv77ug")) {

			report.Pass();
			report.cleanUp();
			Assert.assertTrue(true);
		} else if (webDriver.getCurrentUrl().equals(
				"https://www.autotrader.co.uk/car-search?advertising-location=at_cars&search-target=usedcars&is-quick-search=true&radius=&onesearchad=used&onesearchad=nearlynew&onesearchad=new&make=AUDI&model=&price-from=&price-to=&postcode=cv77ug")) {
			report.Pass();
			report.cleanUp();
			Assert.assertTrue(true);
		} else {
			report.Error();
			Assert.fail();
		}
	}

	/**
	 * Try to click model which is not enabled until make is filled in
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void SelectModelInvalid() throws InterruptedException, IOException {
		ArrayList<String> make = new ArrayList<String>();
		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.setpostcode("CV77UG");

		try {
			Select droplistMake = new Select(home.vehcilemodel);
			droplistMake.selectByIndex(8);

			report.Error();
			report.cleanUp();
			Assert.fail();

		} catch (Exception e) {
			System.out.println("Cant Select Make Without First Selecting Model");
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "ModelUnselectable");
			report.Pass();
			report.cleanUp();
			Assert.assertTrue(true);
		}
	}

	
	/**
	 * Enter a valid postcode, make and model to show a search page for that model 
	 * !! Works on and off 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	public void SelectModelValid() throws InterruptedException, IOException {
		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.setpostcode("CV77UG");

		Select droplistMake = new Select(home.vehiclemake);
		droplistMake.selectByValue("AUDI");
		Thread.sleep(100);

		try {
			Select droplistModel = new Select(home.vehcilemodel);
			droplistModel.selectByValue("A7");
		} catch (Exception e) {
			System.out.println("Cant Select Make Without First Selecting Model");
			report.Error();
			report.cleanUp();
			Assert.fail();
		}

		home.searchcarsClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals(
				"https://www.autotrader.co.uk/car-search?advertising-location=at_cars&search-target=usedcars&is-quick-search=true&radius=&onesearchad=used&onesearchad=nearlynew&onesearchad=new&make=AUDI&model=A7&price-from=&price-to=&postcode=cv77ug")) {
			report.Pass();
			report.cleanUp();
			Assert.assertTrue(true);
		} else {
			report.Error();
			report.cleanUp();
			Assert.fail();
		}
	}


	/**
	 * Click on the sign in button move to sign in page
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void MoveToSigninPage() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.singinButtonClick();
		Thread.sleep(1000);

		String actual = webDriver.getCurrentUrl();
		String expected = "https://www.autotrader.co.uk/secure/signin?after-sigin-url=/";
		Assert.assertEquals(expected, actual);
		
	}
	
	
	

	/**
	 * Try to sign in with no email
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void SignInNoEmail() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.singinButtonClick();
		Thread.sleep(1000);
		
		AutoTraderSignInPage signin = PageFactory.initElements(webDriver, AutoTraderSignInPage.class);

		signin.setsigninpassword(userinfo.input(5, 1));
		signin.submitbuttonClick();
		
		try {
			signin.geterrormessage();
			if (signin.geterrormessage().equals("Your email or password was incorrect. Please try again.")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("No error message");
			Assert.fail();
		}	
	}
	
	
	/**
	 * Try to sign in with no password
	 * Call inputs from a spreadsheet file
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void SignInNoPassword() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();

		AutoTraderHomePage home = PageFactory.initElements(webDriver, AutoTraderHomePage.class);

		home.singinButtonClick();
		Thread.sleep(1000);
		
		AutoTraderSignInPage signin = PageFactory.initElements(webDriver, AutoTraderSignInPage.class);
		
		signin.setsigninemail(userinfo.input(5, 0));
		signin.submitbuttonClick();
		
		try {
			signin.geterrormessage();
			if (signin.geterrormessage().equals("Your email or password was incorrect. Please try again.")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("No error message");
			Assert.fail();
		}	
	}
	
	
/*	
	@Test
	public void VehicleRegWrong() throws InterruptedException, IOException {

		webDriver.navigate().to("https://www.autotrader.co.uk/vehiclecheck");
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		
		AutoTraderVehicleRegistrationCheckPage reg = PageFactory.initElements(webDriver, AutoTraderVehicleRegistrationCheckPage.class);
		
		reg.setregistration(userinfo.input(5, 2));
		reg.searchregistrationClick();
		
		try {
		reg.getregerrormessage();
		}
		catch (Exception e){	
			System.out.println("Error message doesnt exist registration valid");
			report.cleanUp();
			Assert.fail();
			
		}
		
		if (reg.getregerrormessage().equals("Sorry, we didn't recognise that registration.")) {
			String actual = reg.getregerrormessage();
			String expected = "Sorry, we didn't recognise that registration.";
			Assert.assertEquals(expected, actual);
			
		}
	}*/
	

}
