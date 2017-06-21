package ipass.standenmotor.webservice;

public class Formulier {

	public int formulierid;
	public int wedstrijdid;
	public int opmerkingid;
	public int teamidthuis;
	public int teamiduit;
	public int doelpuntenthuis;
	public int doelpuntenuit;
	
	public Formulier (int fid, int wid, int oid, int tidt, int tidu, int dpt , int dpu){ 
	formulierid = fid;
	wedstrijdid = wid;
	opmerkingid = oid;
	teamidthuis = tidt;
	teamiduit = tidu;
	doelpuntenthuis = dpt;
	doelpuntenuit = dpu;
}

	public int getFormulierID() {
		return formulierid;
	}
	public int getWedstrijdID() {
		return wedstrijdid;
	}
	public int getOpmerkingID() {
		return opmerkingid;
	}
	public int getTeamIDThuis() {
		return teamidthuis;
	}
	public int getTeamIDUit() {
		return teamiduit;
	}
	public int getDoelpuntenThuis() {
		return doelpuntenthuis;
	}
	public int getDoelpuntenUit() {
		return doelpuntenuit;
	}
}