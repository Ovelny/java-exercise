package model;

import java.util.ArrayList;

//La classe est finale, car un singleton n'est pas cens� avoir d'h�ritier.
public final class Store {

  // L'utilisation du mot cl� volatile, en Java version 5 et sup�rieure,
  // permet d'�viter le cas o� "Singleton.instance" est non nul,
  // mais pas encore "r�ellement" instanci�.
  // De Java version 1.2 � 1.4, il est possible d'utiliser la classe ThreadLocal.
  private static volatile Store instance = null;
  private ArrayList<Product> products;
  

  /**
   * Constructeur de l'objet.
   */
  private Store() {
      // La pr�sence d'un constructeur priv� supprime le constructeur public par d�faut.
      // De plus, seul le singleton peut s'instancier lui-m�me.
      this.products = new ArrayList<Product>();
  }
  
  /**
   * M�thode permettant de renvoyer une instance de la classe Singleton
   * @return Retourne l'instance du singleton.
   */
  public final static Store getInstance() {
      //Le "Double-Checked Singleton"/"Singleton doublement v�rifi�" permet 
      //d'�viter un appel co�teux � synchronized, 
      //une fois que l'instanciation est faite.
      if (Store.instance == null) {
         // Le mot-cl� synchronized sur ce bloc emp�che toute instanciation
         // multiple m�me par diff�rents "threads".
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