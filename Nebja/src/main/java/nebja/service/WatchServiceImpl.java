package nebja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nebja.beans.Watchlist;
import nebja.dao.WatchlistDAO;
import nebja.dao.WatchlistImpl;

@Service("watchListService")
public class WatchServiceImpl implements WatchService {
WatchlistDAO wd = new WatchlistImpl();
	
	@Override
	public Watchlist addWatchList(Watchlist watchlist) {
		// TODO Auto-generated method stub
		return wd.addWatchList(watchlist);
		
	}

	@Override
	public List getWatchList(int id) {
		
		return wd.getWatchlist(id);
	}

	@Override
	public void deleteWatchlist(int id) {
		// TODO Auto-generated method stub
		wd.deleteWatchlist(id);
	}

	
}
