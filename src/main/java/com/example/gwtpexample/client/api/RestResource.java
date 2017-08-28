package com.example.gwtpexample.client.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.gwtpexample.shared.dto.RestResponseDto;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RestResource {

	@GET
	@Path("/rest")
	RestResponseDto getRestResponse();
}