package Switch;

import java.util.ArrayList;
import java.util.Scanner;

public class Ordering {

    static final int PIZZA = 250;
    static final int BURGER = 120;
    static final int SANDWICH = 100;
    static final int COFFEE = 80;
    static final int ICECREAM=70;
    static final int BRIYANI=399;
    static final int JUICE=100;
    static final int FRIES = 90; 
    static final int PASTA = 180;
    static final int SOFTDRINK = 50;

    static double totalBill = 0;
    static String choice;

    static ArrayList<String> items = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      WELCOME TO FOOD HUB");
        System.out.println("=================================");

        do {

            displayMenu();

            System.out.print("Enter item number: ");
            int order = sc.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid Quantity!");
                continue;
            }

            switch (order) {

            case 1 -> addItem("Pizza", quantity, PIZZA);

            case 2 -> addItem("Burger", quantity, BURGER);

            case 3 -> addItem("Sandwich", quantity, SANDWICH);

            case 4 -> addItem("Coffee", quantity, COFFEE);

            case 5 -> addItem("Ice Cream", quantity, ICECREAM);

            case 6 -> addItem("Briyani", quantity, BRIYANI);

            case 7 -> addItem("Juice", quantity, JUICE);

            case 8 -> addItem("Fries", quantity, FRIES);

            case 9 -> addItem("Pasta", quantity, PASTA);

            case 10 -> addItem("Soft Drink", quantity, SOFTDRINK);

            default -> {
                System.out.println("Invalid Selection!");
                continue;
            }
        }
        System.out.print("Do you want to order more? (Y/N): ");
        choice = sc.next();

        } while (choice.equalsIgnoreCase("Y"));

        printBill();

        sc.close();
    }

    static void displayMenu() {

        System.out.println("\n=========== MENU ===========");
        System.out.println("1. Pizza        ₹" + PIZZA);
        System.out.println("2. Burger       ₹" + BURGER);
        System.out.println("3. Sandwich     ₹" + SANDWICH);
        System.out.println("4. Coffee       ₹" + COFFEE);
        System.out.println("5. Ice Cream    ₹" + ICECREAM);
        System.out.println("6. Briyani      ₹" + BRIYANI);
        System.out.println("7. Juice        ₹" + JUICE);
        System.out.println("8. Fries        ₹" + FRIES);
        System.out.println("9. Pasta        ₹" + PASTA);
        System.out.println("10. Soft Drink  ₹" + SOFTDRINK);
        System.out.println("============================");
    }

    static void addItem(String itemName, int quantity, int unitPrice) {

        double itemTotal = quantity * unitPrice;

        items.add(itemName);
        quantities.add(quantity);
        prices.add(itemTotal);

        totalBill += itemTotal;

        System.out.println(quantity + " " + itemName + "(s) added.");
        System.out.println("Item Total = ₹" + itemTotal);
    }

    static void printBill() {

        System.out.println("\n====================================");
        System.out.println("            FINAL BILL");
        System.out.println("====================================");

        System.out.printf("%-15s %-10s %-10s%n",
                "Item", "Qty", "Price");

        System.out.println("------------------------------------");

        for (int i = 0; i < items.size(); i++) {

            System.out.printf("%-15s %-10d ₹%-10.2f%n",
                    items.get(i),
                    quantities.get(i),
                    prices.get(i));
        }

        System.out.println("------------------------------------");

        double gst = totalBill * 0.05;
        double grandTotal = totalBill + gst;

        System.out.printf("Subtotal      : ₹%.2f%n", totalBill);
        System.out.printf("GST (5%%)      : ₹%.2f%n", gst);
        System.out.printf("Grand Total   : ₹%.2f%n", grandTotal);

        System.out.println("====================================");
        System.out.println("Thank You! Visit Again.");
        System.out.println("====================================");
    }
}