package com.ajayb.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldService {

	@GET
	public Response getResponse() {
		String output = "Hello World!!!";

		return Response.ok().entity(output).build();
	}

}
