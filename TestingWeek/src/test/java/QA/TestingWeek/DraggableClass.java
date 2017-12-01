package QA.TestingWeek;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraggableClass {

	@FindBy(css = "#draggable")
	WebElement dragbox;

	@FindBy(css = "#ui-id-2")
	WebElement constaintmovement;
	
	
	@FindBy(id = "ui-id-3")
	WebElement cursorStyle;
	
	@FindBy(id = "ui-id-4")
	WebElement events;
	
	@FindBy(id = "ui-id-5")
	WebElement draggable;
	
	
	

	public void clickconstraints() {
		constaintmovement.click();
	}
	
	public void clickcursorStyle() {
		cursorStyle.click();
	}

	public void clickEvents() {
		events.click();
	}

	public void clickDrag() {
		draggable.click();
	}
	
	
	}
