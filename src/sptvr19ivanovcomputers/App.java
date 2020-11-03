/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19ivanovcomputers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Consumer;
import entity.Product;

import tools.managers.ConsumerManager;
import tools.managers.ProductManager;
import tools.savers.Saver;

/**
 *
 * @author user
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    
    private ProductManager productManager = new ProductManager();
    private ConsumerManager consumerManager = new ConsumerManager();
    
    private  List<Product> listProducts = new ArrayList<>(); 
    private  List<Consumer> listConsumers = new ArrayList<>(); 
    
    public App(){
        Saver saver = new Saver();
        this.listProducts = saver.loadFromFile("listProducts");
        this.listConsumers = saver.loadFromFile("listConsumers");
    }
        
    void run() {
        boolean repeat = true;
        System.out.println("---Настольные компьютеры(PC)---");
        do{
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить товар");
            System.out.println("2. Список товаров");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Купить товар");
            System.out.println("Выберите задачу: ");
            String task = scanner.nextLine();
            switch(task){
                case"0":
                    System.out.println("---Конец программы---");
                    repeat = false;
                    break;
                case"1":
                    Product product = productManager.addProduct();
                    productManager.addProductToList(product, listProducts);
                    break;
                case"2":
                    productManager.printListProducts(listProducts);
                    break;
                case"3":
                    Consumer consumer = consumerManager.addConsumer();
                    consumerManager.addConsumerToList(consumer, listConsumers);
                    break;
                case"4":
                    consumerManager.printListConsumers(listConsumers);
                    break;
                case"5":
                    consumerManager.buyProduct(listConsumers, listProducts, productManager);
                    break;
                default:
                    System.out.println("Нет такой задачи!");
            }
        }while(repeat);
    }
    
}
