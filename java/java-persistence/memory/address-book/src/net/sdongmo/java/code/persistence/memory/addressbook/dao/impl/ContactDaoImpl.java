/**
 * 
 */
package net.sdongmo.java.code.persistence.memory.addressbook.dao.impl;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sdongmo.java.code.persistence.memory.addressbook.ContactAlreadyExist;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDoesntExist;
import net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao;
import net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact;

/**
 * @author dongms
 *
 */
public class ContactDaoImpl implements ContactDao {
	private ConcurrentHashMap<Integer, Contact> dataLayer;
	static Logger logger;
	
	public ContactDaoImpl() {
		super();
		logger = LoggerFactory.getLogger(ContactDaoImpl.class);
		dataLayer = new ConcurrentHashMap<Integer, Contact>();
	}

	/* (non-Javadoc)
	 * @see net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao#getContactByName(java.lang.String)
	 */
	@Override
	public Contact getContactById(int contactId) throws ContactDoesntExist {
		logger.info("Get Contact for Id.."+contactId);
		if (!dataLayer.containsKey(contactId)){
			logger.info("Contact for Id..."+contactId+"..Does'nt exist");
			throw new ContactDoesntExist();
		}
		else{
			logger.info("Contact for Id.."+contactId+"..found");
			return dataLayer.get(contactId);
		}
	}

	/* (non-Javadoc)
	 * @see net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao#createContact(net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact)
	 */
	@Override
	public int createContact(HashMap<String, Object> contactMap) throws ContactAlreadyExist {
		logger.info("Going to Create Contact:"+contactMap.toString());
		String name = (String) contactMap.get("name");
		String phoneNumber = (String) contactMap.get("phoneNumber");
		int contactId =  (int) contactMap.get("contactId");
		Contact contact = new Contact(name, phoneNumber, contactId);
		if (dataLayer.containsKey(contactId)){
			logger.info("Contact with Id:"+contactId+"..Already Exist");
			throw new ContactAlreadyExist();
		}else{
			dataLayer.put(contactId, contact);
			logger.info("Contact :"+contactMap.toString()+".."+"Created");
			return contactId;
		}
	}
}
