package model;

import java.util.ArrayList;

//La classe est finale, car un singleton n'est pas censé avoir d'héritier.
public final class Store {

  // L'utilisation du mot clé volatile, en Java version 5 et supérieure,
  // permet d'éviter le cas où "Singleton.instance" est non nul,
  // mais pas encore "réellement" instancié.
  // De Java version 1.2 à 1.4, il est possible d'utiliser la classe ThreadLocal.
  private static volatile Store instance = null;
  private ArrayList<Product> products;
  

  /**
   * Constructeur de l'objet.
   */
  private Store() {
      // La présence d'un constructeur privé supprime le constructeur public par défaut.
      // De plus, seul le singleton peut s'instancier lui-même.
      this.products = new ArrayList<Product>();
  }
  
  /**
   * Méthode permettant de renvoyer une instance de la classe Singleton
   * @return Retourne l'instance du singleton.
   */
  public final static Store getInstance() {
      //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
      //d'éviter un appel coûteux à synchronized, 
      //une fois que l'instanciation est faite.
      if (Store.instance == null) {
         // Le mot-clé synchronized sur ce bloc empêche toute instanciation
         // multiple même par différents "threads".
         // Il est TRES important.
         synchronized(Store.class) {
           if (Store.instance == null) {
             Store.instance = new Store();
           }
         }
      }
      return Store.instance;
  }
  
  public ArrayList<Product> getProducts() {
	  return this.products;
  }
}