package ipass.standenmotor.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ipass.standenmotor.webservice.Spelerslijst;


public class SpelerslijstDAO extends BaseDAO {

	public Spelerslijst save(Spelerslijst spelerslijst) throws SQLException{
		System.out.println(spelerslijst);
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
		
				"INSERT INTO spelerlijst (spelerid, naam, status, teamid) VALUES (?,?,?,?)");
		
		stmt.setInt(1,  spelerslijst.getSpelersID());
		stmt.setString(2, spelerslijst.getNaam());
		stmt.setString(3,  spelerslijst.getStatus());
		stmt.setInt(4,  spelerslijst.getteamID());
		
		stmt.executeUpdate();
		con.close();
		return spelerslijst;
	}
	
	public Spelerslijst findSpelerlijstByID(int teamID) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM spelerslijst WHERE teamID='" + teamID +"'");
		ResultSet res = stmt.executeQuery();
		List<Spelerslijst> spelerslijstList = new ArrayList<Spelerslijst>();
		while (res.next()) {
			
			int spelersID = res.getInt("spelers_id");
			String naam = res.getString("naam");
			String status = res.getString("status");
			int teamID1 = res.getInt("team_id");
			
			Spelerslijst s = new Spelerslijst(spelersID, naam, status, teamID1);
			spelerslijstList.add(s);
		}
		
		res.close();
		con.close();
		return spelerslijstList.get(0);
	}

	
		
		
		
		
}
