package ipass.standenmotor.model;

import java.sql.SQLException;

import ipass.standenmotor.persistence.FormulierDAO;
import ipass.standenmotor.persistence.SpelerDAO;
import ipass.standenmotor.persistence.SpelerslijstDAO;
import ipass.standenmotor.persistence.StandenmotorDAO;
import ipass.standenmotor.persistence.UserDAO;
import ipass.standenmotor.webservice.Formulier;
import ipass.standenmotor.webservice.Speler;
import ipass.standenmotor.webservice.Spelerslijst;
import ipass.standenmotor.webservice.Standenmotor;

public class WorldService {
	private SpelerslijstDAO SpelerslijstDAO = new SpelerslijstDAO();
	
	private StandenmotorDAO StandenmotorDAO = new StandenmotorDAO();
	
	private SpelerDAO SpelerDAO = new SpelerDAO();
	
	private FormulierDAO FormulierDAO = new FormulierDAO();
	
	private UserDAO UserDAO = new UserDAO();
	
	//Spelerslijst	
	public Spelerslijst getSpelerlijstByID(int teamID) throws SQLException {
		return SpelerslijstDAO.findSpelerlijstByID(teamID);
	}
	
	public void addSpelerslijst(Spelerslijst spelerslijst) throws SQLException {
		SpelerslijstDAO.save(spelerslijst);
	}
	
	//Speler
	public Speler updateSpelers(Speler speler) throws SQLException {
		return SpelerDAO.update(speler);
	}
	
	public boolean delete(Speler Speler) throws SQLException {
		return SpelerDAO.delete(Speler);
	}
	
	public void addSpeler(Speler speler) throws SQLException {
		SpelerDAO.save(speler);
	}
	
	public Speler getSpelerInfo(int speler_id) throws SQLException{
		return SpelerDAO.findSpelerbByID(speler_id);
	}
		
	//Standenmotor
	public Standenmotor getStandenmotor() throws SQLException {
		return StandenmotorDAO.showStandenmotor();
	}
			
	public void addStandenmotor(Standenmotor standenmotor) throws SQLException {
		StandenmotorDAO.save(standenmotor);
	}
	
	
	//Formulier
	public void addFormulier(Formulier formulier) throws SQLException {
		FormulierDAO.save(formulier);
		}

	public Formulier getFormulier(int formulierID) throws SQLException {
		return FormulierDAO.findFormulierByID(formulierID);
	}
}
