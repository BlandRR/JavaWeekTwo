package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderVehicleRegistrationCheckPage {

	@FindBy(css = "#firstSection > div.ContentRow.SearchGradient.Static > div > div.ErrorMessage > h3")
	WebElement regerror;
	
	@FindBy(css = "#body > div.vehicle-check > div.parallax-background > section > div > form > span > input")
	WebElement enterreg;
	
	@FindBy(css = "#firstSection > div.ContentRow.SearchGradient.Static > div > form > input")
	WebElement enterbutton;
	
	public String getregerrormessage() {
		return regerror.getText();
	}
	
	public void setregistration(String newreg) {
		enterreg.sendKeys(newreg);
	}
	
	public void searchregistrationClick() {
		enterbutton.click();
	}
	
	
}
