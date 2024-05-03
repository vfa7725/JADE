package Store;

import java.util.ArrayList;

public class Store {
    protected String storeName;
    protected ArrayList<Product> products;

    public Store(String storeName){
        this.storeName=storeName;
        products=new ArrayList<>();
    }

    public String storeName(){
        return storeName;
    }

    public void addProduct(Product product){

        products.add(product);
    }

    public int numberOfProducts(){
        return products.size();
    }

    public String toString(int productIndex) {
        return products.get(productIndex).toString();
    }

    @Override
    public String toString() {
        return products.toString();
    }
}

