package net.sdongmo.java.code.rest.addressbook;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Errors")
public class ErrorXml {
	private String statusCode;
	private String description;
	private String modulName = ErrorXml.class.getSimpleName();
	
	public ErrorXml(){}
	
	public ErrorXml(String statusCode, String description, String modulName) {
		super();
		this.statusCode = statusCode;
		this.description = description;
		this.modulName = modulName;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModulName() {
		return modulName;
	}
	public void setModulName(String modulName) {
		this.modulName = modulName;
	}
}
