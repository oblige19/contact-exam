package com.contact.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contact.demo.entity.Contact;
import com.contact.demo.repository.ContactRepository;
import com.contact.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	private static final String SUCCESS_MESSAGE = "Success";

	private final ContactRepository repository;

	public ContactServiceImpl(ContactRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Contact> findAll() {
		return repository.findAll();
	}

	@Override
	public Contact find(Long id) {
		Optional<Contact> result = repository.findById(id);
		
		Contact contact = null;
		
		if (result.isPresent()) {
			contact = result.get();
		}
		else {
			// we didn't find the contact
			throw new RuntimeException("Did not find contact id - " + id);
		}
		
		return contact;
	}

	@Override
	public String create(Contact contact) {
		repository.save(contact);
		return SUCCESS_MESSAGE;
	}

	@Override
	public String update(Contact contact) {
		repository.save(contact);
		return SUCCESS_MESSAGE;
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return SUCCESS_MESSAGE;
	}

	@Override
	public List<Contact> findAllByCustomer(Long customerId) {
		return repository.findByCustomerId(customerId);
	}

}
