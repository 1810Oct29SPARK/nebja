package nebja.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import nebja.beans.User;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;
import nebja.service.LoginService;
import nebja.service.MovieUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	private MovieUserService movieUserService;
	UserDAO ud = new UserDAOImpl();

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
		public ResponseEntity<User> createUser(@RequestBody String user) throws JsonParseException, JsonMappingException, IOException{
			JSONObject js = new JSONObject(user);
			String username = js.getString("Username");
			String password = js.getString("Password");
			String Profile = js.getString("Profile");
			User thing = null;
			movieUserService.createUser(thing = new User(username,password,Profile));
			
			return new ResponseEntity<>(thing,HttpStatus.OK);
		
		}

}

