package net.sdongmo.java.code.rest.addressbook;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/contacts/{contactId}")
public class GetContactService {
	  
	@GET
	@Produces({MediaType.TEXT_XML})
	public ContactDTO getContact(@PathParam("contactId") int contactId){
		ContactGateway contactGateway = ContactGateway.newContactGateway();
		return contactGateway.getContactAsXml(contactId);
	}
}