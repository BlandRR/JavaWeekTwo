package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderSearchCars {

	@FindBy (id = "postcode-lightbox")
	WebElement postcodeerrorbox;
	
	
	public String getpostcodeerror() {
		return postcodeerrorbox.getText();
	}
	
}
