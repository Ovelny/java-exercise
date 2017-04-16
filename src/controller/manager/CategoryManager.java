package controller.manager;

import model.Category;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryManager {
	
	private static int idCategory = 0;
	private String label;
    private static ArrayList<Category> categories = new ArrayList<>();


    /**
     * Ajoute une catégorie dans l'instance singleton avec le label fourni en paramètre
     * @param label le label de la catégorie à ajouter dans l'instance
     * @return retourne la catégorie creée dans l'instance singleton
     */
	public static Category addCategory(String label) {
	    idCategory = idCategory + 1;
	    Category newCategory = new Category(idCategory, label);
	    categories.add(newCategory);
	    return newCategory;
    }


    /**
     * Met à jour une catégorie existante dans l'instance du singleton
     * @param category l'objet Category à mettre à jour
     * @param label le nouveau label pour cette catégorie présente dans l'instance du singleton
     * @return retourne l'objet Category mis à jour
     */
    public static Category updateCategory(Category category, String label) {
        List<Category> objects = CategoryManager.getCategories();
        try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() == category.getId()) {
                    objects.get(i).setLabel(label);
                    return objects.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return category;
    }


    /**
     * Supprime l'objet Category fourni en paramètre, dans l'instance du singleton
     * @param category l'objet Category à supprimer dans l'instance du singleton
     */
    public static void deleteCategory(Category category) {
        List<Category> objects = CategoryManager.getCategories();
        Iterator<Category> iter = objects.iterator();
        try {
            while (iter.hasNext()) {
                Category object = iter.next();
                if (object.getId() == (category.getId())) {
                    iter.remove();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Retourne toutes les catégories sous la forme d'une ArrayList
     * @return retourne toutes les catégories présentes dans l'instance singleton
     */
    public static ArrayList<Category> getCategories() {
	    return categories;
    }


    public static Category getCategoryById(int id) {
        List<Category> objects = CategoryManager.getCategories();
        try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() == id) {
                    return objects.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Cherche et retourne la catégorie correspondant au label fourni en paramètre
     * @param label le label correspondant à la catégorie recherchée
     * @return retourne l'objet Category trouvée selon le label fourni
     */
    public static Category getCategoryByLabel(String label) {
        List<Category> objects = CategoryManager.getCategories();
        try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getLabel().equals(label)) {
                    return objects.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
