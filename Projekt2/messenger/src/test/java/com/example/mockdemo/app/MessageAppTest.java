package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MessageAppTest {

	private Messenger messenger;
	private MessageServiceMock msm;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() {
		msm = new MessageServiceMock();
		messenger = new Messenger(msm);
	}
	
	@After
	public void tearDown() {
		messenger = null;
		msm = null;
	}
	
	@Test
	public void test() {
		
	}
}
