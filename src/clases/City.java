package clases;

import java.util.HashSet;
import java.util.Set;

public class City implements java.io.Serializable {

	private Integer cityId;
	private State state;
	private String name;
	private Set deliveryAddresses = new HashSet(0);

	public City() {
	}
	
	public City(Integer ID) {
		this.cityId = ID;
	}

	public City(State state, String name) {
		this.state = state;
		this.name = name;
	}

	public City(State state, String name, Set deliveryAddresses) {
		this.state = state;
		this.name = name;
		this.deliveryAddresses = deliveryAddresses;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
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

}
