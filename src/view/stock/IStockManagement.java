package view.stock;

import model.Category;
import model.Product;

import java.util.ArrayList;

public interface IStockManagement {
	
	public Category addCategory();
	public Category updateCategory();
	public void deleteCategory();
	public ArrayList<Category> getCategories();
	public Product addProduct();
	public void deleteProduct();
	public ArrayList<Product> ArrayListProducts();
	public Product getProduct();
}
