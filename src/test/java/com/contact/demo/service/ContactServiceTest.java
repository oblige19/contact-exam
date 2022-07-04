package com.contact.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.contact.demo.entity.Contact;

@TestPropertySource("/application.properties")
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql({"/contact.sql"})
public class ContactServiceTest {
	
	@Autowired
	private ContactService service;
	
	@Test
	public void findAll() {
		List<Contact> contacts = service.findAll();
		Assert.assertTrue("Empty", !contacts.isEmpty());
	}

	@Test
	public void createContact() {
		Contact contact = new Contact();
		contact.setType("MOBILE");
		contact.setPhoneNumber("12345");
		contact.setCustomerId(1L);

		String result = service.create(contact);

		assertEquals(result, "Success");
	}


	@Test
	public void updateContact() {
		Contact contact = new Contact();
		contact.setId(1L);
		contact.setType("MOBILE");
		contact.setPhoneNumber("65433");
		contact.setCustomerId(1L);

		String result = service.update(contact);

		assertEquals(result, "Success");
	}


	@Test
	public void deleteContact() {
		String result = service.delete(1L);

		assertEquals(result, "Success");
	}

}
