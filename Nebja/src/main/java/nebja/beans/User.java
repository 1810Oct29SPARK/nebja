package nebja.beans;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="MOVIEUSER")
public class User {
public User(String username, String password, byte[] picture, String profileinfo, int userid) {
		super();
		this.username = username;
		this.password = password;
		this.picture = picture;
		this.profileinfo = profileinfo;
	}

public User(String username, String password,String profileinfo) {
	super();
	this.username = username;
	this.password = password;
	this.profileinfo = profileinfo;
}
public User() {
	
}
@Id
@GeneratedValue(strategy= GenerationType.AUTO,generator="userSequence")
@SequenceGenerator(allocationSize=1, name="userSequence", sequenceName= "SQ_USER_PK")
@Column(name="USER_ID")
private int userid;
@Column	(name="USERNAME")
private String username;
@Column (name="PASSWORD")
private String password;
@Column(name="PICTURE")
private byte[] picture;
@Column (name="PROFILE_INFO")
private String profileinfo;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "COMMENT_ID", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private Comment comment;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "REVIEW_ID", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private Review review;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public byte[] getPicture() {
	return picture;
}
public void setPicture(byte[] picture) {
	this.picture = picture;
}
public String getProfileinfo() {
	return profileinfo;
}
public void setProfileinfo(String profileinfo) {
	this.profileinfo = profileinfo;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((picture == null) ? 0 : picture.hashCode());
	result = prime * result + ((profileinfo == null) ? 0 : profileinfo.hashCode());
	result = prime * result + userid;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (picture == null) {
		if (other.picture != null)
			return false;
	} else if (!picture.equals(other.picture))
		return false;
	if (profileinfo == null) {
		if (other.profileinfo != null)
			return false;
	} else if (!profileinfo.equals(other.profileinfo))
		return false;
	if (userid != other.userid)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", picture=" + picture
			+ ", profileinfo=" + profileinfo + "]";
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

}
