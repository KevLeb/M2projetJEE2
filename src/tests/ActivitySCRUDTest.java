package tests;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActivitySCRUDTest {

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
	public void testSearchActivity() throws SQLException{
		
	}
	
	@Test
	public void testCreateActivity() throws SQLException{
		
	}
	
	@Test
	public void testReadActivity() throws SQLException{
		
	}
	
	@Test
	public void testUpdateActivity() throws SQLException {
		
	}
	
	@Test
	public void testDeleteActivity() throws SQLException {
		
	}
}
