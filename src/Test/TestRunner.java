package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result TestManageArticles = JUnitCore.runClasses(TestManageArticles.class);
		Result TestManageClients = JUnitCore.runClasses(TestManageClients.class);
		Result TestCreditCard = JUnitCore.runClasses(TestCreditCard.class);
		Result TestManageDeliveryAddress = JUnitCore.runClasses(TestManageDeliveryAddress.class);
		Result TestDeliveryPackages = JUnitCore.runClasses(TestDeliveryPackages.class);
		Result TestPurchaseOrder = JUnitCore.runClasses(TestPurchaseOrder.class);
		Result TestManageBilling = JUnitCore.runClasses(TestManageBilling.class);
		
		runner(TestManageArticles, "TestManageArticles");
		runner(TestManageClients, "TestManageClients");
		runner(TestCreditCard, "TestCreditCard");
		runner(TestManageDeliveryAddress, "TestManageDeliveryAddress");
		runner(TestDeliveryPackages, "TestDeliveryPackages");
		runner(TestPurchaseOrder, "TestPurchaseOrder");
		runner(TestManageBilling, "TestManageBilling");
	   }
	
	public static void runner(Result result, String nameClass) {
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful() + " " + nameClass);
	}
}
