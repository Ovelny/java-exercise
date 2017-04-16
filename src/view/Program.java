package view;
import controller.StockController;
import controller.manager.CategoryManager;
import controller.manager.ProductManager;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		System.out.println("Hello, World");
        StockController.loadProductsFromFile();
        Product blaTest = ProductManager.getProductById(1);


	}

}
