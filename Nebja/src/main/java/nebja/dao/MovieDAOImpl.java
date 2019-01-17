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
	
/*	@SuppressWarnings("deprecation")
	@Override
	public void createMovie(String username,Movie movie) {
	    try(Session s = sf.getCurrentSession()){
	        List<Movie> movies = new ArrayList<>();
	        System.out.println("name in createMovie in dao impl:"+username);
	        Transaction tx = s.beginTransaction();
	        org.hibernate.Query query = s.createQuery("from User where username= :username").setParameter("username", username);
	        List list = query.list();
	        User user = (User) query.uniqueResult();
	        boolean notInDatabase=true;
	        movies = s.createQuery("from Movie").getResultList();
	        for(Movie movieInList: movies)
	        {
	            System.out.println(movieInList);
	            if(movie.getTitle().equals(movieInList.getTitle()))
	            {
	                System.out.println("movie match: "+movieInList);
	                user.getMovies().add(movieInList);
	                notInDatabase=false;
	                tx.commit();
	                s.close();
	                break;
	            }
	        }
	        if(notInDatabase==true)
	        {
	        user.getMovies().add(movie);
	        tx.commit();
	        s.close();
	        }
	    }
	}*/
	
	public void addMovie(Movie movie) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(movie);
			tx.commit();
			s.close();
			
	}
	}
		public void addMovieWatch(int id, int anotherid){
			try(Session s = sf.getCurrentSession()){
				Transaction tx = s.beginTransaction();
		}
	}
}
