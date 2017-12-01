package QA.TestingWeek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsClass {

	
	@FindBy(id = "dragevent")
	WebElement drageventbox;
	
	@FindBy(id = "event-stop")
	WebElement eventstop;
	
	
	@FindBy(id = "event-drag")
	WebElement eventmovement;
	
	@FindBy(id = "event-start")
	WebElement eventstart;
	
	

	
	public String geteventstop() {
		return eventstop.getText();
	}
	
	
	public String geteventmovement() {
		return eventmovement.getText();
	}
	
	
	public String geteventstart() {
		return eventstart.getText();
	}
	
	
	
	
	
	
}
