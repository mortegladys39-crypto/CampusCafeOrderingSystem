/**
 * Represents a customer's cafe order.
 *
 * @author Student
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an order.
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds an item to the order.
     * @param item menu item
     * @return true if added successfully
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            return false;
        }

        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getDescription() + ".");
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    /**
     * Computes subtotal.
     * @return subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Computes total with student discount.
     * @return total
     */
    public double computeTotal() {
        double total = computeSubtotal();

        if (customer.isStudent()) {
            total = total - (total * 0.10);
        }

        return total;
    }

    /**
     * Computes total after voucher deduction.
     * @param voucher voucher amount
     * @return final total
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /**
     * Prints order receipt and updates loyalty points.
     */
    public void printReceipt() {
        double subtotal = computeSubtotal();
        double total = computeTotal();
        double discount = customer.isStudent()
                ? subtotal * 0.10 : 0;

        System.out.println("\nOrder #" + orderId
                + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) {
            System.out.printf("%s ........ %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%s ........ %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%s ........ %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Discount: -%.2f%n", discount);
        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(subtotal);

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }
}