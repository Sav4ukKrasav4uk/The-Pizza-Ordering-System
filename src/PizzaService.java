import java.util.ArrayList;
import java.util.Scanner;

public abstract class PizzaService implements PizzaInterface{
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void viewAllPizza(PizzaStore store){
        ArrayList<Pizza> pizzas = store.getPizzas();

        if (pizzas.isEmpty()){
            System.out.println("There are no available pizzas!");
            return;
        }

        for (Pizza pizza : pizzas){
            System.out.println("ID: " + pizza.getPizzaId());
            System.out.println("Pizza details >>> Name: " + pizza.getPizzaName() + ", Size: " + pizza.getSize() + ", Price: " + pizza.getPrice());
            System.out.println("Topping details >>> Name: " + pizza.getTopping().getToppingName() + ", Spice level: " + pizza.getTopping().getSpiceLevel() + ", Description: " + pizza.getTopping().getDescription());
            System.out.println("Pizza base details >>> Name: " + pizza.getPizzaBase().getBaseName() + ", Type: " + pizza.getPizzaBase().getBaseType() + ", Description: " + pizza.getPizzaBase().getDescription());
            System.out.println();
        }
    }
    @Override
    public void viewAllPizza(Order order){
        ArrayList<Pizza> pizzas = order.getPizzas();

        if (pizzas.isEmpty()){
            System.out.println("There are no pizzas.");
            return;
        }

        for (Pizza pizza : pizzas){
            System.out.println("ID: " + pizza.getPizzaId());
            System.out.println("Pizza details >>> Name: " + pizza.getPizzaName() + ", Size: " + pizza.getSize() + ", Price: " + pizza.getPrice());
            System.out.println("Topping details >>> Name: " + pizza.getTopping().getToppingName() + ", Spice level: " + pizza.getTopping().getSpiceLevel() + ", Description: " + pizza.getTopping().getDescription());
            System.out.println("Pizza base details >>> Name: " + pizza.getPizzaBase().getBaseName() + ", Type: " + pizza.getPizzaBase().getBaseType() + ", Description: " + pizza.getPizzaBase().getDescription());
            System.out.println();
        }
    }
    @Override
    public void searchPizza(PizzaStore store) throws PizzaNotFoundException{
        System.out.println("Choose your search type:");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by ID");
        System.out.println("3. Search by Price");

        int selection;
        while (true){
            String input = sc.nextLine();
            try {
                Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Enter 1-3!");
                continue;
            }
            selection = Integer.parseInt(input);
            if (selection >= 1 && selection <= 3){
                break;
            }
            else {
                System.out.println("Enter 1-3!");
            }
        }

        int pos = -1;
        if (selection == 1){
            try {
                pos = searchByName(store, pos);
            }
            catch (PizzaNotFoundException e){
                throw new PizzaNotFoundException(e.getMessage());
            }
        }
        else if (selection == 2){
            try {
                pos = searchById(store, pos);
            }
            catch (PizzaNotFoundException e){
                throw new PizzaNotFoundException(e.getMessage());
            }
        }
        else {
            try {
                pos = searchBySize(store, pos);
            }
            catch (PizzaNotFoundException e){
                throw new PizzaNotFoundException(e.getMessage());
            }
        }

        Pizza pizza = store.getPizzas().get(pos - 1);
        System.out.println("ID: " + pizza.getPizzaId());
        System.out.println("Pizza details >>> Name: " + pizza.getPizzaName() + ", Size: " + pizza.getSize() + ", Price: " + pizza.getPrice());
        System.out.println("Topping details >>> Name: " + pizza.getTopping().getToppingName() + ", Spice level: " + pizza.getTopping().getSpiceLevel() + ", Description: " + pizza.getTopping().getDescription());
        System.out.println("Pizza base details >>> Name: " + pizza.getPizzaBase().getBaseName() + ", Type: " + pizza.getPizzaBase().getBaseType() + ", Description: " + pizza.getPizzaBase().getDescription());
    }
    @Override
    public int searchByName(PizzaStore store, int pos) throws PizzaNotFoundException{
        System.out.print("Enter the pizza name: ");
        String name = sc.nextLine();

        for (Pizza element : store.getPizzas()){
            if (element.getPizzaName().equals(name)){
                pos = element.getPizzaId();
                break;
            }
        }
        if (pos == -1){
            throw new PizzaNotFoundException("Pizza with this name doesn't exist!");
        }
        return pos;
    }
    @Override
    public int searchById(PizzaStore store, int pos) throws PizzaNotFoundException{
        System.out.print("Enter the pizza ID: ");
        int id;
        while (true){
            String input = sc.nextLine();
            try {
                Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Incorrect type of ID!");
                continue;
            }
            id = Integer.parseInt(input);
            break;
        }

        for (Pizza element : store.getPizzas()){
            if (element.getPizzaId() == id){
                pos = element.getPizzaId();
                break;
            }
        }
        if (pos == -1){
            throw new PizzaNotFoundException("Pizza with this id doesn't exist!");
        }
        return pos;
    }
    @Override
    public int searchBySize(PizzaStore store, int pos) throws PizzaNotFoundException{
        System.out.print("Enter the pizza price: ");
        double price;
        while (true){
            String input = sc.nextLine();
            try {
                Double.parseDouble(input);
            }
            catch (Exception e){
                System.out.println("Incorrect type of price!");
                continue;
            }
            price = Double.parseDouble(input);
            break;
        }

        for (Pizza element : store.getPizzas()){
            if (element.getPrice() == price){
                pos = element.getPizzaId();
                break;
            }
        }
        if (pos == -1){
            throw new PizzaNotFoundException("Pizza with this id doesn't exist!");
        }
        return pos;
    }
}
