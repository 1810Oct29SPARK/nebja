package nebja.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import nebja.beans.User;
import nebja.util.NebjaUtil;

public class UserDAOImpl implements UserDAO {
static SessionFactory sf = NebjaUtil.getSessionFactory();

private DataSource datasource;
private JdbcTemplate jdbcTemplate;

/**
 * Gets all users from the database.
 */
	@Override
	public List<User> getAllUsers() {
	List<User> users = new ArrayList<>();	
	
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from User").getResultList();
			tx.commit();
			s.close();
		}
		return users;
		
	}
/**
 * Creates a user by inserting a user object into the database.
 */
	@Override
	public void createUser(User user) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(user);
			tx.commit();
			s.close();
		}
		
	}
/**
 * Updates the username field using passed in username at passed in id.
 */
	@Override
	public void updateUsername(String username1,int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			User u = (User) s.get(User.class, id);
			u.setUsername(username1);
			s.update(u);
			tx.commit();
			s.close();
		}
	}
/**
 * Updates the password field, with a new password at passed in id
 */
	@Override
	public void updatePassword(String password,int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			User u = (User) s.get(User.class, id);
			u.setPassword(password);
			s.update(u);
			tx.commit();
			s.close();
		}
	}
/**
 * Updates profileinformation, using passed in profile information string, at passed in id location.
 */
	@Override
	public void updateprofileInfo(String profileInfo,int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			User u = (User) s.get(User.class, id);
			u.setProfileinfo(profileInfo);
			s.update(u);
			tx.commit();
			s.close();
		}
	}
/**
 * Updates profile photo in database, by passing in a file converting to a byte stream
 * uploading that byte stream to database to be stored as a blob.
 */
	@Override
	public void updateProfilePhoto(File photo, int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			User u = (User) s.get(User.class, id);
			byte[] imageInBytes = new byte[(int)photo.length()]; //image convert in byte form
			FileInputStream inputStream = new FileInputStream(photo);  //input stream object create to read the file
			inputStream.read(imageInBytes); // here inputstream object read the file
			inputStream.close();
			u.setPicture(imageInBytes);
			tx.commit();
			s.close();
		}
		 catch (IOException e) {
		
			e.printStackTrace();
		}

	}
/**
 * Grabs the photo from the id location, converts the returned blob which was a byte stream
 * to a file and stores the file, then returns the file.
 */
	@Override
	public byte[] getPhoto(int id) {
		File image = null;
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			User u = (User) s.get(User.class, id);
		 // we can put any name of file (just name of new file created).
		byte[] getImageInBytes = u.getPicture();
		if (u.getPicture()==null) {
			getImageInBytes = null;
			return null;
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(getImageInBytes);
		BufferedImage bi = ImageIO.read(bis);
		ImageIO.write(bi,"jpg", new File("output.jpg"));
		/*FileOutputStream outputStream = new FileOutputStream(); // it will create new file (same location of class)
		outputStream.write(getImageInBytes); // image write in "myImage.jpg" file
		outputStream.close(); // close the output stream
		s.close();*/
		
		return getImageInBytes;
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return null;
		
	}
}

