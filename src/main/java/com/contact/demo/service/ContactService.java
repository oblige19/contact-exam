package com.contact.demo.service;

import java.util.List;

import com.contact.demo.entity.Contact;

public interface ContactService {

	List<Contact> findAll();

	List<Contact> findAllByCustomer(Long customerId);

	Contact find(Long id);

	String create(Contact contact);

	String update(Contact contact);

	String delete(Long id);
}
