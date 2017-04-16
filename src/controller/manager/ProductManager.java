package controller.manager;


import controller.StockController;
import model.Category;
import model.Product;
import model.Store;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

import static model.Store.products;

public class ProductManager {

	private int idProduct;


    /**
     * Ajoute un nouveau produit dans l'instance du singleton avec les paramètres requis
     * @param id l'id du produit à ajouter
     * @param name le nom du produit à ajouter
     * @param description la description du produit à ajouter
     * @param purchasingPrice le prix du produit à ajouter
     * @param quantity la quantité du produit à ajouter
     * @param category la catégorie du produit à ajouter
     * @return retourne le produit ajouté
     */
	public static Product addProduct(int id, String name, String description, float purchasingPrice, int quantity, Category category) {
        Product newProduct =  new Product(id, name, description, purchasingPrice, quantity, category);
	    Store.getInstance().getProducts().add(newProduct);
        return newProduct;
	}


    /**
     * Crée un nouveau produit dans la base (data.txt), en fin de document et sur une nouvelle ligne
     * Utilise l'objet Scanner, BufferedWriter et FileWriter pour effectuer les opérations d'écriture / lecture
     * @param name le nom du produit à créer
     * @param description la description du produit à créer
     * @param purchasingPrice le prix du produit à créer
     * @param quantity la quantité du produit à créer
     * @param category la catégorie du produit à créer
     * @return retourne le produit creé en base
     */
	public static Product createProduct(String name, String description, float purchasingPrice, int quantity, Category category) {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        Scanner scanner;
        int lastId = 0;
        try {
            scanner = new Scanner(new File(absPath + "/src/data.txt")).useLocale(Locale.US);
            scanner.useDelimiter(";|\\n");

            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                String nameF = scanner.next();
                String descriptionF = scanner.next();
                float priceF = scanner.nextFloat();
                int quantityF = scanner.nextInt();
                String categoryLabelF = scanner.next();
                lastId = id;
            }

            lastId = lastId + 1;
            Product newProduct = new Product(lastId, name, description, purchasingPrice, quantity, category);
            BufferedWriter wr = new BufferedWriter(new FileWriter(absPath + "/src/data.txt", true));
            wr.newLine();
            wr.write(Integer.toString(lastId) + ";" + name + ";" + description + ";" + Float.toString(purchasingPrice) + ";" + Integer.toString(quantity) + ";" + category.getLabel());
            wr.close();


            scanner.close();
            return newProduct;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Sauvegarde le produit en paramètre dans la base (fichier data.txt)
     * @param product l'objet Product à rajouter en base
     */
    public static void saveProductToFile(Product product) {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(absPath + "/src/data.txt", true));
            wr.newLine();
            wr.write(Integer.toString(product.getId()) + ";" + product.getName() + ";" + product.getDescription() + ";" + Float.toString(product.getPurchasingPrice()) + ";" + Integer.toString(product.getQuantity()) + ";" + product.getCategory().getLabel());
            wr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Retourne tous les produits présents dans l'instance du singleton
     * @return retourne une ArrayList de tous les produits présents dans l'instance
     */
	public static ArrayList<Product> getProducts() {
	    return products;
    }


    /**
     * Cherche et retourne les produits appartenant à la même catégorie
     * Effectue l'opération en se basant sur l'id de la catégorie et du produit
     * @param category l'objet Category utilisé pour chercher les produits correspondants
     * @return retourne une ArrayList de tous les produits correspondant à la catégorie cherchée
     */
    public static ArrayList<Product> getProductsByCategory(Category category) {
        ArrayList<Product> productsFound = new ArrayList<Product>();
        List<Product> objects = Store.getProducts();
        try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() == category.getId()) {
                    productsFound.add(objects.get(i));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return productsFound;
    }


    /**
     * Cherche et retourne le produit correspondant à l'id fournie en paramètre
     * @param id l'id recherché dans l'ArrayList de produits
     * @return retourne l'objet trouvé selon l'id fourni en paramèrtre
     */
    public static Product getProductById(int id) {
	    List<Product> objects = Store.getProducts();
	    try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() == id) {
                    objects.get(i);
                }
            }
        }
        catch(Exception e) {
	        e.printStackTrace();
        }
        return null;
    }


    /**
     * Cherche et retourne un produit selon la chaîne de caractères fournie en paramètre
     * Compare la chaîne de caractère avec les noms des produits présent dans l'instance du singleton
     * @param searchString le nom du produit recherché
     * @return retourne l'objet trouvé avec la chaîne de caractères fournie
     */
    public static ArrayList<Product> searchProductsByName(String searchString) {
        ArrayList<Product> productsFound = new ArrayList<Product>();
        List<Product> objects = Store.getProducts();
        try {
            for (int i = 0; i < objects.size(); i++) {
                if (searchString.equals(objects.get(i).getName())) {
                    productsFound.add(objects.get(i));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return productsFound;
    }


    /**
     * Met à jour le produit fourni en paramètre, avec les données également fournies en paramètres
     * @param product l'objet Product à mettre à jour
     * @param name le nouveau nom du produit mis à jour
     * @param description la nouvelle description du produit mis à jour
     * @param purchasingPrice le nouveau prix du produit mis à jour
     * @param quantity la nouvelle quantité du produit mis à jour
     * @param category la nouvelle catégorie du produit mis à jour
     * @return retourne l'objet Product mis à jour
     */
    public static Product updateProduct(Product product, String name, String description, float purchasingPrice, int quantity, Category category) {
	    ArrayList<Product> productToUpdate = new ArrayList<Product>();
	    List<Product> objects = Store.getProducts();
	    try {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i) == product) {
                    objects.get(i).setName(name);
                    objects.get(i).setDescription(description);
                    objects.get(i).setPurchasingPrice(purchasingPrice);
                    objects.get(i).setQuantity(quantity);
                    objects.get(i).setCategory(category);
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
     * Supprime l'objet Product fourni en paramètre de l'instance du singleton
     * @param product l'objet Product à supprimer dans l'instance
     * @return retourne le produit supprimé dans l'instance
     */
    public static Product deleteProduct(Product product) {
	    List<Product> objects = Store.getProducts();
	    Iterator<Product> iter = objects.iterator();
	    try {
            while (iter.hasNext()) {
                Product object = iter.next();
                if (object.getId() == (product.getId())) {
                    iter.remove();
                }
            }
        }
        catch(Exception e) {
	        e.printStackTrace();
        }
        return product;
    }

}
