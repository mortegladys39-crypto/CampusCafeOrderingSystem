/**
 * Main application for the Campus Cafe Ordering System.
 *
 * @author Student
 * @version 1.0
 */
public class CafeApp {

    /**
     * Starts the cafe ordering program.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Create customers using different constructors.
        Customer customer1 =
                new Customer("Janelit Cabus", true);

        Customer customer2 =
                new Customer("Gladys Morte");

        // Create menu items using default constructors.
        Beverage drink1 = new Beverage();
        drink1.setName("Hot Chocolate");
        drink1.setBasePrice(80);
        drink1.setItemCode("B-02");
        drink1.setSize("M");

        Pastry pastry1 = new Pastry();
        pastry1.setName("Ensaymada");
        pastry1.setBasePrice(55);
        pastry1.setItemCode("P-01");
        pastry1.setWarmed(true);

        Meal meal1 = new Meal();
        meal1.setName("Chicken Adobo");
        meal1.setBasePrice(110);
        meal1.setItemCode("M-01");
        meal1.setUpsized(true);
        meal1.setExtraSides(1);

        // Create items using parameterized constructors.
        Beverage drink2 =
                new Beverage("Iced Latte", 95, "B-01", "L");

        Pastry pastry2 =
                new Pastry("Cookie", 40, "P-02", false);

        Meal meal2 =
                new Meal("Beef Tapa", 130, "M-02", false, 0);

        // Create first order.
        Order order1 = new Order("1001", customer1);

        order1.addItem(drink2);
        order1.addItem(pastry1);
        order1.addItem(meal1);

        // Try adding a fourth item.
        order1.addItem(pastry2);

        order1.printReceipt();

        // Demonstrate invalid setter input.
        drink1.setBasePrice(-5);
        drink1.setBasePrice(80);

        // Create second order.
        Order order2 = new Order("1002", customer2);

        order2.addItem(drink1);
        order2.addItem(meal2);

        order2.printReceipt();

        // Demonstrate voucher calculation.
        System.out.printf("Total after 20-peso voucher: %.2f%n",
                order2.computeTotal(20));
    }
}