package fr.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import fr.beans.Person;
import fr.services.PersonSCRUD;

@Stateless(name = "pers", description = "Representation d'une personne")
public class PersonSCRUDImpl implements PersonSCRUD{

	@Resource(name = "myDS")
	private DataSource ds;

	@Override
	public Person searchPerson(String search) throws SQLException {
		Person pers = new Person();
		
		String query = "SELECT firstName, lastName, email, web, birthday FROM Person "
				+ "WHERE firstName LIKE " + "'%"+ search + "%'" +
				" OR lastName   LIKE " + "'%"+ search + "%'" +
				" OR email      LIKE " + "'%"+ search + "%' ORDER BY firstName, lastName";
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		ResultSet rs = st.executeQuery(query);
		if(! rs.next())
			return null;
		
		pers.setFirstName( rs.getString(1) );
		pers.setLastName ( rs.getString(2) );
		pers.setEmail	 ( rs.getString(3) );
		pers.setWeb		 ( rs.getString(4) );
		pers.setBirthday ( rs.getString(5) );
		pers.setPassword ( rs.getString(6) );
		
		st.execute();
		
		return pers;
	}

	@Override
	public void createPerson(Person p) throws SQLException{
		String query = "INSERT INTO Person (firstName, lastName, email, web, birthday, password "
				+ "VALUES( ?, ?, ?, ?, ?, ?)";
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);

		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String email = p.getEmail();
		String web = p.getWeb();
		String naissance = p.getBirthday();
		String password= p.getPassword();

		st.execute();		
	}

	@Override
	public void readPerson(Person p)  throws SQLException {
		String query = "SELECT firstName, lastName, email, web, birthday FROM Person "
				+ "WHERE firstName = " + p.getFirstName()  +
				" OR lastName      = " + p.getLastName() +
				" OR email         = " + p.getEmail() + 
				" OR web           = " + p.getWeb() + 
				" OR birthday      = " + p.getBirthday();
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		st.execute();
	}

	@Override
	public void updatePerson(Person p) throws SQLException {
		String query = "UPDATE Person SET firstName = ?, lastName = ?, email = ?, web = ? ,"
				+ "birthdat = ?, password = ?  WHERE email = ?";
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String email = p.getEmail();
		String web = p.getWeb();
		String naissance = p.getBirthday();
		String password= p.getPassword();
		
		st.execute();		
	}

	@Override
	public void deletePerson(Person p) throws SQLException {
		String query = "DELETE FROM Person WHERE idGroup = " + p.getEmail();
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		st.execute();	
	}

}
