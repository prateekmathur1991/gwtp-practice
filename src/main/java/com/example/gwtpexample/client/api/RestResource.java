package com.example.gwtpexample.client.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.gwtpexample.client.dto.RestResponseDto;
import com.gwtplatform.dispatch.rest.shared.RestAction;

@Produces(MediaType.APPLICATION_JSON)
@Path("/test")
public interface RestResource {

	@GET
	RestAction<RestResponseDto> getRestResponse();
}