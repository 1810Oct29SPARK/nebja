package nebja.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nebja.beans.Movie;
import nebja.beans.User;
import nebja.util.NebjaUtil;

public class MovieDAOImpl implements MovieDAO {
static SessionFactory sf = NebjaUtil.getSessionFactory();
private UserDAOImpl ud;

/**
 * It gets all movies in our movie database
 */
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();	
		try(Session s = sf.getCurrentSession()){
				Transaction tx = s.beginTransaction();
				movies = s.createQuery("from Movie").getResultList();
				tx.commit();
				s.close();
		}
		return movies;
	}
/**
 * gets the movie score
 */
	@Override
	public double getMovieScore(int movieid) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
		Movie m = s.get(Movie.class, movieid);
		double d = m.getAvgscore();
		return d;
		}
		
	}

	@Override
	public Blob getMoviePoster(int movieid) {
		// TODO Auto-generated method stub
		return null;
	}
/**
 * Gets the title column based on id passed in from database
 */
	@Override
	public String getMovieTitle(int movieid) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Movie m = s.get(Movie.class,movieid);
			String title = m.getTitle();
			return title;
		}
		
	}
@Override
public void createMovie(String username,Movie movie) {
	try(Session s = sf.getCurrentSession()){
		List<Movie> movies = new ArrayList<>();	
		User user=ud.getUserByUsername(username);
		Transaction tx = s.beginTransaction();
		boolean notInDatabase=true;
		movies = s.createQuery("from Movie").getResultList();
		for(Movie movieInList: movies)
		{
			if(movie.getTitle().equals(movieInList.getTitle()))
			{
				user.getMovies().add(movie);
				s.merge(user);
				notInDatabase=false;
				break;
			}
		}
		if(notInDatabase==true)
		{
		user.getMovies().add(movie);
		s.merge(user);
		s.persist(movie);
		tx.commit();
		s.close();
		}
	}
	
}
	
}
