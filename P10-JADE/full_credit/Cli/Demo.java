package Cli;

import Store.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    ArrayList<Darkness> A1=new ArrayList<>();
    ArrayList<Shot> A2=new ArrayList<>();
    ArrayList<Filling> A3=new ArrayList<>();
    ArrayList<Frosting> A4=new ArrayList<>();
    ArrayList shotBack=new ArrayList();
    ArrayList don=new ArrayList();
    public String n;
    public Donut donut;
    public Java java;

    public void mainMenu(){
        System.out.println("Options: ");
        System.out.println("0) Exit");
        System.out.println("1) Add java");
        System.out.println("2) Add donut");
    }
    public void darknessOptions(){
        if(A1.isEmpty()){
            A1.add(Darkness.blond);
            A1.add(Darkness.light);
            A1.add(Darkness.medium);
            A1.add(Darkness.dark);
            A1.add(Darkness.extreme);
        }

            System.out.println("Brew Options");
            System.out.println("============");
            for(int i=0;i<A1.size();i++){
                System.out.println(i+") "+A1.get(i));
            }

    }

    public void shotOptions(){
        if(A2.isEmpty()){
            A2.add(Shot.none);
            A2.add(Shot.chocolate);
            A2.add(Shot.vanilla);
            A2.add(Shot.hazelnut);
            A2.add(Shot.peppermint);
        }

            System.out.println("Shot Options");
            System.out.println("============");
            for(int i=0;i<A2.size();i++){
                System.out.println(i+") "+A2.get(i));
            }
    }

    public void fillingOptions(){
        if(A3.isEmpty()){
            A3.add(Filling.unfilled);
            A3.add(Filling.chocolate);
            A3.add(Filling.vanilla);
            A3.add(Filling.strawberry);
        }

            System.out.println("Filling Options");
            System.out.println("===============");
            for(int i=0;i<A3.size();i++){
                System.out.println(i+") "+A3.get(i));
            }

    }

    public void frostingOptions(){
        if(A4.isEmpty()){
            A4.add(Frosting.unfrosted);
            A4.add(Frosting.creme);
            A4.add(Frosting.strawberry);
            A4.add(Frosting.Bavarian);
        }

            System.out.println("Frosting Options");
            System.out.println("================");
            for(int i=0;i<A4.size();i++){
                System.out.println(i+") "+A4.get(i));
            }

    }

    public int choice(){
        Scanner in=new Scanner(System.in);
        Store S1=new Store(n);
        System.out.println("Welcome to "+S1.storeName()+"\n");
        if(!(shotBack.isEmpty())){
            System.out.println(java);
        }
        if(!(don.isEmpty())){
            System.out.println(donut);
        }
        mainMenu();
        int choice;
        System.out.println("Choice? ");
        choice=in.nextInt();
        return choice;
    }

    public void startShop(){
        Scanner in=new Scanner(System.in);
        System.out.println("What is the name of the new store? ");
        n =in.nextLine();
        boolean start=true;
        while(start){

            int c=choice();
            String Name;
            double cost;
            double price;

            String name;
            double Cost;
            double Price;


            switch (c){
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("Name: ");
                    Name=in.nextLine();
                    System.out.println("Cost: ");
                    cost=in.nextDouble();
                    System.out.println("Price: ");
                    price=in.nextDouble();

                    darknessOptions();
                    int dark;
                    System.out.println("Which darkness? ");
                    dark=in.nextInt();
                    shotOptions();
                    int shotT;
                    System.out.println("Add shot (-1 when done)? ");
                    shotT = in.nextInt();
                    java=new Java(Name,price,cost,A1.get(dark));


                    while (shotT >= 0) {
                        java.addShot(A2.get(shotT));
                        shotBack.add(java);
                        shotOptions();
                        System.out.println("Add shot (-1 when done)? ");
                        shotT = in.nextInt();
                        if(shotT < 0){
                            break;
                        }

                    }


                    break;


                case 2:
                    System.out.println("Name: ");
                    name=in.next();
                    System.out.println("Cost: ");
                    Cost=in.nextDouble();
                    System.out.println("Price: ");
                    Price=in.nextDouble();

                    frostingOptions();
                    System.out.println("Which frosting? ");
                    int frost;
                    frost=in.nextInt();

                    fillingOptions();
                    System.out.println("Which filling? ");
                    int fill;
                    fill=in.nextInt();

                    String bool;
                    boolean b=true;
                    System.out.println("Sprinkles? ");

                    bool=in.next();
                    if(bool.equals("no")){
                        b=false;
                    }
                    else if(bool.equals("yes")){
                        b=true;
                    }

                    donut=new Donut(name,Price,Cost,A4.get(frost),b,A3.get(fill));
                    don.add(donut);

                    break;

            }



        }
    }

    public static void main(String [] args){
        Demo D1=new Demo();
        D1.startShop();
    }
}

