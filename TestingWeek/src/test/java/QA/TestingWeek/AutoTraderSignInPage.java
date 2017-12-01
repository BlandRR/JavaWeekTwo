package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderSignInPage {

	
	@FindBy(css = "#js-social__signin > div > form > span:nth-child(8) > div")
	WebElement errormessage;
	
	@FindBy(id = "signin-email")
	WebElement signinemail;
	
	@FindBy(id = "signin-password")
	WebElement signinpassword;
	
	@FindBy(id = "signInSubmit")
	WebElement submitsignin;
	
	public void setsigninemail(String email) {
		signinemail.sendKeys(email);
	}
		
	public void setsigninpassword(String pass) {
		signinpassword.sendKeys(pass);
	}
	
	public String geterrormessage() {
		return errormessage.getText();
	}
	
	public void submitbuttonClick() {
		submitsignin.click();
	}
	
}
