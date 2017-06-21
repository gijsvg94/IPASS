package ipass.standenmotor.webservice;

import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ipass.standenmotor.model.ServiceProvider;
import ipass.standenmotor.model.WorldService;

public class SpelerslijstResource {

	@GET
	@Path("spelerlijst/{teamid}")
	@Produces("application/json")
	public String getSpelerslijst(@PathParam("teamid") int teamid) throws SQLException{
		WorldService service = ServiceProvider.getWorldService();
		Spelerslijst spelerslijst = service.getSpelerlijstByID(teamid);
				
		JsonObjectBuilder job =Json.createObjectBuilder();
			job.add("spelersid", spelerslijst.getSpelersID());
			job.add("naam", spelerslijst.getNaam());
			job.add("status", spelerslijst.getStatus());
			job.add("teamid", spelerslijst.getteamID());
			
			return job.build().toString();
		}
}
		
		
		
		
		
		
		
		
		
		