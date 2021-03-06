package nebja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import nebja.beans.User;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.service.LoginService;
import nebja.service.MovieUserService;
@CrossOrigin(origins= "http://localhost:4200")
@Controller
@RequestMapping(value="/home")
public class HomeController {
	Model m;
	@Autowired
	LoginService loginService;
	
	@Autowired
	private MovieUserService movieUserService;
	UserDAO ud = new UserDAOImpl();
	
	@RequestMapping(value="/login")
	public String getLogin() {
		return "forward:/static/staticLogin.html";
	}
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<User> handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes, HttpSession s) {
		User u = loginService.isValidUser(new User(formParams.getFirst("username"), formParams.getFirst("password")));
		String username = formParams.getFirst("username");
		if (u==null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		
		}
		else {
			 User use = ud.getUserByUsername(username);
			
			attributes.addFlashAttribute("username",use);
			/*s.setAttribute("Username",u.getUsername());
			s.setAttribute("Password",u.getPassword());
			s.setAttribute("id", u.getUserid());
			s.setAttribute("Role",u.getUserRole());*/
			//System.out.println(s.getAttribute("Username"));
			
			return new ResponseEntity<>(use,HttpStatus.OK);
			
		}
	}
		@GetMapping(value="/error")
		public String getErrorPage() {
			return "forward:/static/error.html";
	}

	
		
		@RequestMapping(value ="/all", method=RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<User>> getAllUsers() {
			return new ResponseEntity<>(movieUserService.getAllUsers(),HttpStatus.OK);
		}
		
		@GetMapping(value="{id}",produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public ResponseEntity<byte[]> getUserPhoto(@PathVariable int id){
			byte[] b = movieUserService.getPhoto(id);
			
			if (b==null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity<>(b, HttpStatus.OK);
			}
			
		}
		
		@GetMapping(value="/logout")
		public String logOut(HttpServletRequest request, SessionAttributes attributes) {
			HttpSession hs = request.getSession(false);
			hs.invalidate();
			
			return "redirect:home/login";
		}
		
		@GetMapping(value="/registration")
		public String getRegistrationPage() {
		return "forward:/static/registration.html";
		}
		
		@GetMapping(value="/profile")
		public String getProfile() {
			return "forward:/static/profile.html";

		}

		@RequestMapping (value ="/home/user/{Username}",method = RequestMethod.PUT)
		public ResponseEntity<?> updateUsername(@PathVariable("Username") String username, @RequestBody User user){
			User theuser = movieUserService.getUserByUsername(username);
			theuser.setUsername(username);
			movieUserService.updateUsername(username, 61);
			return new ResponseEntity<User>(theuser,HttpStatus.OK);
		}
		
		@CrossOrigin(value="http://localhost:4200")
		@RequestMapping (value = "/newuser", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<User> createUser(@RequestBody MultiValueMap<String, String> formParams){
			User u = movieUserService.getUserByUsername(formParams.getFirst("Username"));
			if (u==null) {
			
			movieUserService.createUser(new User(formParams.getFirst("Username"), formParams.getFirst("Password"), formParams.getFirst("Profile")));
			u=movieUserService.getUserByUsername(formParams.getFirst("Username"));
			return new ResponseEntity<>(u,HttpStatus.OK);
			}
			return new ResponseEntity<>(u,HttpStatus.I_AM_A_TEAPOT);
		}
		
		}
