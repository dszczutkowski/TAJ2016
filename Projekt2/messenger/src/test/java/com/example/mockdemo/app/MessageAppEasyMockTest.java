package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageAppEasyMockTest {

	private MessageService msvc;
	private Messenger msg;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		msvc = EasyMock.createMock(MessageService.class);
		msg = new Messenger(msvc);
	}

	@Test
	public void testCheckConnectionValidServerConnectionSuccess() {
		EasyMock.expect(msvc.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(msvc);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testCheckConnectionValidServerConnectionFailure() {
		EasyMock.expect(msvc.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(msvc);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		EasyMock.verify(msvc);
	}

	@Test
	public void testCheckConnectionInvalidServerConnectionSuccess() {
		EasyMock.expect(msvc.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(msvc);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testCheckConnectionNullServerConnectionFailure() {
		EasyMock.expect(msvc.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(msvc);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testValidServerValidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		EasyMock.replay(msvc);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testValidServerValidMessageError() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		EasyMock.replay(msvc);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		EasyMock.verify(msvc);
	}

	@Test
	public void testInvalidServerInvalidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(INVALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(INVALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testValidServerInvalidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testInvalidServerValidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(INVALID_SERVER, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(INVALID_SERVER, VALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testInvalidServerNullMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(INVALID_SERVER, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(INVALID_SERVER, null);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testValidServerNullMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(VALID_SERVER, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testNullServerValidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(null, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testNullServerInvalidMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(null, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@Test
	public void testNullServerNullMessage() throws MalformedRecipientException {
		EasyMock.expect(msvc.send(null, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msvc);
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		EasyMock.verify(msvc);
	}
	
	@After
	public void tearDown() throws Exception {
		msvc = null;
	}
}