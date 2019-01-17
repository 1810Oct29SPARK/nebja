package nebja.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.Movie;


public interface MovieService {

		public List<Movie> getAllMovies();
		public double getMovieScore(int movieid);
		public Blob getMoviePoster(int movieid);
		public String getMovieTitle(int movieid);
		public void addMovie(Movie movie);
		public void addToWatchlist(String username, Movie movie);

}
