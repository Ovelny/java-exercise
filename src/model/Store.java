package model;

import java.util.ArrayList;

//La classe est finale, car un singleton n'est pas censé avoir d'héritier.
public final class Store {

  public static volatile Store instance = null;
  public static ArrayList<Product> products;
  

  /**
   * Constructeur de l'objet.
   */
  private Store() {

      this.products = new ArrayList<Product>();
  }
  
  /**
   * Méthode permettant de renvoyer une instance de la classe Singleton
   * @return Retourne l'instance du singleton.
   */
  public final static Store getInstance() {

      if (Store.instance == null) {

         synchronized(Store.class) {
           if (Store.instance == null) {
             Store.instance = new Store();
           }
         }
      }
      return Store.instance;
  }
  
  public static ArrayList<Product> getProducts() {
	  return products;
  }
}