package net.sdongmo.java.code.rest.addressbook;

import java.util.HashMap;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sdongmo.java.code.persistence.memory.addressbook.ContactAlreadyExist;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDaoFactory;
import net.sdongmo.java.code.persistence.memory.addressbook.ContactDoesntExist;
import net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao;
import net.sdongmo.java.code.persistence.memory.addressbook.entities.Contact;

public class ContactGateway {
	private ContactDao contactDao;
	static Logger logger = LoggerFactory.getLogger(ContactGateway.class);
	
	protected ContactGateway(){}
	
	private static final class InstanceHolder{
		static final ContactGateway Instance = new ContactGateway(); 
	}
	
	public static ContactGateway newContactGateway(){
		return InstanceHolder.Instance;
	}
	
	public Response getContactAsXml(int contactId){
		int statusCode = 200;
		Object entity = "";
		contactDao = ContactDaoFactory.getInstance();
		try {
			entity = dogetContactAsXml(contactId);
		} catch (ContactDoesntExist e) {
			logger.info("ContactDoesntExist Exception Occured");
			String description = "Contact with Id:"+contactId+" "+"Doesn't exist";
			ErrorXml errorXml = new ErrorXml("404",description,
					GetContactService.class.getSimpleName());
			entity = errorXml;
			statusCode = 404;
		}
		return Response.status(statusCode).entity(entity).build();
	}
	
	public Response createContact(String name, int contactId, String PhoneNumber){
		int statusCode = 204;
		Object entity = "";
		contactDao = ContactDaoFactory.getInstance();
		HashMap<String, Object> contactMap = new HashMap<>();
		contactMap.put("name", name);
		contactMap.put("contactId", contactId);
		contactMap.put("phoneNumber", PhoneNumber);
		
		try {
			contactDao.createContact(contactMap);
		} catch (ContactAlreadyExist e) {
			statusCode = 409;
			String message = "Contact with Id:"+contactId+"..Already Exist";
			ErrorXml errorXml = new ErrorXml("404",message,
					CreateContactService.class.getSimpleName());
			entity = errorXml;
			logger.info(message);
		}
		return Response.status(statusCode).entity(entity).build();
		
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