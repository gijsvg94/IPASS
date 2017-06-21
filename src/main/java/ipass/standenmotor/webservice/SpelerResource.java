package ipass.standenmotor.webservice;

import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ipass.standenmotor.model.ServiceProvider;
import ipass.standenmotor.model.WorldService;

public class SpelerResource {

	
	@GET
	@Path("restservices/getspeler/{speler_id}")
	@Produces("application/json")
	public String getSpelerInfo(@PathParam("speler_id") int speler_id) throws SQLException {
		WorldService service = ServiceProvider.getWorldService();
		Speler speler = service.getSpelerInfo(speler_id);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("spelerid", speler.getSpelerID());
		job.add("naam",	speler.getNaam());
		job.add("status", speler.getStatus());
		job.add("teamid", speler.getTeamID());
		
		
		return job.build().toString();
}
	@DELETE
	@RolesAllowed("captain")
	@Path("restservices/delete/{speler_id}")
	public Response deleteSpeler(@PathParam("speler_id") int speler_id) throws SQLException {
		Speler speler = null;
		WorldService service = ServiceProvider.getWorldService();
		System.out.println(speler_id);
		speler = service.getSpelerInfo(speler_id);
		System.out.println(speler_id);
		if (speler == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			service.delete(speler);
			return Response.ok().build();
		}
}
	@POST
	@RolesAllowed("captain")
	@Path("restservices/addSpeler")
	@Produces("application/json")
	public String createSpeler(InputStream is) throws SQLException {
		WorldService service = ServiceProvider.getWorldService();
		JsonObject object = Json.createReader(is).readObject();
		int spelerid = object.getInt("spelerid");
		String naam = object.getString("naam");
		String status = object.getString("status");
		int teamid = object.getInt("teamid");
		
		Speler newSpeler = new Speler(spelerid, naam, status, teamid);
		service.addSpeler(newSpeler);
		return spelerToJson(newSpeler).build().toString();
		
	}
	private JsonObjectBuilder spelerToJson(Speler s) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("spelerid" , s.getSpelerID());
		job.add("naam" , s.getNaam());
		job.add("status" , s.getStatus());
		job.add("teamid", s.getTeamID());
		return job;
	}
	
	@PUT
	@RolesAllowed("captain")
	@Path("restservices/{spelerid}")
	@Produces("application/json")
	
	public Response updateSpeler(@PathParam("spelerid") int spelerid, InputStream is) throws SQLException {
		WorldService service = ServiceProvider.getWorldService();
		JsonObject object = Json.createReader(is).readObject();
		
		int spelerid1 = object.getInt("spelerid");
		String naam = object.getString("naam");
		String status = object.getString("status");
		int teamid = object.getInt("teamid");
		
		Speler speler = service.getSpelerInfo(spelerid);
		
		speler.spelerid = spelerid;
		speler.naam = naam;
		speler.status = status;
		speler.teamid = teamid;
		
		if(service.updateSpelers(speler) !=null) {
			System.out.println("succes");
			return Response.ok().build();
			
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
}















