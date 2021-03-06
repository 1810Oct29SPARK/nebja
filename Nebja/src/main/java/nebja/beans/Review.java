package nebja.beans;

import javax.persistence.CascadeType;
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
@Table(name ="REVIEW")
public class Review {
public Review(String moviereview, int reviewscore) {
		super();
		this.reviewscore = reviewscore;
		this.moviereview = moviereview;
	}

public Review(String moviereview) {
	this.moviereview = moviereview;
}

public Review(String moviereview,Integer reviewscore,Integer moviesid,Integer usersid) {
	super();
	this.reviewscore = reviewscore;
	this.moviereview = moviereview;
	this.moviesid = moviesid;
	this.usersid = usersid;
}

public Review() {
}

@Id
@GeneratedValue(strategy= GenerationType.AUTO,generator="reviewSequence")
@SequenceGenerator(allocationSize=1, name="reviewSequence", sequenceName= "SQ_REVIEW_PK")
@Column(name="REVIEW_ID")
private Integer reviewid;
@Column(name="MOVIE_REVIEW")
private String moviereview;
@Column(name="REVIEW_SCORE")
private Integer reviewscore;
@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "MOVIE_ID", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private Movie movieid;
@Column(name="MOVIE_IDS")
public Integer moviesid;
@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private User userid;
@Column(name="USERS_ID")
public Integer usersid;
public Integer getReviewid() {
	return reviewid;
}
public void setReviewid(Integer reviewid) {
	this.reviewid = reviewid;
}
public String getMoviereview() {
	return moviereview;
}
public void setMoviereview(String moviereview) {
	this.moviereview = moviereview;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((moviereview == null) ? 0 : moviereview.hashCode());
	result = prime * result + reviewid;
	result = prime * result + reviewscore;
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
	Review other = (Review) obj;
	if (moviereview == null) {
		if (other.moviereview != null)
			return false;
	} else if (!moviereview.equals(other.moviereview))
		return false;
	if (reviewid != other.reviewid)
		return false;
	if (reviewscore != other.reviewscore)
		return false;
	return true;
}
@Override
public String toString() {
	return "Review [reviewid=" + reviewid + ", moviereview=" + moviereview + ", reviewscore=" + reviewscore + "]";
}

public Integer getReviewscore() {
	return reviewscore;
}
public void setReviewscore(Integer reviewscore) {
	this.reviewscore = reviewscore;
};

}
