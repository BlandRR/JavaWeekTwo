package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingCheckoutAddress {

	@FindBy(css = "#center_column > form > p > button > span")
	WebElement procceed;
	
	public void procceedClick() {
		procceed.click();
	}
}
