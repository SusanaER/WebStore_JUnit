package operaciones;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.ClientCreditCard;
import clases.Clients;
import clases.CreditCards;

public class ManageClientCreditCard {
	/* Method to create an relationship between  client and credit card*/
	public Integer addClientCreditCard(SessionFactory factory, Clients client, CreditCards creditcard) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientCreditCardId = null;
		
		try {
			tx = session.beginTransaction();
			ClientCreditCard CCC = new ClientCreditCard(client, creditcard);
			clientCreditCardId = (Integer) session.save(CCC);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return clientCreditCardId;
	}
}
