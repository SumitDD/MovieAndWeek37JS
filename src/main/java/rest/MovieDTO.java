package rest;

import entities.Movie;

public class MovieDTO {
    
    
  
    private String title;
    private String genre;
    private String director;
    private int year;
    private long id;
    
    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.director = movie.getDirector();
        this.year = movie.getYear();
    }

    public MovieDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "title=" + title + ", genre=" + genre + ", director=" + director + ", year=" + year + ", id=" + id + '}';
    }
    
    

}
