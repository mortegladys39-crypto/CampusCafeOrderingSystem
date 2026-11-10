/**
 * Represents a cafe customer.
 *
 * @author Student
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        this("Unknown", false);
    }

    /**
     * Constructor with customer name.
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Constructor with name and student status.
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points.
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds one point for every 50 pesos spent.
     * @param amountSpent amount spent
     */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int)(amountSpent / 50);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}