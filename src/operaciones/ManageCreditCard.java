package operaciones;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.CreditCards;
import clases.TypeCc;

public class ManageCreditCard {
	
	/* Method to create an credit_card in the database */
	public Integer addCreditCard(SessionFactory factory,Integer Number,String Cardholder,TypeCc Type_CC_ID) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer Credit_Card_ID = null;
		
		try {
			tx = session.beginTransaction();
			CreditCards creditcard = new CreditCards(Type_CC_ID, Number, Cardholder);
			Credit_Card_ID = (Integer) session.save(creditcard);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return Credit_Card_ID;
	}
	
	/* Method to  READ data the credit_card */
	public void listCreditCards(SessionFactory factory, Integer nCreditCard) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the credit card created ---");
	         List creditcard = session.createQuery("FROM CreditCards c WHERE c.creditCardId = " + nCreditCard).list(); 
	         for (Iterator iterator = creditcard.iterator(); iterator.hasNext();){
	        	CreditCards creditcards = (CreditCards) iterator.next();
	            System.out.print("Number: " + creditcards.getNumber()); 
	            System.out.println("  Cardholder: " + creditcards.getCardholder());
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
