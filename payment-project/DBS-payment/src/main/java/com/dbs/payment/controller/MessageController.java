package com.dbs.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dbs.payment.beans.Message;

import com.dbs.payment.service.IMessageService;

@RestController
@RequestMapping("api")
public class MessageController {

	@Autowired
	private IMessageService messageService;
	
	@PostMapping("/message")
	public ResponseEntity<Message>  addMessage(@RequestBody Message message) {
		Message result=messageService.addMessage(message);
		return new ResponseEntity<Message>(result, HttpStatus.OK); 
	}
	
	@GetMapping("/messages")
	public ResponseEntity<List<Message>> getAllMessages(){
		List<Message> messages=messageService.getAllMessages();
		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK); 
	}
	
	@GetMapping("/message/{id}")
	public ResponseEntity<Message> getBank(@PathVariable String id){
		Message message=messageService.getMessage(id);
		return new ResponseEntity<Message>(message, HttpStatus.OK); 
	}
	
	@PutMapping("/message/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable String id,@RequestBody Message message){
		Message res=messageService.updateMessage(id,message);
		return new ResponseEntity<Message>(res, HttpStatus.OK); 
	}
	
//	@DeleteMapping("/message/{id}")
//	public ResponseEntity<Message> deleteMessage(@PathVariable String id){
//		Message message=messageService.deleteMessage(id);
//		return new ResponseEntity<Message>(message, HttpStatus.OK); 
//	}
}
