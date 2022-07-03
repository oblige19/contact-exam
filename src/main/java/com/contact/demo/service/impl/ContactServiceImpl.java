package com.contact.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contact.demo.entity.Contact;
import com.contact.demo.repository.ContactRepository;
import com.contact.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

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
		return repository.getReferenceById(id);
	}

	@Override
	public String create(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return null;
	}

	@Override
	public List<Contact> findAllByCustomer(Long customerId) {
		return repository.findByCustomerId(customerId);
	}

}
