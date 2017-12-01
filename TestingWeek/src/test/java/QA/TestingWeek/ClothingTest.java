package QA.TestingWeek;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;
import junit.framework.Assert;


public class ClothingTest {

	String url = "http://automationpractice.com/index.php";
	private WebDriver webDriver;
	SpreadSheetReader reader = new SpreadSheetReader("Browsers.xlsx");
	SpreadSheetReader userinfo = new SpreadSheetReader("UserInfo.xlsx");

	@Before
	public void setUp() {
		if (reader.readRow(0, "Sheet1").toString().equals("[Chrome]")) {
			webDriver = new ChromeDriver();
		} else if (reader.readRow(0, "Sheet1").toString().equals("[Edge]")) {
			webDriver = new EdgeDriver();

		} else if (reader.readRow(0, "Sheet1").toString().equals("[FireFox]")) {
			webDriver = new FirefoxDriver();
		}
		
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
	 * Must be a new email to be successful
	 * Hard Coded proof of concept
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test
	public void clothingCreate() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		//try {
		authentication.setauthenticationemailCreate("saasdasddj23deoasidf@msn.com\n");
		Thread.sleep(10000);
		
		try {
			if (authentication.getErrorAlreadyExists().equals("An account using this email address has already been registered. Please enter a valid password or request a new one.")) {
				System.out.println("Email Exists");
				ScreenShot screenshot = new ScreenShot();
				screenshot.take(webDriver, "UnableToMakeEmailExists");
				Assert.fail(); 
			}
			}catch (Exception e) {
				System.out.println("New Email!!!! Error Panel Doesnt Exist WOOOOO!!!!");
			}
	

		ClothingFillOutRegistrationForm register = PageFactory.initElements(webDriver,
				ClothingFillOutRegistrationForm.class);
	
		register.gendermaleClick();
		
		if (register.gendermale.isSelected()) {
			report.Pass();
		} else {
			report.Error();
		}
		
		register.setuserfirstName("Billy");
		register.setuserlastName("Bob");
		
		
		/*if (register.userfirstName.getText().equals("Billy") && register.userlastName.getText().equals("Bob")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error name");
			System.out.println(register.userfirstName.getText());
			
		}*/
		
		register.setuserpasswd("12345");

		Select droplistDay = new Select(register.userdobDay);
		droplistDay.selectByValue("4");

		Select droplistMonth = new Select(register.userdobMonth);
		droplistMonth.selectByVisibleText("June ");

		Select droplistYear = new Select(register.userdobYear);
		droplistYear.selectByValue("2000");

		register.setaddressName(register.getuserfirstName());
		register.setaddresslastName(register.getuserlastName());
		
		register.setcompanyName("Magical Things");
		
		register.setaddressFirst("Hogwarts Road");
		
		register.setCity("Bobington");
	
	/*	
		if (register.getcompany().equals("Magical Things") && register.getaddressfirst().equals("Hogwarts Road") && register.getcity().equals("Bobington")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error address");
			
		}*/

		Select dropdownState = new Select(register.state);
		dropdownState.selectByVisibleText("Ohio");

		register.setPostcode("00001");
		register.setMobile("01444875381");
		
	/*	if (register.getpostcode().equals("00001") && register.getmobile().equals("01444875381")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error postcode / number");
		}*/

		
		register.setAlias(register.getaddressFirst());
		register.submitClick();
		Thread.sleep(10000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "ClothingLoginPass");
		}
		
		report.cleanUp();
		
		String currentUrl = webDriver.getCurrentUrl();
		String ExpectedUrl = "http://automationpractice.com/index.php?controller=my-account";

		Assert.assertEquals(ExpectedUrl, currentUrl);

	}
	

	
	
	/**
	 * Must be a new email to be successful
	 * SpreadSheet Usage to fill fields
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test
	public void CreateUserFromSpreadSheet() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		
		authentication.setauthenticationemailCreate(userinfo.input(0, 0));
		authentication.authbuttonClick();
		Thread.sleep(10000);
		
		try {
			if (authentication.getErrorAlreadyExists().equals("An account using this email address has already been registered. Please enter a valid password or request a new one.")) {
				System.out.println("Email Exists");
				ScreenShot screenshot = new ScreenShot();
				screenshot.take(webDriver, "UnableToMakeEmailExists");
				Assert.fail(); 
			}
			}catch (Exception e) {
				System.out.println("New Email!!!! Error Panel Doesnt Exist WOOOOO!!!!");
			}
	

		ClothingFillOutRegistrationForm register = PageFactory.initElements(webDriver,
				ClothingFillOutRegistrationForm.class);
	
		register.gendermaleClick();
		
		if (register.gendermale.isSelected()) {
			report.Pass();
		} else {
			report.Error();
		}
		
		
		register.setuserfirstName(userinfo.input(0, 1));
		register.setuserlastName(userinfo.input(0, 2));
		
		
		
		/*if (register.userfirstName.getText().equals("Billy") && register.userlastName.getText().equals("Bob")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error name");
			System.out.println(register.userfirstName.getText());
			
		}*/
		
		register.setuserpasswd(userinfo.input(0, 3).substring(0,userinfo.input(0, 3).length()-2));
		
		

		Select droplistDay = new Select(register.userdobDay);
		droplistDay.selectByValue("4");

		Select droplistMonth = new Select(register.userdobMonth);
		droplistMonth.selectByVisibleText("June ");

		Select droplistYear = new Select(register.userdobYear);
		droplistYear.selectByValue("2000");

		
		register.setaddressName(userinfo.input(0, 1));
		register.setaddresslastName(userinfo.input(0, 2));
		register.setcompanyName(userinfo.input(0, 4));
		register.setaddressFirst(userinfo.input(0, 5));
		register.setCity(userinfo.input(0, 6));
		
	
	/*	
		if (register.getcompany().equals("Magical Things") && register.getaddressfirst().equals("Hogwarts Road") && register.getcity().equals("Bobington")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error address");
			
		}*/

		Select dropdownState = new Select(register.state);
		dropdownState.selectByVisibleText("Ohio");

		
		register.setPostcode(userinfo.input(0, 7).substring(0,userinfo.input(0, 7).length()-1));
		register.setMobile(userinfo.input(0, 8).substring(0,userinfo.input(0, 8).length()-1));
	
		
	/*	if (register.getpostcode().equals("00001") && register.getmobile().equals("01444875381")) {
			report.Pass();
		} else {
			report.Error();
			System.out.println("error postcode / number");
		}*/

		register.setAlias(userinfo.input(0, 5));
		register.submitClick();
		Thread.sleep(10000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "ClothingLoginPass");
		}
		
		report.cleanUp();
		
		String currentUrl = webDriver.getCurrentUrl();
		String ExpectedUrl = "http://automationpractice.com/index.php?controller=my-account";

		Assert.assertEquals(ExpectedUrl, currentUrl);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void EmailExists() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}
		
		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setauthenticationemailCreate("BillyBobbb@msn.com\n");
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account") && authentication.getErrorAlreadyExists().equals
				("An account using this email address has already been registered. Please enter a valid password or request a new one.")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "EmailAlreadyExists");
		} else {
			report.Error();
		}
		
		report.cleanUp();
		String currentUrl = authentication.getErrorAlreadyExists();
		String ExpectedUrl = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void SignInSuccess() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}
		
		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("BillyBob@msn.com");
		authentication.setuserpasswordSign("12345\n");
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "SignInSuccessful");
		} else {
			report.Error();
		}
		
		report.cleanUp();
		String currentUrl = webDriver.getCurrentUrl();
		String ExpectedUrl = "http://automationpractice.com/index.php?controller=my-account";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void SignInWrongPass() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("BillyBob@msn.com");
		authentication.setuserpasswordSign("1234\n");
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication") && authentication.getnumberofsigninErrors().equals
				("There is 1 error")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "WrongPassword");
		} else {
			report.Error();
		}
	
		report.cleanUp();
		String currentUrl = authentication.getnumberofsigninErrors() + authentication.getsigninError();
		String ExpectedUrl = "There is 1 error" + "Invalid password.";
		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void SignInWrongEmail() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("BillyBob12345@msn.com");
		authentication.setuserpasswordSign("12345\n");
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication") && authentication.getsigninError().equals
				("Authentication failed.")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "WrongEmail");
		} else {
			report.Error();
		}

		report.cleanUp();
		String currentUrl = authentication.getnumberofsigninErrors() + authentication.getsigninError();
		String ExpectedUrl = "There is 1 error" + "Authentication failed.";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void SignInNoEmail() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}
		
		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuserpasswordSign("1234\n");
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication") && authentication.getsigninError().equals
				("An email address required.")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "NoEmail");
		} else {
			report.Error();
		}

		report.cleanUp();
		String currentUrl = authentication.getnumberofsigninErrors() + authentication.getsigninError();
		String ExpectedUrl = "There is 1 error" + "An email address required.";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	
	@Test
	public void SignInNoPassword() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}
		
		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("asdgrgsdf@msn.com\n");
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication") && authentication.getsigninError().equals
				("Password is required.")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "NoPassword");
		} else {
			report.Error();
		}
		
		
		report.cleanUp();
		String currentUrl = authentication.getnumberofsigninErrors() + authentication.getsigninError();
		String ExpectedUrl = "There is 1 error" + "Password is required.";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void SignInSuccessOrderDress() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("BillyBob@msn.com");
		authentication.setuserpasswordSign("12345\n");
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingLoggedInPage loggedin = PageFactory.initElements(webDriver, ClothingLoggedInPage.class);
		loggedin.womensButtonClick();
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?id_category=3&controller=category")) {
			report.Pass();
		} else {
			report.Error();
		}
		

		ClothingWomens womens = PageFactory.initElements(webDriver, ClothingWomens.class);
		womens.womensBlouseClick();
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?id_product=2&controller=product")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingWomensBlouseClass blouse = PageFactory.initElements(webDriver, ClothingWomensBlouseClass.class);
		blouse.whiteClick();
		blouse.purchaseClick();
		Thread.sleep(1000);
		
		if (webDriver.getCurrentUrl().equals(
				"http://automationpractice.com/index.php?id_product=2&controller=product#/size-s/color-white")) {
			report.Pass();
		} else {
			report.Error();
			
		}
		
	
		ClothingCart cart = PageFactory.initElements(webDriver, ClothingCart.class);
		cart.getcartText();
		Thread.sleep(1000);
		
		if (cart.getcartText().equals("Product successfully added to your shopping cart")) {
			report.Pass();
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "AddedToCart");
		} else {
			report.Error();
		}
		
		report.cleanUp();

		String currentUrl = cart.getcartText();
		String ExpectedUrl = "Product successfully added to your shopping cart";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	
	
	
	
	
	@Test
	public void CheckoutWirePayment() throws InterruptedException, IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.MyFirstTestReportTest();
		ClothingHomePage homepage = PageFactory.initElements(webDriver, ClothingHomePage.class);
		homepage.homepageCreateClick();
		
		

		ClothingAuthenticationClass authentication = PageFactory.initElements(webDriver,
				ClothingAuthenticationClass.class);

		authentication.setuseremailsignIn("BillyBob@msn.com");
		authentication.setuserpasswordSign("12345\n");

		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingLoggedInPage loggedin = PageFactory.initElements(webDriver, ClothingLoggedInPage.class);
		loggedin.womensButtonClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?id_category=3&controller=category")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingWomens womens = PageFactory.initElements(webDriver, ClothingWomens.class);
		womens.womensBlouseClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?id_product=2&controller=product")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingWomensBlouseClass blouse = PageFactory.initElements(webDriver, ClothingWomensBlouseClass.class);
		blouse.whiteClick();
		blouse.purchaseClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals(
				"http://automationpractice.com/index.php?id_product=2&controller=product#/size-s/color-white")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingCart cart = PageFactory.initElements(webDriver, ClothingCart.class);

		if (cart.getcartText().equals("Product successfully added to your shopping cart")) {
			report.Pass();
		} else {
			report.Error();
		}

		Thread.sleep(1000);

		cart.CheckoutClick();

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingCheckoutSummary summary = PageFactory.initElements(webDriver, ClothingCheckoutSummary.class);
		summary.procceedClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order&step=1")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingCheckoutAddress address = PageFactory.initElements(webDriver, ClothingCheckoutAddress.class);
		address.procceedClick();
		Thread.sleep(1000);
		if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingCheckoutShipping ship = PageFactory.initElements(webDriver, ClothingCheckoutShipping.class);
		ship.tickconditionsClick();

		if (ship.tickConditions.isSelected()) {
			report.Pass();
		} else {
			report.Error();
		}

		ship.proceedClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?controller=order&multi-shipping=")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingCheckoutPayment pay = PageFactory.initElements(webDriver, ClothingCheckoutPayment.class);
		pay.wirepaymentClick();
		Thread.sleep(1000);

		if (webDriver.getCurrentUrl()
				.equals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment")) {
			report.Pass();
		} else {
			report.Error();
		}

		ClothingOrderPaymentConfirm confirm = PageFactory.initElements(webDriver, ClothingOrderPaymentConfirm.class);
		confirm.proceedClick();
		Thread.sleep(1000);

		ClothingRecipt recipt = PageFactory.initElements(webDriver, ClothingRecipt.class);

		if (recipt.getConfirmation().equals("Your order on My Store is complete.")) {
			ScreenShot screenshot = new ScreenShot();
			screenshot.take(webDriver, "OrderedWhiteBlouseSuccess");
		}

		report.cleanUp();

		String currentUrl = recipt.getConfirmation();
		String ExpectedUrl = "Your order on My Store is complete.";

		Assert.assertEquals(ExpectedUrl, currentUrl);

	}

}
