package controller.manager;


import model.Category;
import model.Product;
import model.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static model.Store.products;

public class ProductManager {

	private int idProduct;


	public static Product addProduct(int id, String name, String description, float purchasingPrice, int quantity, Category category) {
        Product newProduct =  new Product(id, name, description, purchasingPrice, quantity, category);
	    Store.getInstance().getProducts().add(newProduct);
        return newProduct;
	}


	public static ArrayList<Product> getProducts() {
	    return products;
    }


    public static ArrayList<Product> getProductsByCategory(Category category) {
        ArrayList<Product> productsFound = new ArrayList<Product>();
        List<Product> objects = Store.getProducts();
        for (int i =0; i < objects.size(); i++) {
            if (objects.get(i).getId() == category.getId()) {
                productsFound.add(objects.get(i));
                return productsFound;
            }
        }
        return null;
    }


    public static Product getProductById(int id) {
	    List<Product> objects = Store.getProducts();
	    for (int i = 0; i < objects.size(); i++) {
	        if (objects.get(i).getId() == id) {
	            return objects.get(i);
            }
        }
        return null;
    }


    public static ArrayList<Product> searchProductsByName(String searchString) {
        ArrayList<Product> productsFound = new ArrayList<Product>();
        List<Product> objects = Store.getProducts();
        for (int i =0; i < objects.size(); i++) {
            if (searchString == objects.get(i).getName()) {
                productsFound.add(objects.get(i));
                return productsFound;
            }
        }
        return null;
    }


    public static Product updateProduct(Product product, String name, String description, float purchasingPrice, int quantity, Category category) {

    }


    public static Product deleteProduct(Product product) {
	    List<Product> objects = Store.getProducts();
	    Iterator<Product> iter = objects.iterator();
	    while(iter.hasNext()) {
            Product object = iter.next();
            if (object.getId() == (product.getId())) {
                iter.remove();
            }
        }
        return null;
    }

}
