public abstract class Product {
    protected String name;
    protected double unitCost;
    protected int quantity=0;

    public Product(String name, double unitCost){
        this.name=name;
        this.unitCost=unitCost;

    }

    public abstract Product placeOrder(int quantity);

    public abstract double price();

    @Override
    public String toString() {
        String answer= name+"("+"$"+unitCost+")";
        if(quantity != 0){
            answer= name+"("+quantity+"@"+"$"+unitCost+")";
        }
        return answer;
    }
}

