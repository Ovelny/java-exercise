package controller;

import controller.manager.CategoryManager;
import controller.manager.ProductManager;
import model.Category;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StockController {


    /**
     * Charge le fichier data.txt et stocke les données contenues dans l'instance singleton
     * Les données sont chargées dans l'ordre basées sur le séparateur ";" du fichier
     * Utilise l'objet Scanner pour la lecture et appelle les méthodes newCategory et addProduct pour l'ajout en instance
     */
    public static void loadProductsFromFile() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(absPath+"/src/data.txt")).useLocale(Locale.US);
            //Set the delimiter used in file
            scanner.useDelimiter(";|\\n");


            //Get all tokens and store them in some data structure
            //I am just printing them
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                String description = scanner.next();
                float price = scanner.nextFloat();
                int quantity = scanner.nextInt();
                String categoryLabel = scanner.next();

                Category newCategory = CategoryManager.addCategory(categoryLabel);
                ProductManager.addProduct(id, name, description, price, quantity, newCategory);

            }

            //Do not forget to close the scanner
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     *  Appelle la méthode getCategories de la classe CategoryManager
     * @return les catégories du singleton sous la forme d'une ArrayList
     */
    public static ArrayList<Category> getCategories() {
        return CategoryManager.getCategories();
    }


    /**
     * Appelle la méthode getCategoryById de la classe CategoryManager
     * @param id l'id de la catégorie recherchée
     * @return retourne la catégorie cherchée sous forme d'objet
     */
    public static Category getCategoryById(int id) {
        return CategoryManager.getCategoryById(id);
    }


    /**
     * Appelle la méthode addCategory de la classe CategoryManager
     * @param category l'objet Category à ajouter dans l'instance du singleton
     * @param label la label de l'instance à ajouter dans le singleton
     * @return retourne l'objet Category ajoutée dans le singleton
     */
    public static Category addCategory(Category category, String label) {
        return CategoryManager.addCategory(label);
    }


    /**
     * Appelle la méthode updateCategory de la classe CategoryManager
     * @param category l'objet Category à mettre à jour
     * @param label le nouveau label à mettre à jour
     * @return retourne l'objet Category mis à jour
     */
    public static Category updateCategory(Category category, String label) {
        return CategoryManager.updateCategory(category, label);
    }


    /**
     * Appelle la méthode deleteCategory de la classe CategoryManager
     * @param category l'objet Categor à supprimer de l'instance singleton
     */
    public static void deleteCategory(Category category) {
        CategoryManager.deleteCategory(category);
    }


    /**
     * Appelle la méthode getProducts de la classe ProductManager
     * @return tous les produits présents dans l'instance singleton sous la forme d'ArrayList
     */
    public static ArrayList<Product> getProducts() {
        return ProductManager.getProducts();
    }


    /**
     * Appelle la méthode getProductsByCategory de la classe ProductManager
     * @param category l'objet Category utilisé pour chercher les produits correspondants
     * @return retourne tous les produits sous la forme d'ArrayList
     */
    public static ArrayList<Product> getProductsByCategory(Category category) {
        return ProductManager.getProductsByCategory(category);
    }


    /**
     * Appelle la méthode getProductById de la classe ProductManager
     * @param id l'id utilisé pour trouver le produit correspondant
     * @return retourne retourne l'objet retrouvé dans l'instance singleton
     */
    public static Product getProductById(int id) {
        return ProductManager.getProductById(id);
    }


    /**
     * Appelle la méthode createProduct de la classe ProductManager
     * @param name le nom du produit à créer
     * @param description la description du produit à créer
     * @param purchasingPrice le prix du produit à créer
     * @param quantity la quantité du produit à créer
     * @param category la catégorie du produit à créer
     * @return retourne le produit creé en base (data.txt)
     */
    public static Product createProduct(String name, String description, float purchasingPrice, int quantity, Category category) {
        return ProductManager.createProduct(name, description, purchasingPrice, quantity, category);
    }


    /**
     * Appelle la méthode updateProduct de la classe ProductManager
     * @param product l'objet Product à mettre à jour
     * @param name le nouveau nom du produit mis à jour
     * @param description la nouvelle description du produit mis à jour
     * @param purchasingPrice le nouveau prix du produit mis à jour
     * @param quantity la nouvelle quantité du produit mis à jour
     * @param category la nouvelle catégorie du produit mis à jour
     * @return retourne l'objet Product mis à jour
     */
    public static Product updateProduct(Product product, String name, String description, float purchasingPrice, int quantity, Category category) {
        return ProductManager.updateProduct(product, name, description, purchasingPrice, quantity, category);
    }


    /**
     * Appelle la méthode deleteProduct de la classe ProductManager
     * @param product l'objet Product à supprimer de l'instance singleton
     * @return retourne le produit supprimé de l'instance singleton
     */
    public static Product deleteProduct(Product product) {
        return ProductManager.deleteProduct(product);
    }

}
