package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingLoggedInPage {

	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
	WebElement womensButton;
	

	public void womensButtonClick() {
		womensButton.click();
	}
}
