package QA.TestingWeek;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;

public class ObjectTest {

	private String url = "http://thedemosite.co.uk/";
	private WebDriver webDriver;

	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@Test
	public void TestopenNewUser() {

		webDriver.navigate().to(url);
		HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.createnewuserClick();

		String currentUrl = webDriver.getCurrentUrl();
		String ExpectedUrl = "http://thedemosite.co.uk/addauser.php";

		Assert.assertEquals(ExpectedUrl, currentUrl);
	}

	@Test
	public void TestcreatenewUserPass() {

		webDriver.navigate().to(url);
		
		HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.createnewuserClick();

		CreateNewUserPage create = PageFactory.initElements(webDriver, CreateNewUserPage.class);
		create.setCreateuserName("Blandy");
		create.setCreatePassword("pass");
		create.savenewUserClick();

		String usersaved = create.getSavedUser();
		String ExpectedUrl = "The username: Blandy\nThe password: pass";

		Assert.assertEquals(ExpectedUrl, usersaved);
	}

	@Test
	public void TestLogin() {

		webDriver.navigate().to(url);
		
		HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.createnewuserClick();

		CreateNewUserPage create = PageFactory.initElements(webDriver, CreateNewUserPage.class);
		create.setCreateuserName("Blandy");
		create.setCreatePassword("pass");
		create.savenewUserClick();
		create.loginButtonClick(); 

		LoginPage login = PageFactory.initElements(webDriver, LoginPage.class);
		login.setuserfield("Blandy");
	
		login.setpassfield("pass");
		login.loginClick();

		String userloggedin = login.getisloginsuccess();
		String ExpectedUrl = "**Successful Login**";
		
		Assert.assertEquals(ExpectedUrl, userloggedin);
	}

	
	
	ArrayList<String> spread = new ArrayList<String>();
	@Test
	public void TestLoginFail() throws IOException {

		webDriver.navigate().to(url);
		ExtentReport report = new ExtentReport();
		report.init();
		report.setUp();
		report.MyFirstTestReportTest();
		
		HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.createnewuserClick();
		
		CreateNewUserPage create = PageFactory.initElements(webDriver, CreateNewUserPage.class);
		
		create.setCreateuserName("Blandy");
		
		
		create.setCreatePassword("pass");
		
		
		create.savenewUserClick();

		create.loginButtonClick();

		LoginPage login = PageFactory.initElements(webDriver, LoginPage.class);
		login.setuserfield("Blandy");
		spread.add(login.getuserfield());
		
		login.setpassfield("pass");
		spread.add(login.getpassfield());
		
		login.loginClick();

		
		String userloggedin = login.getisloginsuccess();
		String ExpectedUrl = "**Successful Login**";
		
		ScreenShot screenshot = new ScreenShot();
		if (login.getisloginsuccess().equals("**Successful Login**")) {
			screenshot.take(webDriver, "loginpass");
			report.Pass();
		}
		else {
			screenshot.take(webDriver, "loginfail");
			report.Error();
		}
		
		if (login.getisloginsuccess().equals(ExpectedUrl)) {
			report.Pass();
		}
		else {
			report.Error();
		}
		
		SpreadSheetReader spreadsheetreader = new SpreadSheetReader("Sheet.xlsx");
			for (int i =0; i < spread.size(); i++) {
			if (spread.get(i).equals(spreadsheetreader.readRow(0, "Sheet1").toString())){
				report.Pass();
			} else {
				report.Error();
			}
		}
		
		
		
		report.tearDown();
		report.cleanUp();
		Assert.assertEquals(ExpectedUrl, userloggedin); 	
	}

}
