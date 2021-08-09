package Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.City;
import clases.ClientCreditCard;
import clases.ClientDelAdd;
import clases.Clients;
import clases.Country;
import clases.DeliveryAddress;
import clases.State;
import operaciones.Factory;
import operaciones.ManageClientDelAdd;
import operaciones.ManageDeliveryAddress;

public class TestManageDeliveryAddress {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	City city = new City(5);
	Country country = new Country(1);
	State state = new State(3);
	ManageDeliveryAddress DA = new ManageDeliveryAddress();
	ManageClientDelAdd CDA = new ManageClientDelAdd();
	Clients nclient = new Clients(5);
	Integer clientList, deladdList, clientID, deladdID;
	
	@Test
	public void testManageDeliveryAddress() {
		Session session = factory.openSession();
		Integer deladd = DA.addDeliberyAddress(factory, city, country, state, "Terreno blanco", 178);
		DeliveryAddress deliveryAddress = new DeliveryAddress(deladd);
		deladdID = deliveryAddress.getDelAddId();
		Integer relationshipCDA = CDA.addClientCreditCard(factory, nclient, deliveryAddress);
		clientID = nclient.getClientId();
		List relationshipDAList = session.createQuery("FROM ClientDelAdd c WHERE c.clientDelAddId = " + relationshipCDA).list();
		for (Iterator iterator = relationshipDAList.iterator(); iterator.hasNext();){
			ClientDelAdd b = (ClientDelAdd) iterator.next(); 
        	clientList = b.getClients().getClientId();
            deladdList = b.getDeliveryAddress().getDelAddId();
        }
		
		assertAll(
	            () -> assertEquals(clientID, clientList),
	            () -> assertEquals(deladdID, deladdList)
	        );
	}
}
