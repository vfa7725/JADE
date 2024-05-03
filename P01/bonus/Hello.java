import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String info;
        System.out.println("Enter your name: ");
        info=in.nextLine();
        System.out.println("Hello, "+info+"!");
    }
}
