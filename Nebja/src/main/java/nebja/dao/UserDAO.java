package nebja.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import nebja.beans.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public void createUser(User user);
	public void updateUsername(String username1,int id);
	public void updatePassword(String password,int id);
	public void updateprofileInfo(String profileInfo, int id);
	public void updateProfilePhoto(File photo, int id);
	public byte[] getPhoto(int id);

}
