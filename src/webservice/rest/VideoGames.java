package webservice.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.HttpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Game;
import dao.GameDao;


@Path("/VideoGames")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class VideoGames {
	
	@PermitAll
	@GET
	@Path("/games")
	public Response getProducts(@Context HttpRequest request) {
		
//		System.out.println("\n!!!!!!!!!!     GetProducts OK      !!!!!!!");
//		List<Game> list = GameDao.findAllSQL();
//		for(Game g : list) {
//			System.out.println(g.getTitle());
//		}
//		ResponseBuilder rb;
//		rb = Response.ok().status(200);
//		return rb.build();
		
		
		
		
		List<Game> list = GameDao.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(list);
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

}
