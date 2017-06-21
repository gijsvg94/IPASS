package ipass.standenmotor.webservice;

import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ipass.standenmotor.model.ServiceProvider;
import ipass.standenmotor.model.WorldService;

@Path("/ophalenformulier")
public class FormulierResource {

	@GET
	@RolesAllowed("scheidsrechter")
	@Produces("application/sjon")
	public String getFormulier(@PathParam("formulier_id") int formulierID) throws SQLException {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Formulier formulier = service.getFormulier(formulierID);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("formulierid", formulier.getFormulierID());
		job.add("wedstrijdid", formulier.getWedstrijdID());
		job.add("opmerkingid", formulier.getOpmerkingID());
		job.add("teamidthuis", formulier.getTeamIDThuis());
		job.add("teamiduit", formulier.getTeamIDUit());
		job.add("doelpuntenthuis", formulier.getDoelpuntenThuis());
		job.add("doelpuntenuit", formulier.getDoelpuntenUit());

		return job.build().toString();


	}
	
	@POST
	@RolesAllowed("scheidsrechter")
	@Path("/addFormulier")
	@Produces("application/json")
	public String createFormulier(InputStream is) throws SQLException {
		WorldService service = ServiceProvider.getWorldService();
		JsonObject object = Json.createReader(is).readObject();
		int formulierid = object.getInt("formulierid");
		int wedstrijdid = object.getInt("wedstrijdid");
		int opmerkingid = object.getInt("opmerkingid");
		int teamidthuis = object.getInt("teamidthuis");
		int teamiduit = object.getInt("teamiduit");
		int doelpuntenthuis = object.getInt("doelpuntenthuis");
		int doelpuntenuit = object.getInt("doelpuntenuit");

		
		Formulier newFormulier = new Formulier(formulierid, wedstrijdid, opmerkingid, teamidthuis, teamiduit, doelpuntenthuis, doelpuntenuit);
		service.addFormulier(newFormulier);
		return formulierToJson(newFormulier).build().toString();
		
	}
	private JsonObjectBuilder formulierToJson(Formulier f) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("formulierid", f.getFormulierID());
		job.add("wedstrijdid",  f.getWedstrijdID());
		job.add("opmerkingid", f.getOpmerkingID());
		job.add("teamidthuis", f.getTeamIDThuis());
		job.add("teamiduit", f.getTeamIDUit());
		job.add("doelpuntenthuis", f.getDoelpuntenThuis());
		job.add("doelpuntenuit",  f.getDoelpuntenUit());

		return job;
	}
}
