package operaciones;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.ClientDelAdd;
import clases.Clients;
import clases.DeliveryAddress;

public class ManageClientDelAdd {
	/* Method to create an relationship between  client and delivery address*/
	public Integer addClientCreditCard(SessionFactory factory, Clients clients, DeliveryAddress deliveryAddress) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientDelAddID = null;
		
		try {
			tx = session.beginTransaction();
			ClientDelAdd CDA = new ClientDelAdd(clients, deliveryAddress);
			clientDelAddID = (Integer) session.save(CDA);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return clientDelAddID;
	}
}
