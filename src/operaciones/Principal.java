package operaciones;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

public class Principal {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e){
			System.err.print("Failed to create sessionFactory object. " + e);
			throw new ExceptionInInitializerError(e);
		}
		
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
		
		/* Add data in database */
		Integer client = MC.addClient(factory, "Marco", "Regil", "MarcoR", "contraMarco", "marcoregil@gmail.com");
		Integer creditcard = MCC.addCreditCard(factory, 12312312, "Marco Regil", TCC);
		
		/* Create relationship between clients and credit cards */
		Clients nclient = new Clients(client);
		CreditCards ncreditcard = new CreditCards(creditcard);
		Integer relationshipCC = CCC.addClientCreditCard(factory, nclient, ncreditcard);
		
		/* Add data in delivery address*/
		Integer deladd = DA.addDeliberyAddress(factory, city, country, state, "Terreno blanco", 178);
		
		/* Create relationship between clients and delivery address */
		DeliveryAddress deliveryAddress = new DeliveryAddress(deladd);
		Integer relationshipCDA = CDA.addClientCreditCard(factory, nclient, deliveryAddress);
		
		/* Add data in Delivery Package */
		DeliveryCompany deliveryCompany = new DeliveryCompany(2);
		Integer delPackage = MDP.addDeliberyPackages(factory, deliveryCompany, 119955);
		
		/* Add data in Purchase Order*/
		DeliveryPackeges DP = new DeliveryPackeges(delPackage);
		Integer purchaseOrder = MPO.addPurchaseOrder(factory, nclient, DP);
		PurchaseOrders PO = new PurchaseOrders(purchaseOrder);
		MAP.addArticlePurchase(factory, article, PO);
		
		/* Add data in Billing */
		PurchaseOrders purchaseOrders = new PurchaseOrders(purchaseOrder);
		Integer billing = MB.addBilling(factory, purchaseOrders, 36.8);
		
		/* List data*/
		MC.listClients(factory, client);
		MCC.listCreditCards(factory, creditcard);
		DA.listDelAdd(factory, deladd);
		MDP.listDelP(factory, delPackage);
		MPO.listPurchaseOrder(factory, purchaseOrder);
		MB.listBilling(factory, billing);
		
	}

}
