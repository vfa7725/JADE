package Store;

public class Donut extends Product{
    protected Frosting frosting;
    protected Filling filling;
    protected boolean sprinkles;

    public Donut(String name, double price, double cost, Frosting frosting, boolean sprinkles, Filling filling){
        super(name,price,cost);
        this.filling=filling;
        this.frosting=frosting;


        if(frosting.equals(Frosting.unfrosted)){
            this.sprinkles=false;
        }
        else{
            this.sprinkles=sprinkles;
        }
    }

    @Override
    public String toString() {
        return "Donut{" +
                "frosting=" + frosting +
                ", filling=" + filling +
                ", sprinkles=" + sprinkles +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                '}';
    }
}

