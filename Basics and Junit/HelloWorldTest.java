import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testSum() {
		HelloWorld hw = new HelloWorld();
		int a = hw.Sum(10, 20);
		assertEquals(30, a);
	}

	@Test
	public void testBlackJack1() {
		HelloWorld.blackJack(10, 20);
		assertEquals(20, 20);
	}

	@Test
	public void testBlackJack2() {
		HelloWorld.blackJack(15, 20);
		assertEquals(20, 20);
	}

	@Test
	public void testBlackJack3() {
		HelloWorld.blackJack(1, 2);
		assertEquals(2, 2);
	}

	@Test
	public void Temp1() {
		HelloWorld.Temperature(10, true);
		assertEquals(false, false);
	}

	@Test
	public void Temp2() {
		HelloWorld.Temperature(90, false);
		assertEquals(false, false);
	}

	@Test
	public void Temp3() {
		HelloWorld.Temperature(110, true);
		assertEquals(true, true);
	}

	@Test
	public void Temp4() {
		HelloWorld.Temperature(59, true);
		assertEquals(false, false);
	}
	
	
	@Test
	public void Unique1() {
		HelloWorld.uniqueSum(1, 2, 3);
		assertEquals(6, 6);
	}
	
	@Test
	public void Unique2() {
		HelloWorld.uniqueSum(3, 3, 3);
		assertEquals(0, 0);
	}
	
	@Test
	public void Unique3() {
		HelloWorld.uniqueSum(1, 1, 2);
		assertEquals(2, 2);
		
	}
	
	
	
	
	
	
	

}
