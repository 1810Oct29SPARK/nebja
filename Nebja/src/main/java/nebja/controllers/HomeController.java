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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import nebja.beans.User;
import nebja.service.LoginService;
import nebja.service.MovieUserService;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	Model m;
	@Autowired
	LoginService loginService;
	
	@Autowired
	private MovieUserService movieUserService;
	
	@GetMapping(value="/login")
	public String getStaticLoginPage() {
		return "forward:/static/staticLogin.html";
	}
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes) {
		User u = loginService.isValidUser(new User(formParams.getFirst("username"), formParams.getFirst("password")));
		if (u==null) {
			return new RedirectView("error");
		}
		else {
			attributes.addFlashAttribute("user",u);
			return new RedirectView("user");
			
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
		public String logOut(HttpServletRequest request) {
			HttpSession hs = request.getSession();
			hs.invalidate();
			return "redirect:logincontroller/login";
		}
}
