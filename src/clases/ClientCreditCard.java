package clases;

public class ClientCreditCard implements java.io.Serializable {

	private Integer clientCreditCardId;
	private Clients clients;
	private CreditCards creditCards;

	public ClientCreditCard() {
	}

	public ClientCreditCard(Clients clients, CreditCards creditCards) {
		this.clients = clients;
		this.creditCards = creditCards;
	}

	public Integer getClientCreditCardId() {
		return this.clientCreditCardId;
	}

	public void setClientCreditCardId(Integer clientCreditCardId) {
		this.clientCreditCardId = clientCreditCardId;
	}

	public Clients getClients() {
		return this.clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public CreditCards getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(CreditCards creditCards) {
		this.creditCards = creditCards;
	}

}
