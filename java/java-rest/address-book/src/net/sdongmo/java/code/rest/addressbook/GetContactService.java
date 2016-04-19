package net.sdongmo.java.code.rest.addressbook;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/contacts/{contactId}")
public class GetContactService {
	static Logger logger = LoggerFactory.getLogger(CreateContactService.class);
	  
	@GET
	@Produces({MediaType.TEXT_XML})
	public Response getContact(@PathParam("contactId") int contactId){
		logger.info("Receive Get Contact Request:"+contactId);
		ContactGateway contactGateway = ContactGateway.newContactGateway();
		return contactGateway.getContactAsXml(contactId);
	}
}