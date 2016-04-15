package net.sdongmo.java.code.persistence.memory.addressbook;

import net.sdongmo.java.code.persistence.memory.addressbook.dao.ContactDao;
import net.sdongmo.java.code.persistence.memory.addressbook.dao.impl.ContactDaoImpl;

public class ContactDaoFactory {
	
	private ContactDaoFactory(){}
	
	private static final class InstanceHolder {
	    static final ContactDao INSTANCE = new ContactDaoImpl();
	  }
	
	public static ContactDao getInstance(){
		return InstanceHolder.INSTANCE;
		
	}
}
