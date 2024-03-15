import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<PizzaStore> pizzaStores = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("Welcome!");

        while (true){
            System.out.println("Choose the option:\n1. Add new store\n2. View all stores\n3. Delete store\n4. Exit");

            int selection;
            while (true){
                String input = sc.nextLine();
                try {
                    Integer.parseInt(input);
                }
                catch (Exception e){
                    System.out.println("Enter 1-4!");
                    continue;
                }

                selection = Integer.parseInt(input);
                if (selection == 1 || selection == 2 || selection == 3 || selection == 4){
                    break;
                }
                else {
                    System.out.println("Enter 1-4!");
                }
            }

            if (selection == 1){
                addNewStore();
            }
            else if (selection == 2){
                viewAllStores();
            }
            else if (selection == 3){
                deleteStore();
            }
            else {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    public static void deleteStore(){
        if (pizzaStores.isEmpty()){
            System.out.println("There are no available stores!");
            return;
        }

        System.out.println("Choose the store to be deleted:");
        for (PizzaStore store : pizzaStores){
            System.out.println(store.getStoreId() + ". " + store.getStoreName());
        }

        int selection;
        while (true){
            String input = sc.nextLine();
            try {
                Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Enter the number from 1 to " + pizzaStores.size() + "!");
                continue;
            }
            selection = Integer.parseInt(input);
            if (selection >= 1 && selection <= pizzaStores.size()){
                break;
            }
            else {
                System.out.println("Enter the number from 1 to " + pizzaStores.size() + "!");
            }
        }

        for (PizzaStore store : pizzaStores){
            if (store.getStoreId() == selection){
                pizzaStores.remove(store);
                break;
            }
        }
        System.out.println("The store is successfully deleted!");

        for (int i = 0; i < pizzaStores.size(); i++){
            if (pizzaStores.get(i).getStoreId() != i + 1){
                pizzaStores.get(i).setStoreId(i + 1);
            }
        }
    }

    public static void viewAllStores(){
        if (pizzaStores.isEmpty()){
            System.out.println("There are no available stores!");
            return;
        }

        System.out.println("Select the store to enter:");
        for (PizzaStore store : pizzaStores){
            System.out.println(store.getStoreId() + ". " + store.getStoreName());
        }

        int selection;
        while (true){
            String input = sc.nextLine();
            try {
                Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Enter the number from 1 to " + pizzaStores.size() + "!");
                continue;
            }
            selection = Integer.parseInt(input);
            if (selection >= 1 && selection <= pizzaStores.size()){
                break;
            }
            else {
                System.out.println("Enter the number from 1 to " + pizzaStores.size() + "!");
            }
        }

        new PizzaDashboard().dashboard(pizzaStores.get(selection - 1));
    }

    public static void addNewStore(){
        PizzaStore store = new PizzaStore();
        while (true){
            System.out.print("Enter the name of store: ");
            String name = sc.nextLine();

            boolean flag = true;
            for (PizzaStore element : pizzaStores){
                if (element.getStoreName().equals(name)){
                    System.out.println("The store with this name already exists!");
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }

            store.setStoreName(name);
            break;
        }

        Address address = new Address();
        System.out.println("Give an information about the address:");
        System.out.print("City: ");
        address.setCity(sc.nextLine());
        System.out.print("Street: ");
        address.setStreet(sc.nextLine());
        System.out.print("Door number: ");
        address.setDoorNumber(sc.nextLine());

        store.setStoreLocation(address);
        store.setStoreId(pizzaStores.size() + 1);

        pizzaStores.add(store);
        System.out.println("The store is successfully established!");
    }
}
