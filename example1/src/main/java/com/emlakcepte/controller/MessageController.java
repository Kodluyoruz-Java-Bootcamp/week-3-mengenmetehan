package com.emlakcepte.controller;

import java.util.List;

import com.emlakcepte.model.Message;
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

import com.emlakcepte.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController
{

	private MessageService messageService;

	public MessageController(MessageService messageService)
	{
		this.messageService = messageService;
	}

	@GetMapping
	public List<Message> getAll()
	{
		System.out.println("HTTP-GET MessageController called.");
		return messageService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message)
	{
		System.out.println("HTTP-POST MessageController -> Create Message called.");
		messageService.saveMessage(message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@PutMapping("/{message}")
	public ResponseEntity<Message> update(@PathVariable Message message, @RequestBody Message updated)
	{
		System.out.println("HTTP-PUT MessageController -> Update Message called.");
		messageService.updateMessage(message, updated);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{message}")
	public ResponseEntity<Message> delete(@PathVariable Message message)
	{
		System.out.println("HTTP-DELETE MessageController -> Delete Message called.");
		messageService.deleteMessage(message);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}
