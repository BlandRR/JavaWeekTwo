package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingCheckoutPayment {

	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	WebElement wirePayment; 
	
	public void wirepaymentClick() {
		wirePayment.click();
	}
	
}
