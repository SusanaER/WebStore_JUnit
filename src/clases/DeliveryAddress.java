package clases;

import java.util.HashSet;
import java.util.Set;

public class DeliveryAddress implements java.io.Serializable {

	private Integer delAddId;
	private City city;
	private Country country;
	private State state;
	private String street;
	private int number;
	private Set clientDelAdds = new HashSet(0);

	public DeliveryAddress() {
	}

	public DeliveryAddress(Integer id) {
		this.delAddId = id;
	}
	
	public DeliveryAddress(City city, Country country, State state, String street, int number) {
		this.city = city;
		this.country = country;
		this.state = state;
		this.street = street;
		this.number = number;
	}

	public DeliveryAddress(City city, Country country, State state, String street, int number, Set clientDelAdds) {
		this.city = city;
		this.country = country;
		this.state = state;
		this.street = street;
		this.number = number;
		this.clientDelAdds = clientDelAdds;
	}

	public Integer getDelAddId() {
		return this.delAddId;
	}

	public void setDelAddId(Integer delAddId) {
		this.delAddId = delAddId;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set getClientDelAdds() {
		return this.clientDelAdds;
	}

	public void setClientDelAdds(Set clientDelAdds) {
		this.clientDelAdds = clientDelAdds;
	}

}
