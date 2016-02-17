package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.NWD;

public class NWDTest {
	
	private NWD test;
	private int result;
	
	@Before
	public void before(){
		test = new NWD();
	}
	
	@After
	public void after() {
		test = null;
	}
	
	@Test
	public void nwdWorksProper() {
		result = test.nwd(42, 56);
		assertEquals(result, 14);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nwdShouldThrowException_lessthan0(){
		result = test.nwd(-3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nwdShouldThrowException_bothlessthan0(){
		result = test.nwd(-3, -8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nwdShouldThrowException_bothzero(){
		result = test.nwd(0, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nwdShouldThrowException_zero(){
		result = test.nwd(6, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nwdShouldThrowException_zerolessthanzero(){
		result = test.nwd(-6, 0);
	}
	

}
