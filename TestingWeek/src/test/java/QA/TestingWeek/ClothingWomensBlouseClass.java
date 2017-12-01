package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingWomensBlouseClass{

	@FindBy(id = "color_11")
	WebElement colourBlack;
	
	@FindBy(id = "color_8")
	WebElement colourWhite;
	
	@FindBy(id = "add_to_cart")
	WebElement addtoCart;
	
	public void blackClick() {
		colourBlack.click();
	}
	
	public void whiteClick() {
		colourWhite.click();
	}
	
	public void purchaseClick() {
		addtoCart.click();
	}
	
}

