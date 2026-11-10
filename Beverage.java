/**
 * Represents a beverage sold at the campus cafe.
 *
 * @author Student
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Default constructor.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Parameterized constructor.
     */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes price based on beverage size.
     * @return final price
     */
    @Override
    public double computePrice() {
        if (size.equals("S")) {
            return basePrice;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice + 25;
        }
    }

    /**
     * Returns beverage description.
     * @return description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size != null &&
            (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Invalid size. Use S, M, or L.");
        }
    }
}