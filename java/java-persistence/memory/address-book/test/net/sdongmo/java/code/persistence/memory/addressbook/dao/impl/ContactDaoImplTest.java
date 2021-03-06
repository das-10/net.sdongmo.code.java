/**
 * 
 */
package net.sdongmo.java.code.persistence.memory.addressbook.dao.impl;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sdongmo.java.code.persistence.memory.addressbook.ContactAlreadyExist;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDaoFactory;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDoesntExist;
import net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao;
import net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact;

/**
 * @author dongms
 *
 */
public class ContactDaoImplTest {
	HashMap<String, Object> contactMap;
	ContactDao contactDao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		contactDao = ContactDaoFactory.getInstance();
		contactMap = new HashMap<>();
		contactMap.put("name", "Sereni");
		contactMap.put("contactId", 1);
		contactMap.put("phoneNumber", "017630524290");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveContactCorrectly() throws ContactAlreadyExist {
		int contactId = contactDao.createContact(contactMap);
		assertEquals(1, contactId);
	}
	
	@Test
	public void testGetContactById_02() throws ContactDoesntExist{
		try {
			givenContact(2, "testContact", "017230524290");
		} catch (ContactAlreadyExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Contact contact = contactDao.getContactById(2);
		assertEquals(2, contact.getContactId());
	}
	
	
	@Test(expected=ContactDoesntExist.class)
	public void testThatGetContactByIdThrowException() throws ContactDoesntExist{
		contactDao.getContactById(3);
	}
	
	@Test(expected=ContactAlreadyExist.class)
	public void testThatCreateContactThrowException() throws ContactAlreadyExist{
		givenContact(2, "testContact", "017230524290");
		givenContact(2, "testContact", "017230524290");
	}
	
	private void givenContact(int contactId,String name,String phoneNumber) throws ContactAlreadyExist{
		HashMap<String, Object> contactMap = new HashMap<>();
		contactMap.put("name", name);
		contactMap.put("contactId", contactId);
		contactMap.put("phoneNumber", phoneNumber);
		contactDao.createContact(contactMap);
	}
}
