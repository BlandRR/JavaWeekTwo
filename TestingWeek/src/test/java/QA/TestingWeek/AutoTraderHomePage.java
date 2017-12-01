package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderHomePage {

		
		@FindBy(id = "postcode")
		WebElement postcode;
		
		
		@FindBy (id = "searchVehiclesCount")
		WebElement searchcars;
		
		
		@FindBy(id = "searchVehiclesMake")
		WebElement vehiclemake;
		
		
		@FindBy(id = "searchVehiclesModel")
		WebElement vehcilemodel;
		
		@FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div > a")
		WebElement signinButton;
		
		
		@FindBy(css = "#body > main > div > section.is-non-critical > section.products__nav.cars > a:nth-child(4) > figure > section > span")
		WebElement vehicleregbutton;
		
		
		public void regbuttonClick() {
			vehicleregbutton.click();
		}
		
		public void setpostcode(String code) {
			postcode.sendKeys(code);
		}
		
		public void searchcarsClick() {
			searchcars.click();
		}
		
		public String getVehicleMake() {
			return vehiclemake.getText();
		}
		
		public void postcodeClick() {
			postcode.click();
		}
		
		public void vehiclemakeClick() {
			vehiclemake.click();
		}

	
		public void singinButtonClick() {
			signinButton.click();
		}
		
}

