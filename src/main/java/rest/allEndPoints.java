package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class allEndPoints {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCountMovies() {
        long count = (long) FACADE.countAllMovies();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @GET
    @Path("/title/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieByName(@PathParam("title") String title) {
        List<Movie> movieList = FACADE.getMovieByTitle(title);
        return GSON.toJson(movieList);
    }

    @GET
    @Path("/{year}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieById(@PathParam("year") int year) {
        Movie movie = FACADE.getMovieById(year);
        return GSON.toJson(movie);
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        List<Movie> allMovies = FACADE.getAllMovies();
        return GSON.toJson(allMovies);
    }

    @Path("add")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String addMovie() {

        MovieDTO movie = new MovieDTO(FACADE.addMovie(7, "Batman", "thriller", "Nolan", 2011));

        return new Gson().toJson(movie);

    }
}
