package operaciones;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
	private static SessionFactory factory;
	public static SessionFactory createFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e){
			System.err.print("Failed to create sessionFactory object. " + e);
			throw new ExceptionInInitializerError(e);
		}
		return factory;
	}
}
