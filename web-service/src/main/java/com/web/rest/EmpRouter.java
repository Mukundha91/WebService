package com.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

@Path("/emp")
public class EmpRouter {

	@GET
	@Path("/getEmp")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmp() {
		return "successfully created GET webService";
	}

	@POST
	@Path("/getPostEmp")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getPostEmp(JAXBElement<EmpRequest> empRequest) throws EmpNotFoundException {
		EmpResponse empResponse = new EmpResponse();
		if (empRequest.getValue().getId() == 1) {
			empResponse.setId(empRequest.getValue().getId());
			empResponse.setName(empRequest.getValue().getName());
		} else {
			throw new EmpNotFoundException("Wrong ID", empRequest.getValue().getId());
		}
		return Response.ok(empResponse).build();
	}

	@POST
	@Path("/getPostName")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getPostEmp(String name) {
		return Response.ok("Welcome " + name).build();
	}
}