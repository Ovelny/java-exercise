package view.stock;

import model.Product;

import java.util.ArrayList;

public interface IStockConsultation {
	
	public ArrayList<Product> ArrayListProducts();
	public Product getProduct();
	public ArrayList<Product> searchProduct();
}
