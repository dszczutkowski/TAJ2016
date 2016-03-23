package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageAppMockitoTest {
	
	@Mock
	MessageService msvc;
	private Messenger msg;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		msg = new Messenger(msvc);
	}
	
	@After
	public void tearDown() throws Exception {
		msvc = null;
		msg = null;
	}

	
	@Test
	public void testCheckConnectionValidServerConnectionSuccess() {
		when(msvc.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(msvc).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testCheckConnectionValidServerConnectionFailure() {
		when(msvc.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(msvc).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testCheckConnectionInvalidServerConnectionFailure() {
		when(msvc.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(msvc).checkConnection(INVALID_SERVER);
	}
	
	@Test
	public void testCheckConnectionNullServerConnectionFailure() {
		when(msvc.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		verify(msvc).checkConnection(null);
	}
	
	@Test
	public void testValidServerValidMessage() throws MalformedRecipientException {
		when(msvc.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(msvc).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void testValidServerInvalidMessage() throws MalformedRecipientException {
		when(msvc.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msvc).send(VALID_SERVER, INVALID_MESSAGE);
	}
	
	@Test
	public void testInvalidServerValidMessage() throws MalformedRecipientException {
		when(msvc.send(INVALID_SERVER, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msvc).send(INVALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void testValidServerErrorMessage() throws MalformedRecipientException {
		when(msvc.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(msvc).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void testValidServerNullMessage() throws MalformedRecipientException {
		when(msvc.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(msvc).send(VALID_SERVER, null);
	}
	
	@Test
	public void testInvalidServerNullMessage() throws MalformedRecipientException {
		when(msvc.send(INVALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER, null);
		assertEquals(2, result);
		verify(msvc).send(INVALID_SERVER, null);
	}
	
	@Test
	public void testNullServerValidMessage() throws MalformedRecipientException {
		when(msvc.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msvc).send(null, VALID_MESSAGE);
	}
	
	@Test
	public void testNullServerInvalidMessage() throws MalformedRecipientException {
		when(msvc.send(null, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msvc).send(null, INVALID_MESSAGE);
	}
	
	@Test
	public void testNullServerNullMessage() throws MalformedRecipientException {
		when(msvc.send(null, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		verify(msvc).send(null, null);
	}


}