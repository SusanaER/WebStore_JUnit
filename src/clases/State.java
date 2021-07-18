package clases;

import java.util.HashSet;
import java.util.Set;

public class State implements java.io.Serializable {

	private Integer stateId;
	private Country country;
	private String name;
	private Set cities = new HashSet(0);
	private Set deliveryAddresses = new HashSet(0);

	public State() {
	}

	public State(Integer ID) {
		this.stateId = ID;
	}

	public State(Country country, String name, Set cities, Set deliveryAddresses) {
		this.country = country;
		this.name = name;
		this.cities = cities;
		this.deliveryAddresses = deliveryAddresses;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

	public Set getDeliveryAddresses() {
		return this.deliveryAddresses;
	}

	public void setDeliveryAddresses(Set deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

}
