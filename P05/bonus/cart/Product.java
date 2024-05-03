package cart;

/**
 * Models a Store of Different items.
 *
 * @author             Victor Arowosafe
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public abstract class Product {
    protected String name;
    protected double unitCost;
    protected int quantity=0;
    
    /**
     * Creates a cart.Product instance.
     *
     * @param name            name of the item
     * @param unitCost        cost for one of the item
     * @since              1.0
     */

    public Product(String name, double unitCost){
        this.name=name;
        this.unitCost=unitCost;

    }
    
     /**
     * abstract method
     *
     *
     * @since          1.0
     */


    public abstract Product placeOrder(int quantity);
    
     /**
     * abstract method
     *
     *
     * @since          1.0
     */

    public abstract double price();
    
    /**
     * Returns the name, quantity and cost per unit of an item
     *
     * @return         String the resulting quantity and unit cost
     * @since          1.0
     */

    @Override
    public String toString() {
        String answer= name+"("+"$"+unitCost+")";
        if(quantity != 0){
            answer= name+"("+quantity+"@"+"$"+unitCost+")";
        }
        return answer;
    }
}

