package QA.TestingWeek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SelectableRunner {

	String url = "http://demoqa.com/selectable/";
	
	
	private WebDriver webDriver;

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
	
	
	@Test
	public void SelectItems1to4() throws InterruptedException {

		webDriver.navigate().to(url);
		BasicFunctionalitySelectable select = PageFactory.initElements(webDriver, BasicFunctionalitySelectable.class);
		Actions builder = new Actions(webDriver);

		boolean currentlyselected = false;
		builder.clickAndHold(select.button1).moveByOffset(0, 100).release().build().perform();
		
		
		builder.clickAndHold(select.button1).moveByOffset(0, 100).release().build().perform(); 
			if (select.button1.isSelected() == true && select.button2.isSelected() == true && select.button3.isSelected() == true && select.button4.isSelected() == true) {
			currentlyselected = true;
			}
		Thread.sleep(1000);
		boolean currentlocation = currentlyselected;
		boolean expectedlocation = true;

		Assert.assertEquals(expectedlocation, currentlocation);
	}
	
	
	
	@Test
	public void SelectGridOne() throws InterruptedException {

		webDriver.navigate().to(url);
		boolean currentlyselected = false;
		BasicFunctionalitySelectable select = PageFactory.initElements(webDriver, BasicFunctionalitySelectable.class);
		select.ClickGrid();
		
		GridSelectable grid = PageFactory.initElements(webDriver, GridSelectable.class);
		Actions builder = new Actions(webDriver);
		
	
		
		if (builder.click(grid.grid1) != null) {
			currentlyselected = true;
		}
		
		
		boolean currentlocation = currentlyselected;
		
		boolean expectedlocation = true;

		Assert.assertEquals(expectedlocation, currentlocation);
		
	}
}
