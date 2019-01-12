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
@Table(name="COMMENTS")
public class Comment {
public Comment( String usercomment) {
		super();
		
		this.usercomment = usercomment;
	}

public Comment() {

	}

@Id
@GeneratedValue(strategy= GenerationType.AUTO,generator="commentSequence")
@SequenceGenerator(allocationSize=1, name="commentSequence", sequenceName= "SQ_COMMENT_PK")
@Column(name="COMMENT_ID")
private int commentid;
@Column(name="USER_COMMENT")
private String usercomment;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "MOVIE_ID", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private Movie movie;
public int getCommentid() {
	return commentid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public String getUsercomment() {
	return usercomment;
}
public void setUsercomment(String usercomment) {
	this.usercomment = usercomment;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + commentid;
	result = prime * result + ((usercomment == null) ? 0 : usercomment.hashCode());
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
	Comment other = (Comment) obj;
	if (commentid != other.commentid)
		return false;
	if (usercomment == null) {
		if (other.usercomment != null)
			return false;
	} else if (!usercomment.equals(other.usercomment))
		return false;
	return true;
}
@Override
public String toString() {
	return "Comment [commentid=" + commentid + ", usercomment=" + usercomment + "]";
}
}
