package fr.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Person> searchPerson(String search) throws SQLException {
		ArrayList<Person> persons = new ArrayList<Person>();
		
		String query = "SELECT firstName, lastName, email, web, birthday FROM Person "
				+ "WHERE firstName LIKE " + "'%"+ search + "%'" +
				" OR lastName   LIKE " + "'%"+ search + "%'" +
				" OR email      LIKE " + "'%"+ search + "%' ORDER BY firstName, lastName";
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		st.execute(query);
		ResultSet rs = st.executeQuery(query);
		
		if(! rs.next())
			return null;
		
		Person pers = new Person();
		pers.setFirstName( rs.getString(1) );
		pers.setLastName ( rs.getString(2) );
		pers.setEmail	 ( rs.getString(3) );
		pers.setWeb		 ( rs.getString(4) );
		pers.setBirthday ( rs.getString(5) );
		pers.setPassword ( rs.getString(6) );
		persons.add(pers);
		
		return persons;
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
		String birthday = p.getBirthday();
		String password= p.getPassword();

		prepareQuery(st, firstName, lastName, email, web, birthday, password);
		
		st.execute();		
		//TODO mettre peut etre un ResultSet
	}

	@Override
	public Person readPerson(Person p)  throws SQLException {
		String query = "SELECT firstName, lastName, email, web, birthday FROM Person "
				+ "WHERE firstName = " + p.getFirstName()  +
				" OR lastName      = " + p.getLastName() +
				" OR email         = " + p.getEmail() + 
				" OR web           = " + p.getWeb() + 
				" OR birthday      = " + p.getBirthday();
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		st.execute(query);
		ResultSet rs = st.executeQuery(query);

		if (! rs.next())
			return null;
		
		Person pers = new Person();
		pers.setFirstName( rs.getString(1) );
		pers.setLastName ( rs.getString(2) );
		pers.setEmail	 ( rs.getString(3) );
		pers.setWeb		 ( rs.getString(4) );
		pers.setBirthday ( rs.getString(5) );
		pers.setPassword ( rs.getString(6) );
		
		return pers;
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
		String birthday = p.getBirthday();
		String password= p.getPassword();
		
		prepareQuery(st, firstName, lastName, email, web, birthday, password);
		
		st.execute();		
	}

	@Override
	public void deletePerson(Person p) throws SQLException {
		String query = "DELETE FROM Person WHERE idGroup = " + p.getEmail();
		Connection c = ds.getConnection();
		PreparedStatement st = c.prepareStatement(query);
		st.execute(query);	
	}

	private void prepareQuery(PreparedStatement st, Object ... parameters) throws SQLException{
		for ( int i=0; i< parameters.length ; i++){
			if(parameters[i] instanceof String)
				st.setString(i+1, (String) parameters[i]);
			else if(parameters[i] instanceof Integer)
				st.setInt(i+1, (Integer) parameters[i]);
			else if(parameters[i] instanceof java.math.BigDecimal)
				st.setBigDecimal(i+1, (java.math.BigDecimal) parameters[i]);
		}
	}
}
