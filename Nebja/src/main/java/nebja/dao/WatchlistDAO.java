package nebja.dao;

import java.util.List;

import nebja.beans.Watchlist;

public interface WatchlistDAO {
public Watchlist addWatchList(Watchlist watchlist);
public List getWatchlist(int id);
}
