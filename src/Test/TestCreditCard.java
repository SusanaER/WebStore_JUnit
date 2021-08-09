package Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.Articles;
import clases.ClientCreditCard;
import clases.ClientDelAdd;
import clases.Clients;
import clases.CreditCards;
import clases.TypeCc;
import operaciones.Factory;
import operaciones.ManageClientCreditCard;
import operaciones.ManageCreditCard;

public class TestCreditCard {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManageCreditCard MCC = new ManageCreditCard();
	TypeCc TCC = new TypeCc(2);
	ManageClientCreditCard CCC = new ManageClientCreditCard();
	Integer clientList, creditcardList, clientID, creditcardID;
	

	@Test
	public void testCreditCard() {
		Session session = factory.openSession();
		Integer creditcard = MCC.addCreditCard(factory, 12312312, "Marco Regil", TCC);
		Clients nclient = new Clients(3);
		clientID = nclient.getClientId();
		CreditCards ncreditcard = new CreditCards(creditcard);
		creditcardID = ncreditcard.getCreditCardId();
		Integer relationshipCC = CCC.addClientCreditCard(factory, nclient, ncreditcard);
		List relationshipCCList = session.createQuery("FROM ClientCreditCard c WHERE c.clientCreditCardId = " + relationshipCC).list(); 
        for (Iterator iterator = relationshipCCList.iterator(); iterator.hasNext();){
        	ClientCreditCard b = (ClientCreditCard) iterator.next(); 
            clientList = b.getClients().getClientId();
            creditcardList = b.getCreditCards().getCreditCardId();
            
        }
		
		assertAll(
	            () -> assertEquals(clientID, clientList),
	            () -> assertEquals(creditcardID, creditcardList)
	        );
	}
}
