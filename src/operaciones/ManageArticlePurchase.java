package operaciones;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import clases.Articles;
import clases.ArticlesPurchase;
import clases.PurchaseOrders;

public class ManageArticlePurchase {
	/* Method to create an relationship between  Article and Purchase Order*/
	public Integer addArticlePurchase(SessionFactory factory, Articles articles, PurchaseOrders purchaseOrders) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer articlesPurchaseId = null;
		
		try {
			tx = session.beginTransaction();
			ArticlesPurchase AP = new ArticlesPurchase(articles, purchaseOrders);
			articlesPurchaseId = (Integer) session.save(AP);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return articlesPurchaseId;
	}
}
