package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement userfield;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement passfield;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement login;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	WebElement isloginsuccess;
	
	
	public void setuserfield(String name) {
		userfield.sendKeys(name);
	}
	
	public void setpassfield(String name) {
		passfield.sendKeys(name);
	}
	
	public void loginClick() {
		login.click();
	}
	
	public String getisloginsuccess() {
		return isloginsuccess.getText();	
	}
	
	public String getuserfield() {
		return userfield.getText();
	}
	
	public String getpassfield() {
		return passfield.getText();
	}
	
	
}
