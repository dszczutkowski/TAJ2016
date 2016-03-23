package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageServiceMock implements MessageService {

	private boolean sent = false;
	private boolean connected = false;
	
	public void setSent(boolean s) {
		sent = s;
	}
	
	public void setConnected(boolean s) {
		connected = s;
	}
	
	@Override
	public ConnectionStatus checkConnection(String server) {
		if(connected == true && server != null && server.endsWith(".pl"))
			return ConnectionStatus.SUCCESS;
		else
			return ConnectionStatus.FAILURE;
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if(server == null || message == null)
			throw new MalformedRecipientException();
		else if(server.length() < 4 || message.length() < 3)
			throw new MalformedRecipientException();
		else if(sent)
			return SendingStatus.SENT;
		else
			return SendingStatus.SENDING_ERROR;
	}

}