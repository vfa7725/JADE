package Store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Order {

    private int id;
    private Customer customer;
    private Server server;
    private HashMap<Product,Integer> products;

    public Order(Customer customer, Server server){

        this.customer=customer;
        this.server=server;
        products=new HashMap<Product, Integer>();
        id++;
    }

    public Order(BufferedReader in) throws IOException {
        this.customer.name=in.readLine();
        this.customer.phone=in.readLine();
        this.server.name=in.readLine();
        this.server.phone=in.readLine();
        //this.products.=in.readLine();

    }
    public void save(BufferedWriter out) throws IOException {
        out.write(customer.name + '\n');
        out.write(customer.phone + '\n');
        out.write(server.name + '\n');
        out.write(server.phone + '\n');

        //super.save(out);
    }

    public int getId(){

        return id;
    }

    public void addProduct(int quantity, Product product){
        products.put(product,quantity);
    }

    @Override
    public String toString() {
        return
                ", customer=" + customer +
                ", server=" + server +
                ", products=" + products ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customer, order.customer) && Objects.equals(server, order.server) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, server, products);
    }
}

