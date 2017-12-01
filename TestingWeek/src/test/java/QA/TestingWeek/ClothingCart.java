package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingCart {

	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2")
	WebElement cartText;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	WebElement Checkout; 
	
	public String getcartText() {
		return cartText.getText();
	}
	
	public void CheckoutClick() {
		Checkout.click();
	}
}

