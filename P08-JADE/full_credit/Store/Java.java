package Store;

import java.util.ArrayList;
import java.io.Serializable;

public class Java extends Product implements Serializable {
    protected Darkness darkness;
    protected ArrayList<Shot> shots;

    public Java(String name, double price, double cost, Darkness darkness){
        super(name,price,cost);
        this.darkness=darkness;
        shots=new ArrayList<>();
    }

    public void addShot(Shot shot){
        shots.add(shot);
    }

    @Override
    public String toString() {
        return "Java{" +
                "darkness=" + darkness +
                ", shots=" + shots +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                '}';
    }
}

