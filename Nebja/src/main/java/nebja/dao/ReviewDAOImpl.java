package nebja.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nebja.beans.Review;
import nebja.util.NebjaUtil;

public class ReviewDAOImpl implements ReviewDAO {
static SessionFactory sf = NebjaUtil.getSessionFactory();
/**
 * Gets all the reviews from review table in database.
 */
@Override
	public List<Review> getAllReviews() {
			List<Review> reviews = new ArrayList<>();	
			try(Session s = sf.getCurrentSession()){
					Transaction tx = s.beginTransaction();
					reviews = s.createQuery("from Review").getResultList();
					tx.commit();
					s.close();
	
			}
			return reviews;
	}
/**
 * Gets all the user reviews based on passed in id.
 */
	@Override
	public String getUserReview(int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Review r = (Review) s.get(Review.class, id);
			String treview=r.getMoviereview();
			
			tx.commit();
			s.close();
			return treview;
	}
		
	}

	/**
	 * Creates a user review passing in a review object.
	 */
	
	@Override
	public void createUserReview(Review review) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(review);
			tx.commit();
			s.close();
		}
	}
	public Review getUserReviews(int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Review r = (Review) s.get(Review.class, id);
			Query query = s.createQuery("from Review where movieid = :id").setParameter("id", id);
			List list = query.list();
			Review review = (Review) query.iterate();
			return review;
	}

}
}
