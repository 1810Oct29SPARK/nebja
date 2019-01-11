package nebja.beans;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="MOVIE")
public class Movie {
public Movie(int movieid, File moviephoto, String title, double avgscore) {
		super();
		this.movieid = movieid;
		this.moviephoto = moviephoto;
		this.title = title;
		this.avgscore = avgscore;
	}

public Movie(int movieid, String title, double avgscore) {
	super();
	this.movieid = movieid;
	this.title = title;
	this.avgscore = avgscore;
}
@Id
@GeneratedValue(strategy= GenerationType.AUTO,generator="movieSequence")
@SequenceGenerator(allocationSize=1, name="movieSequence", sequenceName= "SQ_MOVIE_PK")
@Column(name="MOVIE_ID")
private int movieid;
@Column(name="MOVIE_PHOTO")
private File moviephoto;
@Column(name="TITLE")
private String title;
@Column(name="AVG_SCORE")
private double avgscore;
public int getMovieid() {
	return movieid;
}
public void setMovieid(int movieid) {
	this.movieid = movieid;
}
public File getMoviephoto() {
	return moviephoto;
}
public void setMoviephoto(File moviephoto) {
	this.moviephoto = moviephoto;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getAvgscore() {
	return avgscore;
}
public void setAvgscore(double avgscore) {
	this.avgscore = avgscore;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(avgscore);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + movieid;
	result = prime * result + ((moviephoto == null) ? 0 : moviephoto.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	Movie other = (Movie) obj;
	if (Double.doubleToLongBits(avgscore) != Double.doubleToLongBits(other.avgscore))
		return false;
	if (movieid != other.movieid)
		return false;
	if (moviephoto == null) {
		if (other.moviephoto != null)
			return false;
	} else if (!moviephoto.equals(other.moviephoto))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
@Override
public String toString() {
	return "Movie [movieid=" + movieid + ", title=" + title + ", avgscore=" + avgscore + "]";
}
}
