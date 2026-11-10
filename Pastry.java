/**
 * Represents a baked pastry.
 *
 * @author Student
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    /**
     * Default constructor.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Parameterized constructor.
     */
    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes pastry price.
     * @return final price
     */
    @Override
    public double computePrice() {
        if (warmed) {
            return basePrice + 10;
        }
        return basePrice;
    }

    /**
     * Returns pastry description.
     * @return description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}