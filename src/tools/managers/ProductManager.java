/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import java.util.List;
import java.util.Scanner;

import entity.Product;
import tools.savers.Saver;

/**
 *
 * @author user
 */
public class ProductManager {
    private Scanner scanner = new Scanner(System.in);
    public Product addProduct() {
        System.out.println("---Добавить товар---");
        System.out.println("Введите название товара: ");
        String name = scanner.nextLine();
        
        System.out.println("Введите количество товара: ");
        Integer quantity = scanner.nextInt();
        
        System.out.println("Введите цену товара: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(name, price, quantity);
        return product;
        
    }
    public void addProductToList(Product product, List<Product> listProducts){
        listProducts.add(product);
        Saver saver = new Saver();
        saver.saveToFile(listProducts, "listProducts");
    }    
    
    public void printListProducts(List<Product> listProducts){
        System.out.println("---Список товаров---");
        for (int i = 0; i < listProducts.size(); i++) {
            Product product = listProducts.get(i);
            
            System.out.printf("%d."+" Название: "+"%s"+" цена: "+"%s"+" количество: "+"%s"+"%n"
            ,i+1
            ,product.getName()
            ,product.getPrice()
            ,product.getQuantity()
            );

            
        }
    }
    
}
