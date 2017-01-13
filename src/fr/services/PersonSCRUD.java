package fr.services;

import javax.ejb.Remote;

import fr.beans.Person;

@Remote
public interface PersonSCRUD {

	public void searchPerson(Person p);
	public void createPerson(Person p);
	public void readPerson(Person p);
	public void updatePerson(Person p);
	public void deletePerson(Person p);
	
}
