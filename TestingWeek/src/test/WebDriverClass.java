package QA.TestingWeek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.Assert;

public class WebDriverClass {

	private String url = "https://github.com/login";
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
	public void Test() {
	
		webDriver.navigate().to(url);
		
		WebElement username = webDriver.findElement(By.cssSelector("#login_field"));
		username.sendKeys("BlandRR");
		
		WebElement pass = webDriver.findElement(By.cssSelector("#password"));
		pass.sendKeys("02460Qa!\n");
		
	
		String CurrentUrl = webDriver.getCurrentUrl();
		String ExpectedUrl = "https://github.com/";
		
		Assert.assertEquals(ExpectedUrl, CurrentUrl);
	}
	
	
}
