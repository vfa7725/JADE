package Test;

import Store.Product;

public class TestProduct {
    public static void main(String [] args){
        Product P1=new Product("coffee",3.98,2.19);
        System.out.println(P1.name());
        System.out.println(P1);

    }
}

