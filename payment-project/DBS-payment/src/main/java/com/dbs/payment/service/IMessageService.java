package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.beans.Message;

public interface IMessageService {

	Message addMessage(Message message);

	List<Message> getAllMessages();

	Message getMessage(String id);

	Message updateMessage(String id, Message message);

	Message deleteMessage(String id);

}