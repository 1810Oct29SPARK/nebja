package nebja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nebja.beans.Watchlist;
import nebja.util.NebjaUtil;

public class WatchlistImpl implements WatchlistDAO {
	static SessionFactory sf = NebjaUtil.getSessionFactory();
	
	
	@Override
	public Watchlist addWatchList(Watchlist watchlist) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(watchlist);
			tx.commit();
			s.close();
			return watchlist;
	}

	

}


	@Override
	public List getWatchlist(int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Query q = s.createQuery("from Watchlist where usersid = :id").setParameter("id", id);
			List list = q.list();
			tx.commit();
			s.close();
			return list;
	}
}


	@Override
	public void deleteWatchlist(int id) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Watchlist w = s.get(Watchlist.class, id);
			s.delete(w);
			tx.commit();
			s.close();
	}
}
}