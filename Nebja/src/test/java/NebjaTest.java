import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nebja.beans.Comment;
import nebja.beans.Movie;
import nebja.beans.Review;
import nebja.beans.User;
import nebja.dao.CommentDAO;
import nebja.dao.CommentDAOImpl;
import nebja.dao.MovieDAO;
import nebja.dao.MovieDAOImpl;
import nebja.dao.ReviewDAO;
import nebja.dao.ReviewDAOImpl;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;

@RunWith(MockitoJUnitRunner.class)
public class NebjaTest {
	@InjectMocks
UserDAOImpl userdaoi;
@InjectMocks
ReviewDAOImpl reviewdaoi;
@InjectMocks
MovieDAOImpl moviedaoi;
@InjectMocks
CommentDAOImpl commentdaoi;
@Mock
ReviewDAO reviewdao;
@Mock
UserDAO userdao;
@Mock
MovieDAO moviedao;
@Mock
CommentDAO commentdao;
@Mock
private SessionFactory hibernateSessionFactory;
@Mock
User us;
@Mock
Review rev;
@Mock
Movie mov;
@Mock
Comment com;



@Test
public void testTheUser() throws Exception{
	Session session = Mockito.mock(Session.class);
	List<User> use = new ArrayList<>();
	Exception e = new Exception();
	File f = Mockito.mock(File.class);
	String password = "purple";
	String profileInfo = "stuff";
	int id = 2;
	Mockito.lenient().when(hibernateSessionFactory.getCurrentSession()).thenReturn(session);
	Mockito.lenient().when(userdao.getAllUsers()).thenReturn(use);
	Mockito.lenient().when(userdao.getPhoto(2)).thenReturn(f);
	Mockito.lenient().doNothing().when(userdao).createUser(new User("Drunkjock23","alwayswasted","Life Is Pain"));
	Mockito.lenient().doNothing().when(userdao).updatePassword(password, id);
	Mockito.lenient().doNothing().when(userdao).updateprofileInfo(profileInfo, id);
	Mockito.lenient().doNothing().when(userdao).updateProfilePhoto(f, id);
	Mockito.lenient().doNothing().when(userdao).updateUsername(password, id);
}

@Test
public void testReviewGet() throws Exception{
	List<Review> reviews = new ArrayList<>();
	Mockito.lenient().when(reviewdao.getAllReviews()).thenReturn(reviews);

}

@Test
public void testGetUserReviewById() throws Exception{
	String string = new String();
	Mockito.lenient().when(reviewdao.getUserReview(2)).thenReturn(string);
}
@Test
public void testCreateReview() throws Exception{
	Mockito.lenient().doNothing().when(reviewdao).createUserReview(rev);
}

@Test
public void testGetMovies() {
	List<Movie> movies = new ArrayList<>();
	Mockito.lenient().when(moviedao.getAllMovies()).thenReturn(movies);
}

@Test
public void testGetMovieScore() {
	Blob b = Mockito.mock(Blob.class);
	Mockito.lenient().when(moviedao.getMoviePoster(2)).thenReturn(b);
}
@Test
public void testGetMovieTitle() {
	String string = new String();
	Mockito.lenient().when(moviedao.getMovieTitle(2)).thenReturn(string);
}

@Test
public void testGetAllComments() {
	List<Comment> comments = new ArrayList<>();
	Mockito.lenient().when(commentdao.getAllComments()).thenReturn(comments);
}

@Test
public void testMakeAComment() {
	Mockito.lenient().doNothing().when(commentdao).makeAComment(com);
}

}