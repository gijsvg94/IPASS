package ipass.standenmotor.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ipass.standenmotor.webservice.Speler;
import ipass.standenmotor.webservice.Spelerslijst;

public class SpelerDAO extends BaseDAO {

	public Speler save(Speler speler) throws SQLException{
		System.out.println(speler);
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
		
				"INSERT INTO spelerlijst (spelerid, naam, status, teamid) VALUES (?,?,?,?)");
		
		stmt.setInt(1,  speler.getSpelerID());
		stmt.setString(2, speler.getNaam());
		stmt.setString(3,  speler.getStatus());
		stmt.setInt(4,  speler.getTeamID());
		
		stmt.executeUpdate();
		con.close();
		return speler;
	}
	
	public Speler findSpelerbByID(int spelerid) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM spelerslijst WHERE spelerID='" + spelerid +"'");
		ResultSet res = stmt.executeQuery();
		List<Speler> spelerList = new ArrayList<Speler>();
		while (res.next()) {
			
			int spelersID = res.getInt("spelers_id");
			String naam = res.getString("naam");
			String status = res.getString("status");
			int teamID1 = res.getInt("team_id");
			
			Speler s = new Speler(spelersID, naam, status, teamID1);
			spelerList.add(s);
		}
		
		res.close();
		con.close();
		return spelerList.get(0);
	}
	
	public Speler update(Speler Speler) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("UPDATE spelerslijst SET spelerid =  ? , naam= ? , status = ? . teamid = ?" );
		
		stmt.setInt(1, Speler.getSpelerID());
		stmt.setString(2, Speler.getNaam());
		stmt.setString(3,  Speler.getStatus());
		stmt.setInt(4, Speler.getTeamID());
		
		stmt.executeUpdate();
		con.close();
		return Speler;
	}
	
	
	public boolean delete(Speler Speler) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM spelerslijst WHERE speler_id='" + Speler.getSpelerID() + "'");
		if (stmt.execute()) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}
}
}
