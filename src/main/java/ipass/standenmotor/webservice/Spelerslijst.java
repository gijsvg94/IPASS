package ipass.standenmotor.webservice;

public class Spelerslijst {

	public int spelersid;
	public String naam;
	public String status;
	public int teamid;
	
	public Spelerslijst(int spelersID, String name, String state, int teamID){
		spelersid = spelersID;
		naam = name;
		status = state;
		teamid = teamID;
	}
	
	public int getSpelersID(){
		return spelersid;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public String getStatus(){
		return status;
	}
	
	public int getteamID(){
		return teamid;
	}
}
