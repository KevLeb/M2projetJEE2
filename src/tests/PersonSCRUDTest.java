package tests;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.beans.Activity;

public class PersonSCRUDTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("sample");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	public void searchActivityTest() throws SQLException{
		
	}
	
	@Test
	public void createActivityTest() throws SQLException{
		
	}
	
	public void readActivity() throws SQLException{
		
	}
	
	public void updateActivity() throws SQLException {
		
	}
	
	public void deleteActivity() throws SQLException {
		
	}
}
