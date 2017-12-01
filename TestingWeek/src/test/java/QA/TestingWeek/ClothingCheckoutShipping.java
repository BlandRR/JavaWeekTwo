package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingCheckoutShipping {

	
	@FindBy(id = "cgv")
	WebElement tickConditions; 
	
	@FindBy(css = "#form > p > button > span")
	WebElement proceed; 
	
	
	
	public void tickconditionsClick() {
		tickConditions.click();
	}
	
	
	public void proceedClick() {
		proceed.click();
	}
	
}
