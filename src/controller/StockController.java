package controller;

import controller.manager.ProductManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class StockController {

    public static void loadProductsFromFile() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("src/controller/data.txt")).useLocale(Locale.US);
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

                ProductManager.addProduct(id, name, description, price, quantity, categoryLabel);

            }

            //Do not forget to close the scanner
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
