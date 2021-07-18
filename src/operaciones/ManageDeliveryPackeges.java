package operaciones;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.DeliveryCompany;
import clases.DeliveryPackeges;

public class ManageDeliveryPackeges {
	/* Method to create an delivery packages in the database */
	public Integer addDeliberyPackages(SessionFactory factory, DeliveryCompany deliveryCompany, int packegeNumber) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer deliveryPackegesId = null;
		Date deliveryDate = new Date();
		
		try {
			tx = session.beginTransaction();
			DeliveryPackeges DP = new DeliveryPackeges( deliveryCompany, deliveryDate, packegeNumber);
			deliveryPackegesId = (Integer) session.save(DP);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return deliveryPackegesId;
	}

	/* Method to  READ data in delivery packages */
	public void listDelP(SessionFactory factory, Integer nid) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the delivery packages created ---");
	         List delp = session.createQuery("FROM DeliveryPackeges c WHERE c.deliveryPackegesId = " + nid).list(); 
	         for (Iterator iterator = delp.iterator(); iterator.hasNext();){
	        	 DeliveryPackeges  DP = (DeliveryPackeges) iterator.next(); 
	            System.out.print("Package Number: " + DP.getPackegeNumber()); 
	            System.out.print("  Delivery Company: " + DP.getDeliveryCompany().getName()); 
	            System.out.println("  Date: " + DP.getDeliveryDate());
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
