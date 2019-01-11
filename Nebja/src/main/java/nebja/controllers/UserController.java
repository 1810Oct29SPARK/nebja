package nebja.controllers;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nebja.beans.User;
import nebja.service.MovieUserService;

@Controller
@RequestMapping(value="/profile")
public class UserController {
	@Autowired
	private MovieUserService movieUserService;
	
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
	
}

