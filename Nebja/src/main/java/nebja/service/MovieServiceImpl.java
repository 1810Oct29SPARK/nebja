package nebja.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.Movie;
import nebja.dao.MovieDAO;
import nebja.dao.MovieDAOImpl;

@Service(value="movieService")
public class MovieServiceImpl implements MovieService {

	MovieDAO md = new MovieDAOImpl();
	
	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return md.getAllMovies();
	}

	@Override
	public double getMovieScore(int movieid) {
		// TODO Auto-generated method stub
		return md.getMovieScore(movieid);
	}

	@Override
	public Blob getMoviePoster(int movieid) {
		// TODO Auto-generated method stub
		return md.getMoviePoster(movieid);
	}

	@Override
	public String getMovieTitle(int movieid) {
		// TODO Auto-generated method stub
		return md.getMovieTitle(movieid);
	}

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		 md.addMovie(movie);
	}

}
