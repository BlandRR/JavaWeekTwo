package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingAuthenticationClass {

	@FindBy(id = "email_create")
	WebElement authenticationemailCreate;
	
	@FindBy(css = "#create_account_error > ol > li")
	WebElement ErrorAlreadyExists;
	
	@FindBy(id = "email")
	WebElement useremailsignIn;
	
	@FindBy(id = "passwd")
	WebElement userpasswordSign;
	
	@FindBy(css = "#center_column > div.alert.alert-danger > p")
	WebElement numberofsigninErrors;
	
	@FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
	WebElement signinError;
	
	@FindBy(css = "#SubmitCreate > span")
	WebElement clickauth;
	
	public String getErrorAlreadyExists() {
		return  ErrorAlreadyExists.getText();
	}
	
	public String getauthenticationemailCreate() {
		return authenticationemailCreate.getText(); 
	}
	
	public void setauthenticationemailCreate(String email) {
		authenticationemailCreate.sendKeys(email);
	}
	
	public void setuseremailsignIn(String email) {
		useremailsignIn.sendKeys(email);
	}
	
	public void setuserpasswordSign(String pass) {
		userpasswordSign.sendKeys(pass);
	}
	
	
	public String getnumberofsigninErrors() {
		return numberofsigninErrors.getText();
	}
	
	public String getsigninError() {
		return signinError.getText();
	}
	
	public void authbuttonClick() {
		clickauth.click();
	}
}
