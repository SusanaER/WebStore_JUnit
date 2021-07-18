package clases;

public class ClientDelAdd implements java.io.Serializable {

	private Integer clientDelAddId;
	private Clients clients;
	private DeliveryAddress deliveryAddress;

	public ClientDelAdd() {
	}

	public ClientDelAdd(Clients clients, DeliveryAddress deliveryAddress) {
		this.clients = clients;
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getClientDelAddId() {
		return this.clientDelAddId;
	}

	public void setClientDelAddId(Integer clientDelAddId) {
		this.clientDelAddId = clientDelAddId;
	}

	public Clients getClients() {
		return this.clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public DeliveryAddress getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
