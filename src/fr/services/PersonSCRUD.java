package fr.services;

import java.sql.SQLException;

import javax.ejb.Remote;

import fr.beans.Person;

@Remote
public interface PersonSCRUD {

	public Person searchPerson(String search) throws SQLException ;
	public void createPerson(Person p) throws SQLException ;
	public void readPerson(Person p)   throws SQLException ;
	public void updatePerson(Person p) throws SQLException ;
	public void deletePerson(Person p) throws SQLException;
	
}
