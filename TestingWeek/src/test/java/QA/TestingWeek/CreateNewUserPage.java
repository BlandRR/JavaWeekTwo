package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewUserPage {

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement createuserName;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement createPassword;

	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement savenewUser;
	
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > blockquote > blockquote:nth-child(2) > blockquote")
	WebElement savedUser;
	
	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	WebElement loginButton;
	
	public String getCreateuserName() {
		return createuserName.getText();
	}

	public void setCreateuserName(String name) {
		createuserName.sendKeys(name);
	}

	public String getCreatePassword() {
		return createPassword.getText();
	}

	public void setCreatePassword(String pass) {
		createPassword.sendKeys(pass);;
	}

	public void savenewUserClick() {
		savenewUser.click();
	}
	
	public String getSavedUser() {
		return savedUser.getText();
		
	}
	
	public void loginButtonClick() {
		loginButton.click();
	}
	
	
	
	
}
