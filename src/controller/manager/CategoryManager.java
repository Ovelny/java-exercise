package controller.manager;

import model.Category;

import java.util.ArrayList;
import java.util.List;

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


    public static Category updateCategory(Category category, String label) {
        List<Category> objects = CategoryManager.getCategories();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getId() == category.getId()) {
                objects.get(i).setLabel(label);
                return objects.get(i);
            }
        }
        // TODO : add try / catch
        return null;
    }

    //TODO : not sure this is how it's done, check later
    public static void deleteCategory(Category category) {
        List<Category> objects = CategoryManager.getCategories();
        for (int i =0; i < objects.size(); i++) {
            if (objects.get(i).getId() == category.getId()) {
                objects.get(i).setId() = null;
                objects.get(i).setLabel() = null;
            }
        }
    }


    public static ArrayList<Category> getCategories() {
	    return categories;
    }


    public static Category getCategoryById(int id) {
        List<Category> objects = CategoryManager.getCategories();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getId() == id) {
                return objects.get(i);
            }
        }
        // TODO : add try / catch
        return null;
    }


    public static Category getCategoryByLabel(String label) {
        List<Category> objects = CategoryManager.getCategories();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getLabel().equals(label)) {
                return objects.get(i);
            }
        }
        // TODO : add try / catch
        return null;
    }
}
