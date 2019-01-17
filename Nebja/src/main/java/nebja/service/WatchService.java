package nebja.service;

import java.util.List;

import nebja.beans.Watchlist;

public interface WatchService {
	public Watchlist addWatchList(Watchlist watchlist);
	public List getWatchList(int id);
	public void deleteWatchlist(int id);
}
