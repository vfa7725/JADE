
package Test;

import store.Darkness;
import store.Java;
import store.Shot;

public class TestJava {
    public static void main(String[] args) {
        Java J1 = new Java("latte", 1.28, 0.99, Darkness.medium);
        J1.addShot(Shot.vanilla);
        J1.addShot(Shot.chocolate);
        System.out.println(J1);
    }
}
