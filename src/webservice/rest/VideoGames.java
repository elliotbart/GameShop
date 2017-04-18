package webservice.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Stateless
@Path("/VideoGames")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class VideoGames {
	
	@GET
	@Path("/store")
//	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getstore(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom) {
//		List<Game> dataBaseGames = GameDao.findAll();
//		return Response.ok(dataBaseGames).build();
		
		String output = "Jersey repond !";
		return Response.status(200).entity(output).build();
	}

}
