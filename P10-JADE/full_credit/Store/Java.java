package Store;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Java extends Product {
    public static final String ID = "store.Java";
    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>();
    }
    public Java(BufferedReader in) throws IOException {
        super(in);
        this.darkness  = Darkness.valueOf(in.readLine());
        this.shots = new ArrayList<>();
        int size = Integer.parseInt(in.readLine());
        for(int i=0; i<size; ++i)
            shots.add(Shot.valueOf(in.readLine()));
    }
    @Override
    public void save(BufferedWriter out) throws IOException {
        out.write(ID + '\n');
        super.save(out);
        out.write("" + darkness  + '\n');
        out.write("" + shots.size() + '\n');
        for(Shot s : shots)
            out.write("" + s + '\n');
    }

    public void addShot(Shot shot) {
        shots.add(shot);
    }
    @Override
    public String toString() {
        String result = name + " (" + darkness + " with ";
        if (shots.size() == 0) result += "no shots";
        else {
            String separator = "";
            for(Shot s : shots) {
                result += separator + s;
                separator = ", ";
            }
        }
        result += ") $" + price;
        return result;
    }

    Darkness darkness;
    ArrayList<Shot> shots;
}
