import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Customer extends PizzaService{
    private static final Scanner sc = new Scanner(System.in);
    private int customerId;
    private String customerName;
    private Address address;
    private long mobile;
    private String email;
    private double money;
    private Order order = new Order();
    private boolean billPaid = true;

    public void commands(PizzaStore store){
        Customer customer = new Customer();
        customer.setCustomerId(store.getCustomers().size() + 1);

        System.out.print("Enter your name: ");
        customer.setCustomerName(sc.nextLine());

        Address address = new Address();
        System.out.println("Give an information about your address:");
        System.out.print("City: ");
        address.setCity(sc.nextLine());
        System.out.print("Street: ");
        address.setStreet(sc.nextLine());
        System.out.print("Door number: ");
        address.setDoorNumber(sc.nextLine());
        customer.setAddress(address);

        long mobile;
        while (true){
            System.out.print("Enter your mobile number: ");
            String input = sc.nextLine();
            try {
                Long.parseLong(input);
            }
            catch (Exception e){
                System.out.println("Incorrect type!");
                continue;
            }
            mobile = Long.parseLong(input);
            break;
        }
        customer.setMobile(mobile);

        System.out.print("Enter your email: ");
        customer.setEmail(sc.nextLine());

        double money;
        while (true){
            System.out.print("Enter the amount of money you have: ");
            String input = sc.nextLine();
            try {
                Double.parseDouble(input);
            }
            catch (Exception e){
                continue;
            }
            money = Double.parseDouble(input);
            break;
        }
        customer.setMoney(money);

        store.addCustomer(customer);
        System.out.println("Your records are successfully entered!");

        while (true){
            System.out.println("<CUSTOMER " + customer.getCustomerName() + ">");
            System.out.println("Choose the option:");
            System.out.println("1. Order pizza");
            System.out.println("2. Pay bill");
            System.out.println("3. View your order");
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
                if (store.getCustomers().get(store.getCustomers().size() - 1).isBillPaid()){
                    System.out.println("Exiting...");
                    break;
                }
                else {
                    System.out.println("Where are you going without paying the bill? Huh?");
                    continue;
                }
            }

            switch (selection){
                case 1: orderPizza(store); break;
                case 2:
                    if (payBill(store)){
                        break;
                    }
                    else {
                        return;
                    }
                case 3: viewOrder(store); break;
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

    public void orderPizza(PizzaStore store){
        System.out.println("Available pizzas:");
        super.viewAllPizza(store);

        if (store.getPizzas().isEmpty()){
            return;
        }

        while (true){
            System.out.print("Enter the pizza name to place your order: ");
            String name = sc.nextLine();

            int pos = -1;
            for (Pizza element : store.getPizzas()){
                if (element.getPizzaName().equals(name)){
                    pos = element.getPizzaId();
                    break;
                }
            }

            if (pos == -1){
                System.out.println("Pizza with this name doesn't exist!");
                continue;
            }

            store.getCustomers().get(store.getCustomers().size() - 1).getOrder().addPizza(store.getPizzas().get(pos - 1));
            store.getCustomers().get(store.getCustomers().size() - 1).getOrder().addAmount(store.getPizzas().get(pos - 1).getPrice());
            store.getCustomers().get(store.getCustomers().size() - 1).setBillPaid(false);

            System.out.println("Your order is successfully recorded!");
            break;
        }
    }
    public boolean payBill(PizzaStore store){
        if (store.getCustomers().get(store.getCustomers().size() - 1).getOrder().getPizzas().isEmpty()){
            System.out.println("You haven't done any order. Please, place the order.");
            return true;
        }

        double orderAmount = store.getCustomers().get(store.getCustomers().size() - 1).getOrder().getOrderAmount();
        System.out.println("Your bill amount for your orders is " + orderAmount);

        double money = store.getCustomers().get(store.getCustomers().size() - 1).getMoney();
        if (money >= orderAmount){
            System.out.println("Now you have " + money + " - " + orderAmount + " = " + (money - orderAmount) + " cash");
            money -= orderAmount;
            store.getCustomers().get(store.getCustomers().size() - 1).setMoney(money);
            store.getCustomers().get(store.getCustomers().size() - 1).setBillPaid(true);
            System.out.println("Thank you for visit!");
            // order cleaning
            store.getCustomers().get(store.getCustomers().size() - 1).getOrder().getPizzas().clear();
            store.getCustomers().get(store.getCustomers().size() - 1).getOrder().setOrderAmount(0.0);
            store.getCustomers().get(store.getCustomers().size() - 1).getOrder().setOrderDate(new Date());
            return true;
        }
        else {
            System.out.println("Oops.. You DON'T have enough money(" + store.getCustomers().get(store.getCustomers().size() - 1).getMoney() + ") to pay the bill. Get out from here!");
            return false;
        }
    }
    public void viewOrder(PizzaStore store){
        System.out.print("Order details >>> ");

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(store.getCustomers().get(store.getCustomers().size() - 1).getOrder().getOrderDate());
        System.out.print("Date of creation: " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + ", ");

        System.out.print("Order amount: " + store.getCustomers().get(store.getCustomers().size() - 1).getOrder().getOrderAmount() + "\n");

        System.out.println("Pizzas in this order:");
        super.viewAllPizza(store.getCustomers().get(store.getCustomers().size() - 1).getOrder());
    }

    public Customer(){}
    public Customer(int customerId, String customerName, Address address, long mobile, String email){
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public Address getAddress() {
        return address;
    }
    public long getMobile() {
        return mobile;
    }
    public String getEmail() {
        return email;
    }
    public double getMoney() {
        return money;
    }
    public boolean isBillPaid() {
        return billPaid;
    }
    public Order getOrder() {
        return order;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString(){
        return "Customer[customerId=" + customerId + ", customerName=" + customerName + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", money=" + money + "]";
    }
}
