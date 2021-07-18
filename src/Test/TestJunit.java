package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import operaciones.Principal;
import clases.Articles;
import clases.City;
import clases.Clients;
import clases.Country;
import clases.CreditCards;
import clases.DeliveryAddress;
import clases.DeliveryCompany;
import clases.DeliveryPackeges;
import clases.PurchaseOrders;
import clases.State;
import clases.TypeCc;
import operaciones.ManageClients;
import operaciones.ManageCreditCard;
import operaciones.ManageDeliveryAddress;
import operaciones.ManageDeliveryPackeges;
import operaciones.ManagePurchaseOrders;
import operaciones.Factory;
import operaciones.ManageArticlePurchase;
import operaciones.ManageBilling;
import operaciones.ManageClientCreditCard;
import operaciones.ManageClientDelAdd;

class TestJunit {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManageClients MC = new ManageClients();
	ManageCreditCard MCC = new ManageCreditCard();
	TypeCc TCC = new TypeCc(2);
	ManageClientCreditCard CCC = new ManageClientCreditCard();
	ManageDeliveryAddress DA = new ManageDeliveryAddress();
	City city = new City(5);
	Country country = new Country(1);
	State state = new State(3);
	ManageClientDelAdd CDA = new ManageClientDelAdd();
	ManageDeliveryPackeges MDP = new ManageDeliveryPackeges();
	ManagePurchaseOrders MPO = new ManagePurchaseOrders();
	ManageArticlePurchase MAP = new ManageArticlePurchase();
	Articles article = new Articles(1);
	ManageBilling MB = new ManageBilling();
	Integer client, creditcard, deladd, relationshipCDA, delPackage, purchaseOrder, articlePurchase, billing, relationshipCC;
	

	@Test
	void testManageClients() {
		client = MC.addClient(factory, "Marco", "Regil", "MarcoR", "contraMarco", "marcoregil@gmail.com");
		creditcard = MCC.addCreditCard(factory, 12312312, "Marco Regil", TCC);
		assertEquals(client, 11);
	}
	
	@Test
	void testManageCreditCards() {
		creditcard = MCC.addCreditCard(factory, 12312312, "Marco Regil", TCC);
		assertNotEquals(creditcard, 1);
	}
	
	@Test
	void testManageClientCreditCard() {
		Clients nclient = new Clients(client);
		CreditCards ncreditcard = new CreditCards(creditcard);
		assertNull(CCC.addClientCreditCard(factory, nclient, ncreditcard));
	}
	
	@Test
	void testManageDeliveryAddress() {
		deladd = DA.addDeliberyAddress(factory, city, country, state, "Terreno blanco", 178);
		assertTrue(deladd!=1);
	}
	
	@Test
	void testManageClientDelAdd() {
		Clients nclient = new Clients(client);
		DeliveryAddress deliveryAddress = new DeliveryAddress(deladd);
		relationshipCDA = CDA.addClientCreditCard(factory, nclient, deliveryAddress);
		assertNull(relationshipCDA);
	}

	@Test
	void testManageDeliveryPackeges() {
		DeliveryCompany deliveryCompany = new DeliveryCompany(2);
		delPackage = MDP.addDeliberyPackages(factory, deliveryCompany, 119955);
		assertFalse(delPackage==20);
	}
	
	@Test
	void testManagePurchaseOrders() {
		Clients nclient = new Clients(client);
		DeliveryPackeges DP = new DeliveryPackeges(delPackage);
		purchaseOrder = MPO.addPurchaseOrder(factory, nclient, DP);
		assertNull(purchaseOrder);
	}
	
	@Test
	void testManageArticlePurchase() {
		PurchaseOrders PO = new PurchaseOrders(purchaseOrder);
		articlePurchase = MAP.addArticlePurchase(factory, article, PO);
		assertNotSame(articlePurchase,40);
	}
	
	@Test
	void testManageBilling() {
		PurchaseOrders purchaseOrders = new PurchaseOrders(purchaseOrder);
		billing = MB.addBilling(factory, purchaseOrders, 36.8);
		assertNotSame(billing, 21);
	}
}
