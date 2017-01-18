package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

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

}
