package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingWomens {

	@FindBy(css = "#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
	WebElement womensBlouse;
	
	
	public void womensBlouseClick() {
		womensBlouse.click();
	}
}
