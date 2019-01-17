package nebja.service;

import java.util.List;

import nebja.beans.Review;

public interface ReviewService {
	
		public List<Review> getAllReviews();
		public String getUserReview(int id);
		public void createUserReview(Review review);
		public List getUserReviews(int id);
		public void deleteReview(int id);
		public List getUserReviewsbyMovieid(int id);

}
