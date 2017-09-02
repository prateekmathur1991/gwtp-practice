package com.example.gwtpexample.server.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.example.gwtpexample.shared.dto.RestResponseDto;

@Produces(MediaType.APPLICATION_JSON)
@Path("/test")
public class RestResourceImpl {

	@GET
	public Response getRestResponse() {

		RestResponseDto restResponseDto = new RestResponseDto("ACCESS_TOKEN", "REFRESH_TOKEN");

		ResponseBuilder responseBuilder = Response.ok(restResponseDto, MediaType.APPLICATION_JSON);
		return responseBuilder.build();
	}
}