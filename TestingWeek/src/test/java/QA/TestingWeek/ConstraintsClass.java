package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstraintsClass {

	@FindBy(id = "draggabl")
	WebElement verticleBox;
	
	@FindBy(id = "draggabl2")
	WebElement horizontalBox;
	
	@FindBy(id = "draggabl3")
	WebElement containedBox;
	
	@FindBy(id = "draggabl5")
	WebElement inParent;

	@FindBy(id = "containment-wrapper")
	WebElement wrapper;
	
	
	
	
	
	
}
