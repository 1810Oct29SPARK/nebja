import org.hibernate.SessionFactory;

import nebja.beans.Movie;
import nebja.dao.MovieDAO;
import nebja.dao.MovieDAOImpl;
import nebja.dao.ReviewDAO;
import nebja.dao.ReviewDAOImpl;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.util.NebjaUtil;

public class driver {
static SessionFactory sf = NebjaUtil.getSessionFactory();
	public static void main(String args[]) {
		UserDAO u = new UserDAOImpl();
		ReviewDAO r = new ReviewDAOImpl();
		MovieDAO m = new MovieDAOImpl();
		m.addMovie(new Movie(69,"Dirty Butt Stuff The Movie"));
		//	String imageURL= "C:\\Users\\dukem\\Documents\\Blackops.jpg";
		
		
		//u.getPhoto(21);
		//ReviewDAO r = new ReviewDAOImpl()
	//r.createUserReview(new Review("Dude,Where's My Car was friggin hilarious!",8));
}
}