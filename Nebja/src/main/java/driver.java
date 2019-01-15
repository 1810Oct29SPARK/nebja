import org.hibernate.Session;
import org.hibernate.SessionFactory;

import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.util.NebjaUtil;

public class driver {
	static SessionFactory sf = NebjaUtil.getSessionFactory();

	public static void main(String args[]) {
		UserDAO u = new UserDAOImpl();
		// String imageURL= "C:\\Users\\dukem\\Documents\\Blackops.jpg";
//		u.createUser(new User("Weblogic2","beepboop","I MAKE EVERYTHING WORSE HAHAHA"));

		// u.getPhoto(21);
		// ReviewDAO r = new ReviewDAOImpl()
		// r.createUserReview(new Review("Dude,Where's My Car was friggin
		// hilarious!",8));

		testingUsers(sf);
	}
	
	static void testingUsers(SessionFactory sf) {
		UserDAO ud = new UserDAOImpl();
		Session s = sf.getCurrentSession();
		
//		System.out.println(ud.getAllUsers());
	}
}