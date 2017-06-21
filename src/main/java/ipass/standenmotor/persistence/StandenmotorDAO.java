package ipass.standenmotor.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ipass.standenmotor.webservice.Standenmotor;

public class StandenmotorDAO extends BaseDAO {
	public Standenmotor save(Standenmotor standenmotor) throws SQLException {
		System.out.print(standenmotor);
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO standenmotor (standenmotorid , punten, doelpuntenvoor, doelpuntentegen, gewonnenwedstrijden, verlorenwedstrijden, gelijkewedstrijden, teamid) VALUES (?,?,?,?,?,?,?,?)");

		stmt.setInt(1, standenmotor.getPunten());
		stmt.setInt(2, standenmotor.getDoelpuntenVoor());
		stmt.setInt(3, standenmotor.getDoelpuntenTegen());
		stmt.setInt(4, standenmotor.getGewonnenWedstrijden());
		stmt.setInt(5, standenmotor.getVerlorenWedstrijden());
		stmt.setInt(6, standenmotor.getGelijkeWedstrijden());
		stmt.setInt(7, standenmotor.getTeamID());

		stmt.executeUpdate();
		con.close();
		return standenmotor;
	}

	public Standenmotor showStandenmotor() throws SQLException {
	Connection con = super.getConnection();
	PreparedStatement stmt = con.prepareStatement(" SELECT * FROM standenmotor INNER JOIN teamlijst ON (standenmotor.team_id = teamlijst.team_id) ORDER BY punten DESC;");
	ResultSet res = stmt.executeQuery();
	List<Standenmotor> standenmotorList = new ArrayList<Standenmotor>();
	while (res.next()) {

		int punten = res.getInt("punten");
		int doelpuntenvoor = res.getInt("doelpuntenvoor");
		int doelpuntentegen = res.getInt("doelpuntentegen");
		int gewonnenwedstrijden = res.getInt("gewonnenwedstrijden");
		int verlorenwedstrijden = res.getInt("verlorenwedstrijden");
		int gelijkewedstrijden = res.getInt("gelijkewedstrijden");
		int teamID = res.getInt("teamID");
		
		Standenmotor s = new Standenmotor ( punten, doelpuntenvoor, doelpuntentegen, gewonnenwedstrijden, verlorenwedstrijden, gelijkewedstrijden, teamID, teamID);
		standenmotorList.add(s);
	}
	
	res.close();
	con.close();
	return standenmotorList.get(0);
}
}
