package Test;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.PurchaseOrders;
import operaciones.Factory;
import operaciones.ManageBilling;

public class TestManageBilling {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManageBilling MB = new ManageBilling();

	@Test
	public void testManageBilling() {
		PurchaseOrders purchaseOrders = new PurchaseOrders(11);
		Integer billing = MB.addBilling(factory, purchaseOrders, 36.8);
		
		assertNotNull(billing);
	}
}
