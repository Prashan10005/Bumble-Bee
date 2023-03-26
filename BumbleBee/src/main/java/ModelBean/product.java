package ModelBean;

public class product {
	public int proID;
	public String proName;
	public String category;
	public String brand;
	public Double price;
	public int stoclInHand;
	public String image;
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStoclInHand() {
		return stoclInHand;
	}
	public void setStoclInHand(int stoclInHand) {
		this.stoclInHand = stoclInHand;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public product(int proID, String proName, String category, String brand, Double price, int stoclInHand,
			String image) {
		super();
		this.proID = proID;
		this.proName = proName;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.stoclInHand = stoclInHand;
		this.image = image;
	}
	
	
}
