package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingRecipt {

	@FindBy(css = "#center_column > div > p > strong")
	WebElement confirmation; 
	
	
	public String getConfirmation() {
		return confirmation.getText();
	}
}
