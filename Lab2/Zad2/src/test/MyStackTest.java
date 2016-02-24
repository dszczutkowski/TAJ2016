package test;

import org.junit.Assert.*;
import org.junit.Before;


import org.junit.After;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import main.MyStack;

public class MyStackTest {
	
	private MyStack myStack;
	
	@Before
	public void setup()
	{
		myStack = new MyStack();
	}

	@Test
	public void MyPushTest() {
		myStack.MyPush(3);
		myStack.MyPush(7);
		myStack.MyPush(4);
		assertThat(myStack.getStack(), contains(3, 7, 4));
	}
	
	@Test
	public void MyPopTest() {
		myStack.MyPush(8);
		myStack.MyPush(9);
		myStack.MyPush(0);
		myStack.MyPop();
		assertThat(myStack.getStack().size(), is(2));
		assertThat(myStack.getStack(), contains(8, 9));
		assertThat(myStack.getStack(), not(contains(4)));
	}
	
	@Test
	public void IsNullTest() {
		myStack = new MyStack();
		assertThat(myStack.IsNull(), equalTo(true));
		myStack.MyPush(0);
		assertThat(myStack.IsNull(), equalTo(false));
	}
	
	@Test
	public void MyTopTest() {
		myStack.MyPush(4);
		assertThat(myStack.MyTop(), is(4));
	}
	
	@Test
	public void IsNullThrowsException()
	{
		try
		{
			myStack = null;
			myStack.IsNull();
		} catch(NullPointerException e)
		{
			assertThat(true, is(true));
		}
	}
	
	@After
	public void setdown()
	{
		myStack = null;
	}

}
