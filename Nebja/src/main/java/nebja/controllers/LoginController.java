package nebja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import nebja.beans.Credentials;
import nebja.beans.User;
import nebja.service.AuthService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
//	Model m;
//	@Autowired
//	LoginService loginService;
	
	
//	@GetMapping(value="/login")
//	public String getStaticLoginPage() {
//		return "forward:/static/staticLogin.html";
//	}
//	
//	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes) {
//		User u = loginService.isValidUser(new User(formParams.getFirst("username"), formParams.getFirst("password")));
//		if (u==null) {
//			return new RedirectView("error");
//		}
//		else {
//			attributes.addFlashAttribute("user",u);
//			return new RedirectView("user");
//			
//		}
//	}
//		@GetMapping(value="/error")
//		public String getErrorPage() {
//			return "error";
//	}

	@Autowired
	public LoginController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	private AuthService authService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/sent")
	public ResponseEntity<User> handleFormRequest(@RequestBody Credentials creds){
		User u = authService.authenticateUser(creds);
		
		if(u == null) {
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
}
