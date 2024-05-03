package Store;

import java.util.ArrayList;

public class   Store {
    protected String storeName;
    protected ArrayList<Product> products;
    protected ArrayList<Person> people;

    public Store(String storeName){
        this.storeName=storeName;
        products=new ArrayList<>();
        people=new ArrayList<>();
    }

    public String storeName(){
        return storeName;
    }

    public void addProduct(Product product){

        products.add(product);
    }

    public int numberOfProducts(){
        return products.size();
    }

    public String toString(int productIndex) {
        return products.get(productIndex).toString();
    }

    public void addPerson(Person person){

        people.add(person);
    }

    public int numberOfPeople(){
        return people.size();
    }

    public String PeopleToString(int productIndex) {
        return people.get(productIndex).toString();
    }

    public String PeopleToString() {
         String join="";
         for(int i=0;i<people.size();i++) {
             join=people.get(i).toString();
         }
        return join;
    }

    @Override
    public String toString() {
        return products.toString();
    }
}

