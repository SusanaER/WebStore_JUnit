package Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.Articles;
import clases.ArticlesPurchase;
import clases.ClientCreditCard;
import clases.Clients;
import clases.DeliveryPackeges;
import clases.PurchaseOrders;
import operaciones.Factory;
import operaciones.ManageArticlePurchase;
import operaciones.ManagePurchaseOrders;

public class TestPurchaseOrder {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManagePurchaseOrders MPO = new ManagePurchaseOrders();
	ManageArticlePurchase MAP = new ManageArticlePurchase();
	Clients nclient = new Clients(11);
	DeliveryPackeges DP = new DeliveryPackeges(11);
	Articles article = new Articles(11);
	Integer articlepurchase;
	Session session = factory.openSession();
	Integer articleList, articleID, purchaseorderList, puerchaseorderID;
	
	@Test
	public void testPurchaseOrder() {
		Integer purchaseOrder = MPO.addPurchaseOrder(factory, nclient, DP);
		PurchaseOrders PO = new PurchaseOrders(purchaseOrder);
		articlepurchase = MAP.addArticlePurchase(factory, article, PO);
		articleID = article.getArticlesId();
		puerchaseorderID = PO.getPurchaseOrderId();
		List relationshipCCList = session.createQuery("FROM ArticlesPurchase c WHERE c.articlesPurchaseId = " + articlepurchase).list(); 
        for (Iterator iterator = relationshipCCList.iterator(); iterator.hasNext();){
        	ArticlesPurchase b = (ArticlesPurchase) iterator.next(); 
            articleList = b.getArticles().getArticlesId();
            purchaseorderList = b.getPurchaseOrders().getPurchaseOrderId();
        }
        
        assertAll(
	            () -> assertEquals(articleID, articleList),
	            () -> assertEquals(puerchaseorderID, purchaseorderList)
	        );
	}
}
