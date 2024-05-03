
package cart;
public class Taxed extends Product {
    private static double tax=0.066;
    public Taxed(String name, double cost){
        super(name, cost);


    }
    public static void setSalesTaxRate(double salesTaxRate){
        tax=salesTaxRate;
    }

    @Override
    public Product placeOrder(int quantity) {
        this.quantity=quantity;

        return null;
    }

    @Override
    public double price() {
        return quantity*unitCost*(1+tax);
    }
}

