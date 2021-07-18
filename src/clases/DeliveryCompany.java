package clases;

import java.util.HashSet;
import java.util.Set;

public class DeliveryCompany implements java.io.Serializable {

	private Integer deliveryCompanyId;
	private String name;
	private Set deliveryPackegeses = new HashSet(0);

	public DeliveryCompany() {
	}

	public DeliveryCompany(Integer id) {
		this.deliveryCompanyId = id;
	}

	public DeliveryCompany(String name, Set deliveryPackegeses) {
		this.name = name;
		this.deliveryPackegeses = deliveryPackegeses;
	}

	public Integer getDeliveryCompanyId() {
		return this.deliveryCompanyId;
	}

	public void setDeliveryCompanyId(Integer deliveryCompanyId) {
		this.deliveryCompanyId = deliveryCompanyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getDeliveryPackegeses() {
		return this.deliveryPackegeses;
	}

	public void setDeliveryPackegeses(Set deliveryPackegeses) {
		this.deliveryPackegeses = deliveryPackegeses;
	}

}
