package Test;

import static org.junit.Assert.assertNotNull;
import org.hibernate.SessionFactory;
import org.junit.Test;
import operaciones.Factory;
import operaciones.ManageClients;
import operaciones.ManageCreditCard;

public class TestManageClients {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManageClients MC = new ManageClients();
	ManageCreditCard MCC = new ManageCreditCard();
	
	@Test
	public void testManageClients() {
		Integer client = MC.addClient(factory, "Marco", "Regil", "MarcoR", "contraMarco", "marcoregil@gmail.com");
		assertNotNull(client);
	}
}
