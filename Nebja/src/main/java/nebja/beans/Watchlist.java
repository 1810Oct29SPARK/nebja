package nebja.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Watchlist")
@Table(name="WATCH_LIST")
public class Watchlist {

	public Watchlist() {
		
	}
	
	
public Watchlist( int movieids, int usersid) {
		super();
	
		this.movieids = movieids;
		this.usersid = usersid;
	}

@Override
	public String toString() {
		return "Watchlist [watchid=" + watchid + ", movieids=" + movieids + ", usersid=" + usersid + "]";
	}

public int getWatchid() {
		return watchid;
	}

	public void setWatchid(int watchid) {
		this.watchid = watchid;
	}

	public int getMovieids() {
		return movieids;
	}

	public void setMovieids(int movieids) {
		this.movieids = movieids;
	}

	public int getUsersid() {
		return usersid;
	}

	public void setUsersid(int usersid) {
		this.usersid = usersid;
	}
@GeneratedValue(strategy= GenerationType.AUTO,generator="watchlistSequence")
@SequenceGenerator(allocationSize=1, name="watchlistSequence", sequenceName= "SQ_WATCH_LIST_PK")
@Id
@Column(name="WATCH_ID")
private int watchid;
@Column(name="MOVIE_IDS")
private int movieids;
@Column(name="USERS_ID")
private int usersid;
}
