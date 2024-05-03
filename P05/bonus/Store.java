import cart.Taxed;
import cart.Taxfree;
import cart.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private double total=0.00;
    ArrayList list=new ArrayList();



    public void menu(){
        System.out.println("====================");
        System.out.println("Welcome to the Store");
        System.out.println("====================");
        System.out.println("0. Milk ($2.85)");
        System.out.println("1. Bread ($1.99)");
        System.out.println("2. Cheese ($0.99)");
        System.out.println("3. Ice Cream ($4.95)");
        System.out.println("4. Poptarts ($3.49)");
        System.out.println("5. Oreos ($5.99)\n");
        System.out.println("Current Order:");
    }
    public void shopItems(){
        System.out.println("");
    }

    public void cli(){
        Scanner in =new Scanner(System.in);
        Taxfree f=new Taxfree("",0.00);
        System.out.println("Total due today: "+f);
        while (true) {
            menu();
            System.out.println("Enter quantity (0 to complete order) and product #:");

            String input="";
            input=in.nextLine();
            if(input.equals("0")){
                System.exit(0);
            }

            String[] split=input.split(" ");
            String lead=split[0];
            String end=split[1];
            switch (end){
                case "0":
                    Taxed g=new Taxed("Milk",2.85);
                    g.placeOrder(Integer.parseInt(lead));
                    list.add(g);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }

                    total=total+g.price();
                    System.out.println("Total due today: "+total);

                    break;

                case "1":
                    Taxed a=new Taxed("Bread",1.99);
                    a.placeOrder(Integer.parseInt(lead));
                    list.add(a);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    total=total+a.price();
                    System.out.println("Total due today: "+total);

                    break;

                case "2":
                    Taxed b=new Taxed("Cheese",0.99);
                    b.placeOrder(Integer.parseInt(lead));
                    list.add(b);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    total=total+b.price();
                    System.out.println("Total due today: "+total);

                    break;
                case "3":
                    Taxed c=new Taxed("Ice Cream",4.95);
                    c.placeOrder(Integer.parseInt(lead));
                    list.add(c);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    total=total+c.price();
                    System.out.println("Total due today: "+total);

                    break;

                case "4":
                    Taxed d=new Taxed("Poptarts",3.49);
                    d.placeOrder(Integer.parseInt(lead));
                    list.add(d);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    total=total+d.price();
                    System.out.println("Total due today: "+total);

                    break;

                case "5":
                    Taxed e=new Taxed("Oreos",5.99);
                    e.placeOrder(Integer.parseInt(lead));
                    list.add(e);
                    System.out.println("Current order: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    total=total+e.price();
                    System.out.println("Total due today: "+total);

                    break;
            }




        }

    }
    public static void main(String []args){
        Store controller=new Store();
        controller.cli();
    }
}

