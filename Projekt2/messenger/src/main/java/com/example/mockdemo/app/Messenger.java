package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	public int testConnection(String server) {
		if(ms.checkConnection(server) == ConnectionStatus.SUCCESS)
			return 0;
		else
			return 1;
	}

	public int sendMessage(String server, String message) {
		int result = -1;
		try {
			if (ms.send(server, message) == SendingStatus.SENT)
				result = 0;
			else
				result = 1;
		}
		catch(MalformedRecipientException e) {
			result = 2;
		}
		return result;
	}
}
