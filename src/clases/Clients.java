package clases;

import java.util.HashSet;
import java.util.Set;

public class Clients implements java.io.Serializable {

	private Integer clientId;
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private Set purchaseOrderses = new HashSet(0);
	private Set clientDelAdds = new HashSet(0);
	private Set clientCreditCards = new HashSet(0);

	public Clients() {
		
	}
	
	public Clients(Integer client) {
		this.clientId = client;
	}

	public Clients(String name, String lastName, String username, String password, String email) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Clients(String name, String lastName, String username, String password, String email, Set purchaseOrderses,
			Set clientDelAdds, Set clientCreditCards) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.purchaseOrderses = purchaseOrderses;
		this.clientDelAdds = clientDelAdds;
		this.clientCreditCards = clientCreditCards;
	}
	

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getPurchaseOrderses() {
		return this.purchaseOrderses;
	}

	public void setPurchaseOrderses(Set purchaseOrderses) {
		this.purchaseOrderses = purchaseOrderses;
	}

	public Set getClientDelAdds() {
		return this.clientDelAdds;
	}

	public void setClientDelAdds(Set clientDelAdds) {
		this.clientDelAdds = clientDelAdds;
	}

	public Set getClientCreditCards() {
		return this.clientCreditCards;
	}

	public void setClientCreditCards(Set clientCreditCards) {
		this.clientCreditCards = clientCreditCards;
	}


}
