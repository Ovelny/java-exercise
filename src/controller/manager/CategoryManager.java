package controller.manager;

import model.Category;

import java.util.ArrayList;

public class CategoryManager {
	
	private static int idCategory = 0;
	private String label;
    private static ArrayList<Category> categories = new ArrayList<>();

	public static Category addCategory(String label) {
	    idCategory = idCategory + 1;
	    Category newCategory = new Category(idCategory, label);
	    categories.add(newCategory);
	    return newCategory;
    }

    public static ArrayList<Category> getCategories() {
	    return categories;
    }

    public static ArrayList<Category> getCategoriesById(int id) {
	    return null;
    }
}
