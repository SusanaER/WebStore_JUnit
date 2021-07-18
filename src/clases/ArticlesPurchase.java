package clases;

public class ArticlesPurchase implements java.io.Serializable {

	private Integer articlesPurchaseId;
	private Articles articles;
	private PurchaseOrders purchaseOrders;

	public ArticlesPurchase() {
	}

	public ArticlesPurchase(Articles articles, PurchaseOrders purchaseOrders) {
		this.articles = articles;
		this.purchaseOrders = purchaseOrders;
	}

	public Integer getArticlesPurchaseId() {
		return this.articlesPurchaseId;
	}

	public void setArticlesPurchaseId(Integer articlesPurchaseId) {
		this.articlesPurchaseId = articlesPurchaseId;
	}

	public Articles getArticles() {
		return this.articles;
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	public PurchaseOrders getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(PurchaseOrders purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

}
