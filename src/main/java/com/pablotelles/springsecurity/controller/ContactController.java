package com.pablotelles.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablotelles.springsecurity.model.Contact;
import com.pablotelles.springsecurity.repository.ContactRepository;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

	private final ContactRepository contactRepository;
	
	public ContactController(final ContactRepository contactRepository){
		this.contactRepository = contactRepository;
	}
	
	@GetMapping
	public Iterable<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
}
