package nebja.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.websocket.Decoder.Binary;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import nebja.beans.Movie;
import nebja.beans.Review;
import nebja.beans.User;
import nebja.beans.Watchlist;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.service.LoginService;
import nebja.service.MovieService;
import nebja.service.MovieUserService;
import nebja.service.ReviewService;
import nebja.service.WatchService;
@CrossOrigin
@Controller
@RequestMapping(value="/user")
public class UserController {
	int theid;
	
	@Autowired
	LoginService loginService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	private MovieUserService movieUserService;
	UserDAO ud = new UserDAOImpl();
	@Autowired
	private MovieService movieService;
	@Autowired
	private WatchService watchListService;

	/*@RequestMapping(value="/login0")
	public String getLogin() {
		return "forward:/static/staticLogin.html";
	}*/
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/log", method=RequestMethod.POST, consumes=  MediaType.ALL_VALUE)
	public ResponseEntity<User> handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes, HttpSession s) {
		User u = loginService.isValidUser(new User(formParams.getFirst("username"), formParams.getFirst("password")));
		String username = formParams.getFirst("username");
		if (u==null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		
		}
		else {
			 User use = ud.getUserByUsername(username);
			
			attributes.addFlashAttribute("username",use);
			
			//
			
			return new ResponseEntity<>(use,HttpStatus.OK);
			
		}
	}
		@GetMapping(value="/error")
		public String getErrorPage() {
			return "forward:/static/error.html";
	}
		
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping(value="/login")
		public ResponseEntity<User> handleFormRequest(@RequestBody User user, HttpSession s){
			User u = loginService.isValidUser(user);
			
			if(u == null) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				s.setAttribute("Username",u.getUsername());
				s.setAttribute("Password",u.getPassword());
				s.setAttribute("id", u.getUserid());
				s.setAttribute("Role",u.getUserRole());
				System.out.println(s.getAttribute("Username"));
				return new ResponseEntity<>(u, HttpStatus.OK);
			}
		}
		
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/newuser", method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<User> createUser(@RequestBody String user, HttpSession s) throws JsonParseException, JsonMappingException, IOException{
			JSONObject js = new JSONObject(user);
			String username = js.getString("Username");
			String password = js.getString("Password");
			String Profile = js.getString("Profile");
			User thing = null;
			
			movieUserService.createUser(thing = new User(username,password,Profile));
		
			return new ResponseEntity<>(thing,HttpStatus.OK);
		
		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/newmovie", method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<?> addMovie(@RequestBody String movie, HttpSession s) {
			JSONObject js = new JSONObject(movie);
			
			int movid = js.getInt("movieId");
			theid =movid;
			String title = js.getString("title");
			Movie mov = new Movie(movid,title);
			movieService.addMovie(mov);
			s.setAttribute("Movieid",movid);
			return new ResponseEntity<>(mov,HttpStatus.OK);
		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/review", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<?> getReview(@RequestBody String rev, HttpSession s) {
			System.out.println(rev);
			JSONObject js = new JSONObject(rev);
			int score = js.getInt("score");
			String revi =js.getString("review");
			int theid = js.getInt("movieId");
			int usersid = js.getInt("userId");
			Review review = new Review(revi,score,theid,usersid);
			reviewService.createUserReview(review);
			return new ResponseEntity<>(review,HttpStatus.OK);
		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/userreview", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<?> getReviewByUserID(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int id = js.getInt("userId");
			System.out.println(id);
			
			return new ResponseEntity<>(reviewService.getUserReviews(id),HttpStatus.OK);


}
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/moviereview", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<?> getReviewByMovie(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int id = js.getInt("movieId");
			System.out.println(id);
			return new ResponseEntity<>(reviewService.getUserReviewsbyMovieid(id),HttpStatus.OK);
			

		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/watchlist", method = RequestMethod.GET, consumes= "application/json")
		public ResponseEntity<?> getMovieWatchlist(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int userid = js.getInt("userId");
			return new ResponseEntity<>(watchListService.getWatchList(userid),HttpStatus.OK);
		}
		
		@RequestMapping(value = "/addToWatchlist", method = RequestMethod.POST, consumes ="application/json")
		@ResponseBody 
		public ResponseEntity<Movie> addToWatchlist(@RequestBody String movieJson) throws JsonParseException, JsonMappingException, IOException{
			 JSONObject js = new JSONObject(movieJson);
			 return new ResponseEntity<>(HttpStatus.OK);

		}
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/deleteuser", method = RequestMethod.PUT, consumes= "application/json")
		public ResponseEntity<?> deleteUserById(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int id = js.getInt("Id");
			movieUserService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		
		
}
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/updateuser", method = RequestMethod.PUT, consumes= "application/json")
		public ResponseEntity<?> updateUserRole(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int id = js.getInt("Id");
			String role = "MODERATOR";
			movieUserService.updateUserRole(role,id);
			return new ResponseEntity<>(HttpStatus.OK);
}
		@CrossOrigin
		@RequestMapping (value = "/updateuserphoto", method = RequestMethod.POST)
		public String uploadFileHandler(@RequestBody MultipartFile rev, HttpSession s) {
			System.out.println(rev);
		
			return null;
}
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/addwatchlist", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<?> addWatchList(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int userid = js.getInt("userId");
			int movieid = js.getInt("movieId");
			Watchlist wl = watchListService.addWatchList(new Watchlist(movieid,userid));
			return new ResponseEntity<>(wl,HttpStatus.OK);
		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/deletewatchlist", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<?> deleteWatchList(@RequestBody String rev, HttpSession s) {
			JSONObject js = new JSONObject(rev);
			int watchlistid = js.getInt("watchlistId");
			watchListService.deleteWatchlist(watchlistid);
			return new ResponseEntity<>(HttpStatus.OK);
}
}
