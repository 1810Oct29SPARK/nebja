package nebja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.User;
@Service(value="loginService")
public class LoginService {
	public User isValidUser(User user) {
		
		User u = new User();
		u = null;
		MovieUserService mus = new MovieUserServiceImpl();
		String username = user.getUsername();
		String password = user.getPassword();
		if (username != null && password != null) {
			List<User> userlist = mus.getAllUsers();
			for (User us: userlist) {
				if(username.equals(us.getUsername()) && password.equals(us.getPassword())) {
					u=us;
					System.out.println(u);
				}
			}
		}
		return u;
	}
	
}
