import org.hibernate.SessionFactory;

import nebja.beans.Movie;
import nebja.beans.Watchlist;
import nebja.dao.MovieDAO;
import nebja.dao.MovieDAOImpl;
import nebja.dao.ReviewDAO;
import nebja.dao.ReviewDAOImpl;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.dao.WatchlistDAO;
import nebja.dao.WatchlistImpl;
import nebja.util.NebjaUtil;

public class driver {
static SessionFactory sf = NebjaUtil.getSessionFactory();
	public static void main(String args[]) {
		UserDAO u = new UserDAOImpl();
		ReviewDAO r = new ReviewDAOImpl();
		MovieDAO m = new MovieDAOImpl();
		WatchlistDAO wd = new WatchlistImpl();
		int idone = 2;
		int idtwo = 4;
		System.out.println(wd.getWatchlist(4));
		//m.addMovie(new Movie(69,"Dirty Butt Stuff The Movie"));
		//	String imageURL= "C:\\Users\\dukem\\Documents\\Blackops.jpg";
		//System.out.println(r.getUserReviewsbyMovieid(8922));
		//System.out.println(r.getUserReviewsbyMovieid(8922));
		//u.getPhoto(21);
		//ReviewDAO r = new ReviewDAOImpl()
	//r.createUserReview(new Review("Dude,Where's My Car was friggin hilarious!",8));
}
}