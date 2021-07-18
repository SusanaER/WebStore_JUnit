package clases;

import java.util.HashSet;
import java.util.Set;

public class Country implements java.io.Serializable {

	private Integer countryId;
	private String name;
	private Set deliveryAddresses = new HashSet(0);
	private Set states = new HashSet(0);

	public Country() {
	
	}
	
	public Country(Integer ID) {
		this.countryId = ID;
	}

	public Country(String name, Set deliveryAddresses, Set states) {
		this.name = name;
		this.deliveryAddresses = deliveryAddresses;
		this.states = states;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getDeliveryAddresses() {
		return this.deliveryAddresses;
	}

	public void setDeliveryAddresses(Set deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public Set getStates() {
		return this.states;
	}

	public void setStates(Set states) {
		this.states = states;
	}

}
