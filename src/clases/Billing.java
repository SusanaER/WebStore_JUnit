package clases;

import java.util.Date;

public class Billing implements java.io.Serializable {

	private Integer billingId;
	private PurchaseOrders purchaseOrders;
	private double amount;
	private Date date;

	public Billing() {
	}

	public Billing(PurchaseOrders purchaseOrders, double amount, Date date) {
		this.purchaseOrders = purchaseOrders;
		this.amount = amount;
		this.date = date;
	}

	public Integer getBillingId() {
		return this.billingId;
	}

	public void setBillingId(Integer billingId) {
		this.billingId = billingId;
	}

	public PurchaseOrders getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(PurchaseOrders purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
