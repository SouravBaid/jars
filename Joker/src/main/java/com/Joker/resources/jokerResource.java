package com.Joker.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServlet;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;



@SuppressWarnings("serial")
@Path("/path/")
public class jokerResource extends HttpServlet {
	

	private static final Logger logger = (Logger) LoggerFactory.getLogger("logger");

//	private jokerservice jkrservice = new jokerservice();
//
//	public jokerResource(jokerservice jkrservice) {
//		super();
//		this.jkrservice = jkrservice;
//	}

	@GET
	@Path("/getData/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getData(@PathParam("data") String data) throws Exception {

//		String service_endpoint = "/"+new Object() {
//		}.getClass().getEnclosingMethod().getName();
		logger.info("In/getData/{}",data);
		//String hw = dmservice.getName(name);
		String msg  = "from appServer :" + data;

		return Response.status(200).entity(msg).build();

	}
	
}