package QA.TestingWeek;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStuff {

	@BeforeClass
	public static void init() {
		System.out.println("init");
	}
	
	@Before
	public void setup() {
		System.out.println("setup");
	}
	
	@Test
	public void test1() {
		System.out.println("Hello Test");
		
	}
	
	@After
	public void teardown() {
		System.out.println("teardown");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("destroy");
	}
	
	
}
