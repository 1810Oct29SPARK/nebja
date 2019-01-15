package nebja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.Credentials;
import nebja.beans.User;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;

@Service
public class AuthService {

	private MovieUserService movieUserService;
	
	
	public User isValidUser(Credentials credentials) {
		User u = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		u = authenticateUser(credentials);
		return u;
	}
	
	public User authenticateUser(Credentials creds) {
		
		UserDAO ud = new UserDAOImpl();
		List<User> list = null;
		User u = null;
		
		try {
			list = ud.getAllUsers();
			for(User u2 : list) {
				if(u2.getUsername().equals(creds.getUsername()) && u2.getPassword().equals(creds.getPassword())) {
					u = u2;
					return u;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Creds");
			
		}
		return null;
	}
}
