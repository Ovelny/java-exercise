package model;

public class Product {
	private int id;
	private String name;
	private String description;
	private float purchasingPrice;
	private int quantity;
	private Category category;
	
	public Product(int id, String name, String description, float purchasingPrice, int quantity, Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.purchasingPrice = purchasingPrice;
		this.quantity = quantity;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(float purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
