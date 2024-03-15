import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date orderDate;
    private ArrayList<Pizza> pizzas;
    private double orderAmount;

    public Order(){
        orderDate = new Date();
        pizzas = new ArrayList<>();
        orderAmount = 0;
    }
    public Order(Date orderDate, ArrayList<Pizza> pizzas, double orderAmount){
        this.orderDate = orderDate;
        this.pizzas = pizzas;
        this.orderAmount = orderAmount;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void addAmount(double money){
        orderAmount += money;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString(){
        return "Order[orderDate=" + orderDate + ", orderAmount=" + orderAmount + "]";
    }
}
