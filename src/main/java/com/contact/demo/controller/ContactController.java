package com.contact.demo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.demo.entity.Contact;
import com.contact.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	private final ContactService service;
	
	public ContactController(ContactService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<Contact> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{customerId}/customer")
	public List<Contact> findAllByCustomer(@PathVariable("customerId") Long customerId) {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Contact find(@PathVariable("id") Long id) {
		return service.find(id);
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody Contact contact) {
		return service.create(contact);
	}
	
	@PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody Contact contact) {
		return service.update(contact);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
}
