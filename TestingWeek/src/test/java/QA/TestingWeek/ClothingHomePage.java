package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingHomePage {

	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	WebElement homepageCreate;
	

	
	public void homepageCreateClick() {
		homepageCreate.click();
	}
	
	
	
}
