public interface PizzaInterface {
    void viewAllPizza(PizzaStore store);
    void viewAllPizza(Order order);
    void searchPizza(PizzaStore store) throws PizzaNotFoundException;
    int searchById(PizzaStore store, int pos) throws PizzaNotFoundException;
    int searchByName(PizzaStore store, int pos) throws PizzaNotFoundException;
    int searchBySize(PizzaStore store, int pos) throws PizzaNotFoundException;
}

