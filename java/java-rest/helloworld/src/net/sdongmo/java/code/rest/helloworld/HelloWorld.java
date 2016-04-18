package net.sdongmo.java.code.rest.helloworld;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("hello")
public class HelloWorld {
	
	static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
		logger.info("Going to say Hello Worlds");
	    return "Hello Jersey";
	  }
}
