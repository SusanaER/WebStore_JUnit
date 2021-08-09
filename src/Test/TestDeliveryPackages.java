package Test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.ArticlesPurchase;
import clases.DeliveryCompany;
import clases.DeliveryPackeges;
import operaciones.Factory;
import operaciones.ManageDeliveryPackeges;
import operaciones.ManagePurchaseOrders;

public class TestDeliveryPackages {
	ManageDeliveryPackeges MDP = new ManageDeliveryPackeges();
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	Integer delpackList;
	Session session = factory.openSession();

	@Test
	public void testDeliveryPackages() {
		DeliveryCompany deliveryCompany = new DeliveryCompany(2);
		Integer delPackage = MDP.addDeliberyPackages(factory, deliveryCompany, 119955);
		List deliveryPackages = session.createQuery("FROM DeliveryPackeges c WHERE c.deliveryPackegesId = " + delPackage).list(); 
        for (Iterator iterator = deliveryPackages.iterator(); iterator.hasNext();){
        	DeliveryPackeges b = (DeliveryPackeges) iterator.next();
        	delpackList = b.getDeliveryPackegesId();
        }
        assertEquals(delPackage, delpackList);
	}
}
