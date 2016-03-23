package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class MessageAppTest {

	private Messenger msg;
	private MessageServiceMock msm;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() {
		msm = new MessageServiceMock();
		msg = new Messenger(msm);
	}
	
	@After
	public void tearDown() {
		msg = null;
		msm = null;
	}
	
	@Test
	public void testValidServerConnectionTrue() {
		msm.setConnected(true);
		assertEquals(0, msg.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testValidServerConnectionFalse() {
		msm.setConnected(false);
		assertEquals(1, msg.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testInvalidServerConnectionTrue() {
		msm.setConnected(true);
		assertEquals(1, msg.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testInvalidServerConnectionFalse() {
		msm.setConnected(false);
		assertEquals(1, msg.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testNullServerConnectionTrue() {
		msm.setConnected(true);
		assertEquals(1, msg.testConnection(null));
	}
	
	@Test
	public void testNullServerConnectionFalse() {
		msm.setConnected(false);
		assertEquals(1, msg.testConnection(null));
	}
	
	@Test
	public void testValidServerValidMsgSentTrue() {
		msm.setSent(true);
		assertEquals(0, msg.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testValidServerValidMsgSentFalse() {
		msm.setSent(false);
		assertEquals(1, msg.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendMessageValidServerValidMsg() {
		assertEquals(1, msg.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendMessageValidServerInvalidMsg() {
		assertEquals(2, msg.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testSendMessageValidServerNullMsg() {
		assertEquals(2, msg.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void testSendMessageInvalidServerValidMsg() {
		assertEquals(1, msg.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendMessageInvalidServerInvalidMsg() {
		assertEquals(2, msg.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testSendMessageInvalidServerNullMsg() {
		assertEquals(2, msg.sendMessage(INVALID_SERVER, null));
	}
	
	@Test
	public void checkSendingMessageNullServerValidMessage() {
		assertEquals(2, msg.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageNullServerInvalidMessage() {
		assertEquals(2, msg.sendMessage(null, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageNullServerNullMessage() {
		assertEquals(2, msg.sendMessage(null, null));
	}
}
