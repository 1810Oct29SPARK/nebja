package nebja.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.User;
import nebja.dao.UserDAO;
import nebja.dao.UserDAOImpl;

@Service(value="movieUserService")
public class MovieUserServiceImpl implements MovieUserService {

	UserDAO md = new UserDAOImpl();
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return md.getAllUsers();
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		md.createUser(user);
	}

	@Override
	public void updateUsername(String username1, int id) {
		// TODO Auto-generated method stub
		md.updateUsername(username1, id);
	}

	@Override
	public void updatePassword(String password, int id) {
		// TODO Auto-generated method stub
		md.updatePassword(password, id);
	}

	@Override
	public void updateprofileInfo(String profileInfo, int id) {
		// TODO Auto-generated method stub
		md.updateprofileInfo(profileInfo, id);
	}

	@Override
	public void updateProfilePhoto(File photo, int id) {
		// TODO Auto-generated method stub
		md.updateProfilePhoto(photo, id);
	}

	@Override
	public byte[] getPhoto(int id) {
		// TODO Auto-generated method stub
		return md.getPhoto(id);
	}

}
