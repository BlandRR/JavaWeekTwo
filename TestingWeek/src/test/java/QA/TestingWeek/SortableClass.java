package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortableClass {

	
	@FindBy(id = "draggablebox")
	WebElement draggablebox;
	
	@FindBy(css = "#sortablebox > li:nth-child(1)")
	WebElement sortablebox1;
	
	@FindBy(css = "#sortablebox > li:nth-child(2)")
	WebElement sortablebox2;
	
	@FindBy(css = "#sortablebox > li:nth-child(3)")
	WebElement sortablebox3;
	
	@FindBy(css = "#sortablebox > li:nth-child(4)")
	WebElement sortablebox4;
	
	@FindBy(css = "#sortablebox > li:nth-child(5)")
	WebElement sortablebox5;
	

	
	
	
	
	
	
}
