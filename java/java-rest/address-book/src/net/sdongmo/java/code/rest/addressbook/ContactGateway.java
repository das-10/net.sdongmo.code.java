package net.sdongmo.java.code.rest.addressbook;

import net.sdongmo.java.code.persistence.memory.addressbook.ContactAlreadyExist;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDaoFactory;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDoesntExist;
import net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao;
import net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact;

public class ContactGateway {
	private ContactDao contactDao;
	
	protected ContactGateway(){}
	
	private static final class InstanceHolder{
		static final ContactGateway Instance = new ContactGateway(); 
	}
	
	public static ContactGateway newContactGateway(){
		return InstanceHolder.Instance;
	}
	
	public ContactDTO getContactAsXml(int contactId){
		ContactDTO contactDto = null;
		contactDao = ContactDaoFactory.getInstance();
		try {
			contactDto = dogetContactAsXml(contactId);
		} catch (ContactDoesntExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactDto;
	}
	
	public void createContact(){
		
	}
	
	private ContactDTO dogetContactAsXml(int contactId) throws ContactDoesntExist{
		Contact contact = contactDao.getContactById(contactId);
		ContactDTO contactDto = new ContactDTO();
		contactDto.setContactId(contact.getContactId());
		contactDto.setName(contact.getName());
		contactDto.setPhoneNumber(contact.getPhoneNumber());
		return contactDto;
		
	}

}