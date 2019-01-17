package nebja.service;

import java.io.File;
import java.util.List;

import org.hibernate.Query;

import nebja.beans.User;


public interface MovieUserService {
		public List<User> getAllUsers();
		public void createUser(User user);
		public void updateUsername(String username1,Integer id);
		public void updatePassword(String password,int id);
		public void updateprofileInfo(String profileInfo, int id);
		public void updateProfilePhoto(File photo, int id);
		public byte[] getPhoto(int id);
		public User getUserByUsername(String username);
		public void deleteUser(int id);
		public void updateUserRole(String userrole, int id);
}
