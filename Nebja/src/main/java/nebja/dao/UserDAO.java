package nebja.dao;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nebja.beans.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public void createUser(User user);
	public void updateUsername(String username1,int id);
	public void updatePassword(String password,int id);
	public void updateprofileInfo(String profileInfo, int id);
	public void updateProfilePhoto(File photo, int id);
	public byte[] getPhoto(int id);
	public User getUserByUsername(String username);
	public void updateUserRole(String userrole, int id);
	public void deleteUser(int id);
}
