package entities;

import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        MovieFacade facade = MovieFacade.getFacadeExample(emf);

      
            System.out.println(facade.countAllMovies());
            System.out.println(facade.addMovie(2, "IT", "gyser", "mig", 2022));
    }

}
