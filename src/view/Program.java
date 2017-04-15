package view;
import controller.StockController;
import controller.manager.CategoryManager;

import java.util.ArrayList;

public class Program {
	
	public static void main(String[] args) {
		System.out.println("Hello, World");
        StockController.loadProductsFromFile();
		ArrayList<model.Category> test = CategoryManager.getCategories();
		System.out.println(test);
	}
	
}
