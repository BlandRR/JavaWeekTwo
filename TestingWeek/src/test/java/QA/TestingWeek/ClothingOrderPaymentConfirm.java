package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingOrderPaymentConfirm {

	@FindBy(css = "#cart_navigation > button > span")
	WebElement proceed;
	
	public void proceedClick() {
		proceed.click();
	}
	
}
