package Test;
import Store.Donut;
import Store.Filling;
import Store.Frosting;

public class TestDonut {
    public static void main(String [] args){
        Donut D1=new Donut("glazed",2.38,1.6,Frosting.unfrosted,true,Filling.unfilled);
        System.out.println(D1);
    }
}

