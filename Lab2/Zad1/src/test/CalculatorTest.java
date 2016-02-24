package test;

import org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
		assertThat(test.add(4, 6), is(10));
	}
	
	@Test
	public void subTest() {
		assertThat(test.sub(4, 6), is(-2));
	}
	
	@Test
	public void multiTest() {
		assertThat(test.multi(4, 6), is(24));
	}
	
	@Test
	public void divTest() {
		assertThat(test.div(6, 3), is(2));
	}
	
	@Test(expected = ArithmeticException.class)
	public void shoudThrowArithmeticException(){
		test.div(8, 0);
	}

}
