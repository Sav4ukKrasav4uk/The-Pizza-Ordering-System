public class PizzaNotFoundException extends Exception{
    public PizzaNotFoundException(String message){
        super("PizzaNotFoundException: " + message);
    }
}
