package operaciones;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.Clients;
import clases.DeliveryPackeges;
import clases.PurchaseOrders;

public class ManagePurchaseOrders {
	/* Method to create an manage order in the database */
	public Integer addPurchaseOrder(SessionFactory factory, Clients clients, DeliveryPackeges deliveryPackeges) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer purchaseOrderId = null;
		Date date = new Date();
		
		try {
			tx = session.beginTransaction();
			PurchaseOrders PO = new PurchaseOrders(clients, deliveryPackeges, date);
			purchaseOrderId = (Integer) session.save(PO);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return purchaseOrderId;
	}
	
	/* Method to  READ data the manage order */
	public void listPurchaseOrder(SessionFactory factory, Integer nid) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the purchase orders ---");
	         List order = session.createQuery("FROM PurchaseOrders c WHERE c.purchaseOrderId = " + nid).list(); 
	         for (Iterator iterator = order.iterator(); iterator.hasNext();){
	        	 PurchaseOrders pOrders = (PurchaseOrders) iterator.next();
	            System.out.print("Clients: " + pOrders.getClients().getName()); 
	            System.out.println("  Date: " + pOrders.getDate());
	            System.out.println("  Delivery Packeges: " + pOrders.getDeliveryPackeges().getPackegeNumber());
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
