package operaciones;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Clients;

import java.util.List;

public class ManageClients {
	
	/* Method to create an client in the database */
	public Integer addClient(SessionFactory factory, String Name,String Last_Name,String Username,String Password,String Email) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientID = null;
		
		try {
			tx = session.beginTransaction();
			Clients clients = new Clients(Name, Last_Name, Username, Password, Email);
			clientID = (Integer) session.save(clients);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return clientID;
	}

	/* Method to  READ data clients */
	public void listClients(SessionFactory factory, Integer nclient) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the client created ---");
	         List clients = session.createQuery("FROM Clients c WHERE c.clientId = " + nclient).list(); 
	         for (Iterator iterator = clients.iterator(); iterator.hasNext();){
	            Clients client = (Clients) iterator.next(); 
	            System.out.print("First Name: " + client.getName()); 
	            System.out.print("  Last Name: " + client.getLastName()); 
	            System.out.println("  Password: " + client.getPassword());
	            System.out.println("  Email: " + client.getPassword());
	            System.out.println("  Username: " + client.getPassword());
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
