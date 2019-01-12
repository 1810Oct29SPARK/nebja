package nebja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import nebja.beans.User;
import nebja.service.LoginService;

@Controller
@RequestMapping(value="/logincontroller")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	
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
			return new RedirectView("profile");
			
		}
	}
		@GetMapping(value="/error")
		public String getErrorPage() {
			return "error";
	}

	

}
