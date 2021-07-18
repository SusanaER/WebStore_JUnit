package clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PurchaseOrders implements java.io.Serializable {

	private Integer purchaseOrderId;
	private Clients clients;
	private DeliveryPackeges deliveryPackeges;
	private Date date;
	private Set articlesPurchases = new HashSet(0);
	private Set billings = new HashSet(0);

	public PurchaseOrders() {
	}
	
	public PurchaseOrders(Integer id) {
		this.purchaseOrderId = id;
	}

	public PurchaseOrders(Clients clients, DeliveryPackeges deliveryPackeges, Date date) {
		this.clients = clients;
		this.deliveryPackeges = deliveryPackeges;
		this.date = date;
	}

	public PurchaseOrders(Clients clients, DeliveryPackeges deliveryPackeges, Date date, Set articlesPurchases,
			Set billings) {
		this.clients = clients;
		this.deliveryPackeges = deliveryPackeges;
		this.date = date;
		this.articlesPurchases = articlesPurchases;
		this.billings = billings;
	}

	public Integer getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Clients getClients() {
		return this.clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public DeliveryPackeges getDeliveryPackeges() {
		return this.deliveryPackeges;
	}

	public void setDeliveryPackeges(DeliveryPackeges deliveryPackeges) {
		this.deliveryPackeges = deliveryPackeges;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set getArticlesPurchases() {
		return this.articlesPurchases;
	}

	public void setArticlesPurchases(Set articlesPurchases) {
		this.articlesPurchases = articlesPurchases;
	}

	public Set getBillings() {
		return this.billings;
	}

	public void setBillings(Set billings) {
		this.billings = billings;
	}

}
