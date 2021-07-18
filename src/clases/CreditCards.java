package clases;

import java.util.HashSet;
import java.util.Set;

public class CreditCards implements java.io.Serializable {

	private Integer creditCardId;
	private TypeCc typeCc;
	private int number;
	private String cardholder;
	private Set clientCreditCards = new HashSet(0);

	public CreditCards() {
		
	}
	
	public CreditCards(Integer id) {
		this.creditCardId = id;
	}

	public CreditCards(TypeCc typeCc, int number, String cardholder) {
		this.typeCc = typeCc;
		this.number = number;
		this.cardholder = cardholder;
	}

	public CreditCards(TypeCc typeCc, int number, String cardholder, Set clientCreditCards) {
		this.typeCc = typeCc;
		this.number = number;
		this.cardholder = cardholder;
		this.clientCreditCards = clientCreditCards;
	}

	public Integer getCreditCardId() {
		return this.creditCardId;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public TypeCc getTypeCc() {
		return this.typeCc;
	}

	public void setTypeCc(TypeCc typeCc) {
		this.typeCc = typeCc;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCardholder() {
		return this.cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public Set getClientCreditCards() {
		return this.clientCreditCards;
	}

	public void setClientCreditCards(Set clientCreditCards) {
		this.clientCreditCards = clientCreditCards;
	}

}
