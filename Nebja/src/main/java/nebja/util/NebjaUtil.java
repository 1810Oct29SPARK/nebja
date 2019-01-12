package nebja.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NebjaUtil {

	private static SessionFactory sf;
	public static SessionFactory getSessionFactory() {
		
	
	if (NebjaUtil.sf == null) {
		Configuration c = new Configuration();
		c.setProperty("hibernate.connection.username", System.getenv("demoName"));
		c.setProperty("hibernate.connection.password", System.getenv("demoPass"));
		c.setProperty("hibernate.connection.url", System.getenv("demoUrl"));
		c.configure();
		NebjaUtil.sf = c.buildSessionFactory();
	}
	return sf;
	}
}
