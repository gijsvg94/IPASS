package ipass.standenmotor.webservice;

public class Speler {

	public int spelerid;
	public String naam;
	public String status;
	public int teamid;

	public Speler(int spid, String name, String state, int tid) {
		spelerid = spid;
		naam = name;
		status = state;
		teamid = tid;
	}

	public int getSpelerID() {
		return spelerid;
	}

	public String getNaam(){
		return naam;
	}

	public String getStatus(){
		return status;
	}
	
	public int getTeamID(){
		return teamid;
	}
}