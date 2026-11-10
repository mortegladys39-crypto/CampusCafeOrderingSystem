/**
 * Represents a rice meal sold at the campus cafe.
 *
 * @author Student
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Parameterized constructor.
     */
    public Meal(String name, double basePrice,
                String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes meal price.
     * @return final price
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += 12 * extraSides;
        return price;
    }

    /**
     * Returns meal description.
     * @return description
     */
    @Override
    public String getDescription() {
        return super.getDescription()
                + (upsized ? " Upsized" : " Regular")
                + ", " + extraSides + " sides";
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}