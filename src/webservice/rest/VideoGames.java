package webservice.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.HttpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Game;
import beans.Type;
import dao.GameDao;

@Path("/VideoGames")
// @Consumes(MediaType.APPLICATION_JSON)
// @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class VideoGames {

	 @PermitAll
	 @GET
	 @Path("/games")
	 public Response getVideoGames(@Context HttpRequest request) {
	 List<Game> dataBaseGames = GameDao.findAllSQL();
	 List<String> dataBaseGamesNames = new ArrayList<String>();
	 for(Game game : dataBaseGames) {
	 dataBaseGamesNames.add(game.getTitle());
	 }
	 ObjectMapper mapper = new ObjectMapper();
	 mapper.enable(SerializationFeature.INDENT_OUTPUT);
	 String json = "[]";
	 try {
	 json = mapper.writeValueAsString(dataBaseGamesNames);
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
	// @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
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

	@PermitAll
	@GET
	@Path("/games/{name}/type")
	// @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getVideoGameType(@PathParam("name") String name) {
		Type type = GameDao.findGameTypeSQL(name);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(type);
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

	class GameType {
		private String title;
		private Double price;
		private String console;
		private String types;

		public GameType(String title, String console, Double price, String types) {
			this.setTitle(title);
			this.setConsole(console);
			this.setPrice(price);
			this.setTypes(types);
		}

		public String getTypes() {
			return types;
		}

		public void setTypes(String types) {
			this.types = types;
		}

		public String getConsole() {
			return console;
		}

		public void setConsole(String console) {
			this.console = console;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

	}
}
