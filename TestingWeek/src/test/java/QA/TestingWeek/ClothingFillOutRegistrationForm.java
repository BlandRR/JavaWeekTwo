package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper;

public class ClothingFillOutRegistrationForm {

	@FindBy(id = "id_gender1")
	WebElement gendermale; 
	
	@FindBy(id = "id_gender2")
	WebElement genderfemale; 
	
	@FindBy(id = "customer_firstname")
	WebElement userfirstName; 
	
	@FindBy(id = "customer_lastname")
	WebElement userlastName; 

	@FindBy(id = "passwd")
	WebElement userpasswd; 
	
	@FindBy(id = "days")
	WebElement userdobDay;
	
	@FindBy(id = "months")
	WebElement userdobMonth;
	
	@FindBy(id = "years")
	WebElement userdobYear;
	
	@FindBy(id = "firstname")
	WebElement addressName;
	
	@FindBy(id = "lastname")
	WebElement addresslastName;
	
	@FindBy(id = "company")
	WebElement companyName;
	
	@FindBy(id = "address1")
	WebElement addressFirst;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "id_state")
	WebElement state;
	
	@FindBy(id = "postcode")
	WebElement postcode;
	
	@FindBy(id = "phone_mobile")
	WebElement mobile;
	
	@FindBy(id = "alias")
	WebElement alias;
	
	@FindBy(css = "#submitAccount > span")
	WebElement submit;
	
	
	public void gendermaleClick() {
		gendermale.click();
	}
	
	public void genderfemaleClick() {
		genderfemale.click();
	}
	
	public void setuserfirstName(String name) {
		userfirstName.sendKeys(name);
	}
	
	public void setuserlastName(String name) {
		userlastName.sendKeys(name);
	}
	
	public void setuserpasswd(String pass) {
		userpasswd.sendKeys(pass);
	}
	
	public void userdobDayClick() {
		userdobDay.click();
	}
	
	public String getuserfirstName() {
		return userfirstName.getText();
	}
	
	public String getuserlastName() {
		return userlastName.getText();
	}
	
	public void setaddressName(String name) {
		addressName.sendKeys(name);
	}
	
	
	public void setaddresslastName(String name) {
		addresslastName.sendKeys(name);
	}
	
	public void setcompanyName(String company) {
		companyName.sendKeys(company);
	}
	
	public void setaddressFirst(String address) {
		addressFirst.sendKeys(address);
	}
	
	public String getaddressFirst() {
		return addressFirst.getText();
	}
	
	public void setCity(String citynew) {
		city.sendKeys(citynew);
	}
	
	public void setPostcode(String newpost) {
		postcode.sendKeys(newpost);
	}
	
	public void setMobile(String mobilenew) {
		mobile.sendKeys(mobilenew);
	}
	
	public void setAlias(String aliasnew) {
		alias.sendKeys(aliasnew);
	}
	
	
	public void submitClick() {
		submit.click();
	}
	
	public String getcompany() {
		return companyName.getText();
	}
	
	public String getaddressfirst() {
		return addressFirst.getText();
	}

	public String getcity() {
		return city.getText();
	}
	
	public String getpostcode() {
		return postcode.getText();
	}
	
	public String getmobile() {
		return mobile.getText();
	}
	
}
