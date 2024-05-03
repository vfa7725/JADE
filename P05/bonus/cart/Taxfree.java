package cart;
public class Taxfree extends Product{

    public Taxfree(String name, double cost) {
        super(name, cost);
    }

    @Override
    public Product placeOrder(int quantity) {
        if(quantity < 0){
            throw new NumberFormatException();
        }
        else {
            return placeOrder(quantity);
        }
    }

    @Override
    public double price() {
        double price=quantity*unitCost;
        return price;
    }
}

