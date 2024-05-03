package Test;

import store.Product;
import store.Store;

public class TestStore {
    public static void main(String[] args) {

        Store S1 = new Store("JADE Parks Mall");
        System.out.println(S1.storeName());
        Product P1 = new Product("ice mocha", 2.98, 1.90);
        Product P2 = new Product("hot mocha", 1.98, 0.90);
        Product P3 = new Product("hot chocolate", 3.98, 2.90);
        Product P4 = new Product("ice frappe", 4.98, 1.9);
        S1.addProduct(P1);
        S1.addProduct(P2);
        S1.addProduct(P3);
        S1.addProduct(P4);
        System.out.println(S1.numberOfProducts());
        System.out.println(S1.toString(2));
        System.out.println(S1);
    }
}
