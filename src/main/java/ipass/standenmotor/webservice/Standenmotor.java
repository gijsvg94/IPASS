package ipass.standenmotor.webservice;

public class Standenmotor {
	
	public int standenmotorid;
	public int punten;
	public int doelpuntenvoor;
	public int doelpuntentegen;
	public int gewonnenwedstrijden;
	public int verlorenwedstrijden;
	public int gelijkewedstrijden;
	public int teamid;
	
	public Standenmotor(int stmid, int points, int dpvoor, int dptegen, int gww, int vlw, int glw, int teamID) {
	standenmotorid = stmid;
	punten = points;
	doelpuntenvoor = dpvoor;
	doelpuntentegen = dptegen;
	gewonnenwedstrijden = gww;
	verlorenwedstrijden = vlw;
	gelijkewedstrijden = glw;
	teamid = teamID;

}
	
		public int getPunten() {
		return punten;
	}

	public int getDoelpuntenVoor(){
		return doelpuntenvoor;
	}
	
	public int getDoelpuntenTegen(){
		return doelpuntentegen;
	}
	
	public int getGewonnenWedstrijden(){
		return gewonnenwedstrijden;
	}
	
	public int getVerlorenWedstrijden(){
		return verlorenwedstrijden;
	}
	
	public int getGelijkeWedstrijden(){
		return gelijkewedstrijden;
	}
	
	public int getTeamID(){
		return teamid;
	}
	
}