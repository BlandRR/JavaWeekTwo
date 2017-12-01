package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicFunctionalitySelectable {

	
	@FindBy(css = "#selectable > li:nth-child(1)")
	WebElement button1;
	
	@FindBy(css = "#selectable > li:nth-child(2)")
	WebElement button2;
	
	@FindBy(css = "#selectable > li:nth-child(3)")
	WebElement button3;
	
	@FindBy(css = "#selectable > li:nth-child(4)")
	WebElement button4;
	
	@FindBy(css = "#selectable > li:nth-child(5)")
	WebElement button5;
	
	@FindBy(css = "#selectable > li:nth-child(6)")
	WebElement button6;
	
	@FindBy(css = "#selectable > li:nth-child(7)")
	WebElement button7;
	
	@FindBy(css = "#ui-id-2")
	WebElement displayasGrid;
	
	
	
	
	
	public void ClickGrid() {
		displayasGrid.click();
	}
	
}
