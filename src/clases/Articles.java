package clases;

import java.util.HashSet;
import java.util.Set;

public class Articles implements java.io.Serializable {

	private Integer articlesId;
	private String name;
	private String description;
	private double price;
	private Set articlesPurchases = new HashSet(0);

	public Articles() {
	}
	
	public Articles(Integer ID) {
		this.articlesId = ID;
	}

	public Articles(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Articles(String name, String description, double price, Set articlesPurchases) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.articlesPurchases = articlesPurchases;
	}

	public Integer getArticlesId() {
		return this.articlesId;
	}

	public void setArticlesId(Integer articlesId) {
		this.articlesId = articlesId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set getArticlesPurchases() {
		return this.articlesPurchases;
	}

	public void setArticlesPurchases(Set articlesPurchases) {
		this.articlesPurchases = articlesPurchases;
	}

}
