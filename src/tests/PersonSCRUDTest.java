package tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.beans.Person;
import fr.impl.PersonSCRUDImpl;

public class PersonSCRUDTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;

	@EJB
	PersonSCRUDImpl personSCRUD;

	Person personG = new Person();
	Person personThomas = new Person();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("myMySQLBase");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
		emf.close();
	}
	
	@Before
	public void setUp(){
		personG.setBirthday("28/03/1992");
		personG.setEmail("alias@hotmail.fr");
		personG.setFirstName("G");
		personG.setLastName("G");
		personG.setPassword("azerty");
		personG.setWeb("google.fr");
		
		personThomas.setBirthday("28/03/1992");
		personThomas.setEmail("aa@aa.fr");
		personThomas.setFirstName("Thomas");
		personThomas.setLastName("Rambaldi");
		personThomas.setPassword("azerty");
		personThomas.setWeb("google.fr");
	}
	
	@Test
	public void testSearchPerson() throws SQLException{
		personSCRUD.searchPerson("Thomas");
	}
	
	@Test
	public void testCreatePerson() throws SQLException{
		personSCRUD.createPerson(personThomas);
		assertEquals("aa@aa.fr", personSCRUD.readPerson(personThomas).getEmail());
	}

	@Test
	public void testReadPerson() throws SQLException{
		assertEquals("alias@hotmail.fr", personSCRUD.readPerson(personThomas).getEmail());
	}
	
	@Test
	public void testUpdatePerson() throws SQLException {
		personThomas.setLastName("Rambaldus");
		personThomas.setFirstName("Thomulus");
		personSCRUD.updatePerson(personThomas, "aa@aa.fr");
	}
	
	@Test
	public void testDeletePerson() throws SQLException {
		
	}
}
