package view;
import controller.StockController;
import controller.manager.CategoryManager;
import model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		System.out.println("Hello, World");
        StockController.loadProductsFromFile();
        Category test = CategoryManager.getCategoryByLabel("vinBien");
        //Category test = CategoryManager.getCategoryById(1);
        System.out.println(test);
	}

}
