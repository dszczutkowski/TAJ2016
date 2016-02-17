package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Calculator;

public class CalculatorTest {

	private Calculator test;
	
	@Before
	public void setup() {
		test = new Calculator();
	}
	
	@After
	public void setdown() {
		test = null;
	}
	
	@Test
	public void addTest() {
		assertEquals(test.add(4, 6), 10);
	}
	
	@Test
	public void subTest() {
		assertEquals(test.sub(4, 6), -2);
	}
	
	@Test
	public void multiTest() {
		assertEquals(test.multi(4, 6), 24);
	}
	
	@Test
	public void divTest() {
		assertEquals(test.div(6, 3), 2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void shoudThrowArithmeticException(){
		test.div(8, 0);
	}

}
