import java.util.Scanner;

public class Admin extends PizzaService{
    private static final Scanner sc = new Scanner(System.in);
    public void commands(PizzaStore store){
        while (true){
            System.out.println("<ADMIN " + store.getStoreName() + ">");
            System.out.println("Choose the option:");
            System.out.println("1. Add pizza");
            System.out.println("2. Update pizza");
            System.out.println("3. Delete pizza");
            System.out.println("4. View all pizza");
            System.out.println("5. Search pizza");
            System.out.println("6. Exit");

            int selection;
            while (true){
                String input = sc.nextLine();
                try {
                    Integer.parseInt(input);
                }
                catch (Exception e){
                    System.out.println("Enter 1-6!");
                    continue;
                }
                selection = Integer.parseInt(input);
                if (selection >= 1 && selection <= 6){
                    break;
                }
                else {
                    System.out.println("Enter 1-6!");
                }
            }

            if (selection == 6){
                System.out.println("Exiting...");
                break;
            }

            switch (selection){
                case 1: addPizza(store); break;
                case 2:
                    try {
                        updatePizza(store);
                    }
                    catch (PizzaNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        deletePizza(store);
                    }
                    catch (PizzaNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: super.viewAllPizza(store); break;
                case 5:
                    try {
                        super.searchPizza(store);
                    }
                    catch (PizzaNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

    public void addPizza(PizzaStore store){
        Pizza pizza = new Pizza();

        while (true){
            System.out.print("Enter the pizza name: ");
            String name = sc.nextLine();

            boolean flag = true;
            for (Pizza element : store.getPizzas()){
                if (element.getPizzaName().equals(name)){
                    flag = false;
                    break;
                }
            }

            if (!flag){
                System.out.println("Pizza with this name already exists!");
                continue;
            }
            pizza.setPizzaName(name);
            break;
        }

        System.out.println("Enter the pizza size:");
        System.out.println("1. small\n2. medium\n3. large");

        int selectionSize;
        while (true){
            String input = sc.nextLine();
            try {
                Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Enter 1-3!");
                continue;
            }
            selectionSize = Integer.parseInt(input);
            if (selectionSize >= 1 && selectionSize <= 3){
                break;
            }
            else {
                System.out.println("Enter 1-3!");
            }
        }

        String[] sizes = {"small", "medium", "large"};
        pizza.setSize(sizes[selectionSize - 1]);

        double price;
        while (true){
            System.out.print("Enter the pizza price: ");
            String input = sc.nextLine();
            try {
                Double.parseDouble(input);
            }
            catch (Exception e){
                continue;
            }
            price = Double.parseDouble(input);
            break;
        }
        pizza.setPrice(price);

        System.out.println("Enter an information about topping:");
        Pizza topping = new Topping();

        System.out.print("Name: ");
        String toppingName = sc.nextLine();
        System.out.print("Spice level: ");
        String spiceLevel = sc.nextLine();
        System.out.print("Description: ");
        String toppingDescription = sc.nextLine();

        pizza.setTopping(new Topping(toppingName, spiceLevel, toppingDescription));

        System.out.println("Enter an information about pizza base:");
        Pizza pizzaBase = new PizzaBase();

        System.out.print("Name: ");
        String baseName = sc.nextLine();
        System.out.print("Type: ");
        String baseType = sc.nextLine();
        System.out.print("Description: ");
        String baseDescription = sc.nextLine();

        pizza.setPizzaBase(new PizzaBase(baseName, baseType, baseDescription));
        pizza.setPizzaId(store.getPizzas().size() + 1);

        store.addPizza(pizza);
        System.out.println("The " + pizza.getPizzaName() + " pizza is successfully added.");
    }
    public void updatePizza(PizzaStore store) throws PizzaNotFoundException{
        System.out.print("Enter the pizza name: ");
        String name = sc.nextLine();

        int pos = -1;
        for (Pizza element : store.getPizzas()){
            if (element.getPizzaName().equals(name)){
                pos = element.getPizzaId();
                break;
            }
        }

        if (pos == -1){
            throw new PizzaNotFoundException("Pizza doesn't exist!");
        }

        double price;
        while (true){
            System.out.print("Enter the new price to be updated: ");
            String input = sc.nextLine();
            try {
                Double.parseDouble(input);
            }
            catch (Exception e){
                continue;
            }
            price = Double.parseDouble(input);
            break;
        }
        store.getPizzas().get(pos - 1).setPrice(price);
        System.out.println("The " + store.getPizzas().get(pos - 1).getPizzaName() + " pizza is successfully updated!");
    }
    public void deletePizza(PizzaStore store) throws PizzaNotFoundException{
        System.out.print("Enter the pizza name: ");
        String name = sc.nextLine();

        int pos = -1;
        for (Pizza element : store.getPizzas()){
            if (element.getPizzaName().equals(name)){
                pos = element.getPizzaId();
                break;
            }
        }

        if (pos == -1){
            throw new PizzaNotFoundException("Pizza doesn't exist!");
        }

        store.deletePizza(store.getPizzas().get(pos - 1));
        for (int i = 0; i < store.getPizzas().size(); i++){
            if (store.getPizzas().get(i).getPizzaId() != i + 1){
                store.getPizzas().get(i).setPizzaId(i + 1);
            }
        }
        System.out.println("The pizza is successfully deleted!");
    }
}
