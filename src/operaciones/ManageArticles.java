package operaciones;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.Articles;
import clases.Billing;
import clases.PurchaseOrders;

public class ManageArticles {
	/* Method to create an Billing in the database */
	public Integer addArticles(SessionFactory factory, String name,String description, double price) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer articleid = null;
		Date date = new Date();
		
		try {
			tx = session.beginTransaction();
			Articles B = new Articles(name, description, price);
			articleid = (Integer) session.save(B);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return articleid;
	}

	/* Method to  READ data the Billing */
	public void listArticles(SessionFactory factory, Integer id) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the Articles created ---");
	         List article = session.createQuery("FROM Articles c WHERE c.articlesId = " + id).list(); 
	         for (Iterator iterator = article.iterator(); iterator.hasNext();){
	            Articles b = (Articles) iterator.next(); 
	            System.out.print("Name: " + b.getName()); 
	            System.out.print("  Description: " + b.getDescription()); 
	            System.out.println("  Price: " + b.getPrice());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
}
