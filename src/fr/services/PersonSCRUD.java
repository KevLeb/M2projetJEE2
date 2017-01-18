package fr.services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Remote;

import fr.beans.Person;

@Remote
public interface PersonSCRUD {

	public ArrayList<Person> searchPerson(String search) throws SQLException ;
	public void createPerson(Person p) 					 throws SQLException ;
	public Person readPerson(Person p)   				 throws SQLException ;
	public void updatePerson(Person p, String id) 		 throws SQLException ;
	public void deletePerson(Person p) 					 throws SQLException;
	
}
