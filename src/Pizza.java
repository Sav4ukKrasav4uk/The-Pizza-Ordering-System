public class Pizza{
    private int pizzaId;
    private String pizzaName;
    private String size;
    private double price;
    private Topping topping;
    private PizzaBase pizzaBase;

    public Pizza(){}

    public Pizza(int pizzaId, String pizzaName, String size, double price, Topping topping, PizzaBase pizzaBase){
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.size = size;
        this.price = price;
        this.topping = topping;
        this.pizzaBase = pizzaBase;
    }

    public int getPizzaId(){
        return pizzaId;
    }
    public String getPizzaName(){
        return pizzaName;
    }
    public String getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public Topping getTopping() {
        return topping;
    }
    public PizzaBase getPizzaBase() {
        return pizzaBase;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setTopping(Topping topping) {
        this.topping = topping;
    }
    public void setPizzaBase(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    @Override
    public String toString(){
        return "Pizza[pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", size=" + size + ", price=" + price + ", topping=" + topping + ", pizzaBase=" + pizzaBase + "]";
    }
}
