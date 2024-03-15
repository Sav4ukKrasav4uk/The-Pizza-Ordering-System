import java.util.ArrayList;

public class PizzaStore{
    private int storeId;
    private String storeName;
    private Address storeLocation;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private final ArrayList<Customer> customers = new ArrayList<>();

    public PizzaStore(){}

    public PizzaStore(int storeId, String storeName, Address storeLocation){
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
    }

    public int getStoreId() {
        return storeId;
    }
    public String getStoreName() {
        return storeName;
    }
    public Address getStoreLocation() {
        return storeLocation;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public void setStoreLocation(Address storeLocation) {
        this.storeLocation = storeLocation;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void deletePizza(Pizza pizza){
        pizzas.remove(pizza);
    }
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }
    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    @Override
    public String toString(){
        return "PizzaStore[storeId=" + storeId + ", storeName=" + storeName + ", storeLocation=" + storeLocation + "]";
    }
}
