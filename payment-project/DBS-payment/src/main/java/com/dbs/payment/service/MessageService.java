package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dbs.payment.beans.Message;
import com.dbs.payment.repo.MessageRepo;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private MessageRepo messageRepo;
	
	@Override
	public Message addMessage(Message message) {
		if(message!=null) {
		return messageRepo.save(message);
		}
		else
		{
			return null;
		}
	}
	

	@Override
	public List<Message> getAllMessages() {
		return messageRepo.findAll();
	}
	
	
	@Override
	public Message getMessage(String id) {
		if(id!=null) {
		return messageRepo.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	
	@Override
	public Message updateMessage(String id,Message message) {
		Optional<Message> result=messageRepo.findById(id);
		if(result.isPresent()) {
			return messageRepo.save(message);
		}
		else
		{
		return null;
		}
	}

	@Override
	public Message deleteMessage(String id) {
		Optional<Message> result=messageRepo.findById(id);
		if(result.isPresent()) {
			messageRepo.deleteById(id);
			return result.get();
		}
		else
		{
		return null;
		}
	}
}
