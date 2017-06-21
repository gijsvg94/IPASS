package ipass.standenmotor.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ipass.standenmotor.webservice.Formulier;

public class FormulierDAO extends BaseDAO {

	public Formulier save(Formulier formulier) throws SQLException{
		System.out.println(formulier);
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				
				"INSERT INTO formulier(formulier_id, wedstrijd_id, opmerking_id, team_id_thuis, team_id_uit , doelputen_thuis, doelpunten_uit) VALUES (?,?,?,?,?,?,?)");
		
		stmt.setInt(1,  formulier.getFormulierID());
		stmt.setInt(2,  formulier.getWedstrijdID());
		stmt.setInt(3,  formulier.getOpmerkingID());
		stmt.setInt(4,  formulier.getTeamIDThuis());
		stmt.setInt(5,  formulier.getTeamIDUit());
		stmt.setInt(6,  formulier.getDoelpuntenThuis());
		stmt.setInt(7,  formulier.getDoelpuntenUit());
		
		stmt.executeUpdate();
		con.close();
		return formulier;
	}
	
	
	public Formulier findFormulierByID(int formulierID) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM formulier WHERE formulierID='" + formulierID +"'");
		ResultSet res = stmt.executeQuery();
		List<Formulier> formulierList = new ArrayList<Formulier>();
		while (res.next()) {
			
			int formulierid = res.getInt("formulier_id");
			int wedstrijdid = res.getInt("wedstrijd_id");
			int opmerkingid = res.getInt("opmerking_id");
			int teamidthuis = res.getInt("team_id_thuis");
			int teamiduit = res.getInt("team_id_uit");
			int doelpuntenthuis = res.getInt("doelpunten_thuis");
			int doelpuntenuit = res.getInt("doelpunten_uit");
		
			Formulier f = new Formulier(formulierid, wedstrijdid, opmerkingid , teamidthuis, teamiduit, doelpuntenthuis, doelpuntenuit);
			formulierList.add(f);
		}
		res.close();
		con.close();
		return formulierList.get(0);
	}
}
