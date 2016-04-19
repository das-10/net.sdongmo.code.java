package net.sdongmo.java.code.rest.addressbook;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/contacts")
public class CreateContactService {
	static Logger logger = LoggerFactory.getLogger(CreateContactService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createContact(
		@QueryParam("contactId") int contactId,
		@QueryParam("name") String name,
		@QueryParam("phoneNumber") String phoneNumber){
		logger.info("Get Create Contact Request:"+contactId+"/"+name+"/"+phoneNumber);
		ContactGateway contactGateway = ContactGateway.newContactGateway();
		return contactGateway.createContact(name, contactId, phoneNumber);
	}
}