package controller.manager;


public class ProductManager {
	
	private int idProduct;
	
	public static getProducts() {
		return Product[];
	}
	
	public static getProductsByCategory(Category category) {
		return Product[];
	}
	
	public static getProductById(int id) {
		return Product;
	}
	
	public static searchProductsByName(String searchString) {
		return Product[];
	}
	
	public static createProduct(String name, String description, float purchasingPrice, int quantity, Category category) {
		return Product;
	}
	
	public static addProduct(int id, String name, String description, float purchasingPrice, int quantity, Category category) {
		return Product;
	}
	
	public static updateProduct (Product product, String name, String description, float purchasingPrice, int quantity, Category category) {
		return Product;
	}
	
	public static deleteProduct(Product product) {
		return Product;
	}
	
	public static void saveProductToFile(Product product) {
		
	}
