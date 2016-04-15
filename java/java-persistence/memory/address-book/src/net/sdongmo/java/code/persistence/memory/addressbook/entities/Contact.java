/**
 * 
 */
package net.sdongmo.java.code.persistence.memory.addressbook.entities;

/**
 * @author dongms
 *
 */
public class Contact {
	private String name;
	private String phoneNumber;
	private int contactId;
	
	public Contact(String name, String phoneNumber, int contactId) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.contactId = contactId;
	}
	
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", contactId=" + contactId + "]";
	}

}