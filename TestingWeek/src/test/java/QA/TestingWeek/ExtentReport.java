package QA.TestingWeek;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ExtentReport {

	private String url = "http://thedemosite.co.uk/";
	private static ExtentReports report;
	private WebDriver webDriver;

	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "NewReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
		
	}

	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@AfterClass
	public static void cleanUp() {
		report.flush();
	}

	
	@Test
	public void MyFirstTestReportTest() throws IOException {
		ExtentTest test = report.createTest("MyFirstTest");
		test.log(Status.INFO, "My First Test is Starting ");
	}
	
	
	@Test
	public void Pass() throws IOException {
		ExtentTest test = report.createTest("Pass");
		test.log(Status.PASS, "Pass");
	}
	
	
	
	@Test
	public void Error() throws IOException {
		ExtentTest test = report.createTest("Error");
		test.log(Status.ERROR, "ERROR");
	}
	
	
	
	
	
	

}
