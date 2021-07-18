package clases;

import java.util.HashSet;
import java.util.Set;

public class TypeCc implements java.io.Serializable {

	private Integer typeCcId;
	private String type;
	private Set creditCardses = new HashSet(0);

	public TypeCc() {
	}

	public TypeCc(Integer typeCcId) {
		this.typeCcId = typeCcId;
	}

	public TypeCc(String type, Set creditCardses) {
		this.type = type;
		this.creditCardses = creditCardses;
	}

	public Integer getTypeCcId() {
		return this.typeCcId;
	}

	public void setTypeCcId(Integer typeCcId) {
		this.typeCcId = typeCcId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getCreditCardses() {
		return this.creditCardses;
	}

	public void setCreditCardses(Set creditCardses) {
		this.creditCardses = creditCardses;
	}

}
