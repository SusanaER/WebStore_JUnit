package clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DeliveryPackeges implements java.io.Serializable {

	private Integer deliveryPackegesId;
	private DeliveryCompany deliveryCompany;
	private Date deliveryDate;
	private int packegeNumber;
	private Set purchaseOrderses = new HashSet(0);

	public DeliveryPackeges() {
	}
	
	public DeliveryPackeges(Integer id) {
		this.deliveryPackegesId = id;
	}

	public DeliveryPackeges(DeliveryCompany deliveryCompany, Date deliveryDate, int packegeNumber) {
		this.deliveryCompany = deliveryCompany;
		this.deliveryDate = deliveryDate;
		this.packegeNumber = packegeNumber;
	}

	public DeliveryPackeges(DeliveryCompany deliveryCompany, Date deliveryDate, int packegeNumber,
			Set purchaseOrderses) {
		this.deliveryCompany = deliveryCompany;
		this.deliveryDate = deliveryDate;
		this.packegeNumber = packegeNumber;
		this.purchaseOrderses = purchaseOrderses;
	}

	public Integer getDeliveryPackegesId() {
		return this.deliveryPackegesId;
	}

	public void setDeliveryPackegesId(Integer deliveryPackegesId) {
		this.deliveryPackegesId = deliveryPackegesId;
	}

	public DeliveryCompany getDeliveryCompany() {
		return this.deliveryCompany;
	}

	public void setDeliveryCompany(DeliveryCompany deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getPackegeNumber() {
		return this.packegeNumber;
	}

	public void setPackegeNumber(int packegeNumber) {
		this.packegeNumber = packegeNumber;
	}

	public Set getPurchaseOrderses() {
		return this.purchaseOrderses;
	}

	public void setPurchaseOrderses(Set purchaseOrderses) {
		this.purchaseOrderses = purchaseOrderses;
	}

}
