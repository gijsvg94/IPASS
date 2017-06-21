package ipass.standenmotor.webservice;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ipass.standenmotor.model.ServiceProvider;
import ipass.standenmotor.model.WorldService;

@Path("/standenmotor")
public class StandenmotorResource {

	
	@GET
	@Produces("application/json")
	public String getStandenmotor() throws SQLException{
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Standenmotor standenmotor = service.getStandenmotor();

			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("punten", standenmotor.getPunten());
			job.add("doelpuntenvoor", standenmotor.getDoelpuntenVoor());
			job.add("doelpuntentegen", standenmotor.getDoelpuntenTegen());
			job.add("gewonnenwedstrijden", standenmotor.getGewonnenWedstrijden());
			job.add("gelijkewedstrijden", standenmotor.getGelijkeWedstrijden());
			job.add("verlorenwedstrijden", standenmotor.getVerlorenWedstrijden());
			job.add("teamID", standenmotor.getTeamID());
				

	return job.build().toString();

	}

}