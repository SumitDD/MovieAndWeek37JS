package facades;

import entities.Movie;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MovieFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
           // em.createNamedQuery("DELETE FROM Movie m").executeUpdate();
          //em.persist(new Movie(555, "hej", "med", "dig", 55));
           // em.persist(new Movie(666, "dd", "www", "dddd", 20222));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testCountAllMovies() {
        assertEquals(4, facade.countAllMovies());
    }

    @Test
    public void testAddMovie() {
        assertEquals("Movie:Sumit id:13", facade.addMovie(12, "Sumit", "Komedie", "Dey", 1999).toString());
    }
//    @Test
//    public void testFindMovieByName() {
//        assertEquals("[Sumit]", facade.findMovieByTitle("Sumit").toString());
//    }
    

}
