package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridSelectable {


	@FindBy(css = "#selectable_grid > li:nth-child(1)")
	WebElement grid1;
	
	@FindBy(css = "#selectable_grid > li:nth-child(2)")
	WebElement grid2;
	
	@FindBy(css = "#selectable_grid > li:nth-child(3)")
	WebElement grid3;
	
	@FindBy(css = "#selectable_grid > li:nth-child(4)")
	WebElement grid4;
	
	@FindBy(css = "#selectable_grid > li:nth-child(5)")
	WebElement grid5;
	
	@FindBy(css = "#selectable_grid > li:nth-child(6)")
	WebElement grid6;
	
	@FindBy(css = "#selectable_grid > li:nth-child(7)")
	WebElement grid7;
	
	@FindBy(css = "#selectable_grid > li:nth-child(8)")
	WebElement grid8;
	
	@FindBy(css = "#selectable_grid > li:nth-child(9)")
	WebElement grid9;
	
	@FindBy(css = "#selectable_grid > li:nth-child(10)")
	WebElement grid10;
	
	@FindBy(css = "#selectable_grid > li:nth-child(11)")
	WebElement grid11;
	
	@FindBy(css = "#selectable_grid > li:nth-child(12)")
	WebElement grid12;
	
	
	public void grid1click() {
		grid1.click();
	}
	public void grid2click() {
		grid2.click();
	}
	public void grid3click() {
		grid3.click();
	}
	public void grid4click() {
		grid4.click();
	}
	
}
