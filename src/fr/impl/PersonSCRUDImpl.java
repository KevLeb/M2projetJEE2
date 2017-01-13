package fr.impl;

import javax.ejb.Stateless;

import fr.beans.Person;
import fr.services.PersonSCRUD;

@Stateless(name = "pers", description = "Representation d'une personne")
public class PersonSCRUDImpl implements PersonSCRUD{

	@Override
	public void searchPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

}
