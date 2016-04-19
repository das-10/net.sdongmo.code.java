/**
 * 
 */
package net.sdongmo.java.code.persistence.memory.addressbook.dao;

import java.util.HashMap;

import net.sdongmo.java.code.persistence.memory.addressbook.ContactAlreadyExist;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDoesntExist;
import net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact;

/**
 * @author dongms
 *
 */
public interface ContactDao {
	public Contact getContactById(int contactId) throws  ContactDoesntExist;
	public int createContact(HashMap<String, Object> contactMap) throws ContactAlreadyExist;
}
