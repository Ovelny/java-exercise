package controller.manager;


import model.Category;
import model.Product;
import model.Store;

import java.util.ArrayList;

public class ProductManager {

	private int idProduct;

	public static Product addProduct(int id, String name, String description, float purchasingPrice, int quantity, Category category) {
        Product newProduct =  new Product(id, name, description, purchasingPrice, quantity, category);
	    Store.getInstance().getProducts().add(newProduct);
        return newProduct;
	}


}
