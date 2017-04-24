package webservice.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.HttpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Game;
import dao.GameDao;


@Path("/VideoGames")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class VideoGames {
	
	@PermitAll
	@GET
	@Path("/games")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getProducts(@Context HttpRequest request) {

		List<Game> dataBaseGames = GameDao.findAllSQL();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(dataBaseGames);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		ResponseBuilder rb;
		if(json.isEmpty()) {
			rb = Response.serverError().status(404);
		}
		else {
			rb = Response.ok(json).status(200);
		}		
		return rb.build();
	}
	
	@PermitAll
	@GET
	@Path("/games/{name}")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getVideoGame(@PathParam("name") String name) {
		Game game = GameDao.findSQL(name);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(game);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		ResponseBuilder rb;
		if (json.isEmpty()) {
			rb = Response.serverError().status(404);
		} else {
			rb = Response.ok(json).status(200);
		}
		return rb.build();
	}
	
//	@PermitAll
//	@GET
//	@Path("/games/{name}/type")
//	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
//	public Response getVideoGameType(@PathParam("name") String name) {
//		
//	}

}
