package facades;

import entities.Movie;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import rest.MovieDTO;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long countAllMovies() {
        EntityManager em = emf.createEntityManager();
        try {
            long count = (long) em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return count;
        } finally {
            em.close();
        }

    }

    public List<Movie> getMovieByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Movie.getByTitle");
            query.setParameter("title", title);
            List<Movie> movieList = query.getResultList();
            return movieList;
        } finally {
            em.close();
        }
    }

    public Movie getMovieById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Movie.getById");
            query.setParameter("year", id);
            Movie movie = (Movie) query.getSingleResult();
            return movie;
        } finally {
            em.close();
        }
    }

    public List<Movie> getAllMovies() {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Movie.getAll");
            List<Movie> movies = query.getResultList();
            return movies;
        } finally {
            em.close();
        }
    }

    public Movie addMovie(long id, String title, String genre, String director, int year) {
        Movie movie = new Movie(id, title, genre, director, year);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie;
        } finally {
            em.close();
        }
    }

}
