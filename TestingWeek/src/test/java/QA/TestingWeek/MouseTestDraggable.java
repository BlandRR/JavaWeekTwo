package QA.TestingWeek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.graphbuilder.curve.Point;

import junit.framework.Assert;

public class MouseTestDraggable {

	String url = "http://demoqa.com/draggable/";
	private WebDriver webDriver;

	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		JavascriptExecutor js;
		if (webDriver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) webDriver;
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@Test
	public void MoveX() {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		Actions builder = new Actions(webDriver);

		int start = drag.dragbox.getLocation().getX();

		builder.clickAndHold(drag.dragbox).moveByOffset(50, 10).release().build().perform();

		int currentlocation = drag.dragbox.getLocation().getX();
		int expectedlocation = start + 50;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void MoveY() {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		Actions builder = new Actions(webDriver);

		int start = drag.dragbox.getLocation().getY();

		builder.clickAndHold(drag.dragbox).moveByOffset(50, 10).release().build().perform();

		int currentlocation = drag.dragbox.getLocation().getY();
		int expectedlocation = start + 10;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ConstaintMovementsVerticle() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);

		drag.clickconstraints();
		webDriver.manage().window().maximize();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		int start = constraints.verticleBox.getLocation().getY();

		Actions builder = new Actions(webDriver);
		builder.clickAndHold(constraints.verticleBox).moveByOffset(10, 10).release().build().perform();

		int currentlocation = constraints.verticleBox.getLocation().getY();

		int expectedlocation = start + 10;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ConstaintMovementsHorizontal() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		int start = constraints.horizontalBox.getLocation().getX();
		Actions builder = new Actions(webDriver);

		builder.clickAndHold(constraints.horizontalBox).moveByOffset(10, 10).release().build().perform();

		int currentlocation = constraints.horizontalBox.getLocation().getX();
		int expectedlocation = start + 10;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ContainedBoxEdgeX() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		Actions builder = new Actions(webDriver);

		builder.clickAndHold(constraints.containedBox).moveByOffset(100000, 10).release().build().perform();

		int currentlocation = constraints.containedBox.getLocation().getX();
		int expectedlocation = 779;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ContainedBoxEdgeY() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		Actions builder = new Actions(webDriver);

		int j = 0;
		int i = 50;
		if (i >= 26) {
			j = 579;
		} else {
			j = constraints.containedBox.getLocation().getY() + i;
		}

		builder.clickAndHold(constraints.containedBox).moveByOffset(0, i).release().build().perform();

		int currentlocation = constraints.containedBox.getLocation().getY();
		int expectedlocation = j;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ContainedBoxwithinY() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		Actions builder = new Actions(webDriver);

		int y = constraints.containedBox.getLocation().getY();
		builder.clickAndHold(constraints.containedBox).moveByOffset(0, 10).release().build().perform();

		int currentlocation = constraints.containedBox.getLocation().getY();
		int expectedlocation = y + 10;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ContainedParentX() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		Actions builder = new Actions(webDriver);

		int start = constraints.inParent.getLocation().getX();
		builder.clickAndHold(constraints.inParent).moveByOffset(100000, 0).release().build().perform();

		int currentlocation = constraints.inParent.getLocation().getX();
		int expectedlocation = 386;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ContainedParentY() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickconstraints();

		ConstraintsClass constraints = PageFactory.initElements(webDriver, ConstraintsClass.class);
		Actions builder = new Actions(webDriver);

		int start = constraints.inParent.getLocation().getY();

		builder.clickAndHold(constraints.inParent).moveByOffset(0, 10000000).release().build().perform();

		int currentlocation = constraints.inParent.getLocation().getY();
		int expectedlocation = 497;

		// wrapper . length and size

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void ControlledByBottom() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickcursorStyle();

		CursorStyleClass cursorstyle = PageFactory.initElements(webDriver, CursorStyleClass.class);
		Actions builder = new Actions(webDriver);

		int i = 300;
		int start = cursorstyle.BottomBox.getLocation().getY();
		builder.clickAndHold(cursorstyle.BottomBox).moveByOffset(-1, i).release().build().perform();

		int currentlocation = cursorstyle.BottomBox.getLocation().getY();
		int expectedlocation = (start + i - cursorstyle.BottomBox.getSize().getWidth()
				+ cursorstyle.BottomBox.getSize().getWidth() / 2);

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void BoxTopleftneg5() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickcursorStyle();

		webDriver.manage().window().maximize();
		CursorStyleClass cursorstyle = PageFactory.initElements(webDriver, CursorStyleClass.class);
		Actions builder = new Actions(webDriver);

		int start = cursorstyle.topleftneg5.getLocation().getY();
		builder.clickAndHold(cursorstyle.topleftneg5).moveByOffset(-100, 0).release().build().perform();

		int currentlocation = cursorstyle.topleftneg5.getLocation().getY();
		int expectedlocation = start + 5 + cursorstyle.topleftneg5.getSize().getHeight() / 2;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void centeroftheBox() throws InterruptedException {

		webDriver.navigate().to(url);

		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickcursorStyle();

		webDriver.manage().window().maximize();
		CursorStyleClass cursorstyle = PageFactory.initElements(webDriver, CursorStyleClass.class);
		Actions builder = new Actions(webDriver);

		int start = cursorstyle.cursorcenterBox.getLocation().getY();
		builder.clickAndHold(cursorstyle.cursorcenterBox).moveByOffset(1000, 200).release().build().perform();

		int currentlocation = cursorstyle.cursorcenterBox.getLocation().getY();
		int expectedlocation = start + 200 - cursorstyle.cursorcenterBox.getSize().getHeight() / 2 + 44;

		Assert.assertEquals(expectedlocation, currentlocation);
	}

	@Test
	public void eventmovementStops() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickEvents();
		webDriver.manage().window().maximize();
		EventsClass eventclass = PageFactory.initElements(webDriver, EventsClass.class);
		Actions builder = new Actions(webDriver);

		for (int i = 0; i < 5; i++) {
			builder.dragAndDropBy(eventclass.drageventbox, 20, 0).release().build().perform();
			Thread.sleep(1000);
		}

		String currentstops = eventclass.geteventstop().substring(15, eventclass.geteventstop().length());
		String expectedstops = "5x";
		Assert.assertEquals(expectedstops, currentstops);
	}

	@Test
	public void eventmovementMovement() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickEvents();
		webDriver.manage().window().maximize();
		EventsClass eventclass = PageFactory.initElements(webDriver, EventsClass.class);
		Actions builder = new Actions(webDriver);

		builder.dragAndDropBy(eventclass.drageventbox, 100, 0).release().build().perform();
		Thread.sleep(1000);

		String currentmovement = eventclass.geteventmovement().substring(15, eventclass.geteventstop().length());
		String expectedmovement = "100x";
		Assert.assertEquals(expectedmovement, currentmovement);
	}

	@Test
	public void eventmovementStart() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickEvents();
		webDriver.manage().window().maximize();
		EventsClass eventclass = PageFactory.initElements(webDriver, EventsClass.class);
		Actions builder = new Actions(webDriver);

		// builder.dragAndDropBy(eventclass.drageventbox, 100, 0).perform();
		builder.clickAndHold(eventclass.drageventbox).moveByOffset(100, 100).build().perform();
		Thread.sleep(1000);

		String currentmovement = eventclass.geteventstart().substring(15, eventclass.geteventstop().length());
		String expectedmovement = " 1";
		Assert.assertEquals(expectedmovement, currentmovement);
	}

	@Test
	public void eventmovementmultiplemoves() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickEvents();
		webDriver.manage().window().maximize();
		EventsClass eventclass = PageFactory.initElements(webDriver, EventsClass.class);
		Actions builder = new Actions(webDriver);

		for (int i = 0; i < 5; i++) {
			builder.dragAndDropBy(eventclass.drageventbox, 20, 0).release().build().perform();
			Thread.sleep(1000);
		}

		builder.clickAndHold(eventclass.drageventbox).moveByOffset(100, 100).build().perform();
		Thread.sleep(1000);

		String currentmovement = eventclass.geteventstart().substring(16, eventclass.geteventstart().length());
		String expectedmovement = "6x";
		Assert.assertEquals(expectedmovement, currentmovement);
	}

	@Test
	public void sortabledragitem1toitem1() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickDrag();
		webDriver.manage().window().maximize();

		SortableClass sortable = PageFactory.initElements(webDriver, SortableClass.class);
		Actions builder = new Actions(webDriver);

		int newpos = sortable.sortablebox1.getLocation().getY();

		// builder.dragAndDropBy(sortable.sortablebox1, 0, 30).release().perform();
		builder.clickAndHold(sortable.sortablebox1).moveByOffset(0, 10).release().build().perform();
		Thread.sleep(1000);

		int currentmovement = sortable.sortablebox1.getLocation().getY();
		int expectedmovement = newpos;
		Assert.assertEquals(expectedmovement, currentmovement);
	}

	@Test
	public void sortabledragitem1toitem4() throws InterruptedException {

		webDriver.navigate().to(url);
		DraggableClass drag = PageFactory.initElements(webDriver, DraggableClass.class);
		drag.clickDrag();
		webDriver.manage().window().maximize();

		SortableClass sortable = PageFactory.initElements(webDriver, SortableClass.class);
		Actions builder = new Actions(webDriver);

		int newpos = sortable.sortablebox4.getLocation().getY();

		builder.clickAndHold(sortable.sortablebox1).moveByOffset(0, 70).release().build().perform();
		Thread.sleep(1000);

		int currentmovement = sortable.sortablebox4.getLocation().getY();
		int expectedmovement = newpos;
		Assert.assertEquals(expectedmovement, currentmovement);
	}

}
