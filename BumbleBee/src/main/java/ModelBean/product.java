package ModelBean;

public class product {
	public int proID;
	public String proName;
	public String category;
	public Double price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public product(int proID, String proName, String category, Double price, String image) {
		super();
		this.proID = proID;
		this.proName = proName;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	public product() {
		super();
	}
	public product(String proName, String category, Double price, String image) {
		super();
		this.proName = proName;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	
	
	
}
