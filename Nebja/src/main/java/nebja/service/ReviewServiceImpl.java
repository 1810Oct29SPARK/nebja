package nebja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.Review;
import nebja.dao.ReviewDAO;
import nebja.dao.ReviewDAOImpl;

@Service(value="reviewService")
public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO rd = new ReviewDAOImpl();
	
	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return rd.getAllReviews();
	}

	@Override
	public String getUserReview(int id) {
		// TODO Auto-generated method stub
		return rd.getUserReview(id);
	}

	@Override
	public void createUserReview(Review review) {
	rd.createUserReview(review);
		
	}

	@Override
	public List getUserReviews(int id) {
		// TODO Auto-generated method stub
		return rd.getUserReviews(id);
	}

	@Override
	public void deleteReview(int id) {
		// TODO Auto-generated method stub
		rd.deleteReview(id);
	}

	@Override
	public List getUserReviewsbyMovieid(int id) {
		// TODO Auto-generated method stub
		return rd.getUserReviewsbyMovieid(id);
	}

}
