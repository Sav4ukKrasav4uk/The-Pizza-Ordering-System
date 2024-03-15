import java.util.Scanner;

public class PizzaDashboard{
    private static final Scanner sc = new Scanner(System.in);
    public void dashboard(PizzaStore store){
        System.out.println("Welcome to the " + store.getStoreName() + "!");
        while (true){
            System.out.println("Choose the user:\n1. Admin\n2. Consumer\n3. Exit");

            int userSelect;
            while (true){
                String input = sc.nextLine();
                try {
                    Integer.parseInt(input);
                }
                catch(Exception e){
                    System.out.println("Enter 1-3!");
                    continue;
                }
                userSelect = Integer.parseInt(input);
                if (userSelect != 1 && userSelect != 2 && userSelect != 3){
                    System.out.println("Enter 1-3!");
                }
                else {
                    break;
                }
            }

            if (userSelect == 1){
                new Admin().commands(store);
            }
            else if (userSelect == 2){
                new Customer().commands(store);
            }
            else {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}