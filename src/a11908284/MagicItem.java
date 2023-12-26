package a11908284;

/**
 * MagicItems are items that can cause magic effects on other objects. So they are a source
 * of magic. As items they can be traded and they also can be the target of magic effects
 */
public abstract class MagicItem implements Tradeable, MagicEffectRealization, MagicSource {
    /**
     * Must not be null or empty
     */
    private String name;
    /**
     * Number of usages remaining; must not be negative
     */
    private int usages;
    /**
     * Must not be negative
     */
    private int price;
    /**
     * must not be negative
     */
    private int weight;

    /**
     * @param name   name
     * @param usages number of usages still left
     * @param price  price
     * @param weight weight
     */
    protected MagicItem(String name, int usages, int price, int weight) {
        // TODO Unimplemented
    }

    /**
     * Returns value of usages (for access from deriving classes)
     *
     * @return value of instance variable usages
     */
    public int getUsages() {
        // TODO Unimplemented
        return 0;
    }

    /**
     * If usages > 0 reduce usage by 1 and return true, otherwise return false
     *
     * @return returns true if usage is still possible
     */
    public boolean tryUsage() {
        // TODO Unimplemented
        return false;
    }

    /**
     * Returns "use" if usages is equal to 1, "uses" otherwise
     *
     * @return "use" or "uses" depending on the value of usages
     */
    public String usageString() {
        // TODO Unimplemented
        return "";
    }

    /**
     * returns empty string. Is overridden in deriving classes as needed
     *
     * @return ""
     */
    public String additionalOutputString() {
        // TODO Unimplemented
        return "";
    }

    /**
     * Formats this object according to
     * "['name'; 'weight' g; 'price' 'currencyString'; 'usages' 'usageString''additionalOutputString']"
     * 'currencyString' is "Knut" if price is 1, "Knuts" otherwise
     * e.g. (when additionalOutput() returns an empty string)
     * "[Accio Scroll; 1 g; 1 Knut; 5 uses]" or "[Alohomora Scroll; 1 g; 10 Knuts; 1 use]"
     *
     * @return "['name'; 'weight' g; 'price' 'currencyString'; 'usages' 'usageString''additionalOutputString']"
     */
    @Override
    public String toString() {
        // TODO Unimplemented
        return "";
    }

    //Tradeable Interface:

    /**
     * Returns price of the object
     *
     * @return value of instance variable price
     */
    @Override
    public int getPrice() {
        // TODO Unimplemented
        return 0;
    }

    /**
     * Returns weight of the object
     *
     * @return value of instance variable weight
     */
    @Override
    public int getWeight() {
        // TODO Unimplemented
        return 0;
    }

    //MagicSource Interface:

    /**
     * Always returns true; no Exceptions needed
     */
    @Override
    public boolean provideMana(MagicLevel levelNeeded, int amount) {
        // TODO Unimplemented
        return false;
    }

    //MagicEffectRealization Interface:

    /**
     * Reduce usages to usages*(1-percentage/100.)
     */
    @Override
    public void takeDamagePercent(int percentage) {
        // TODO Unimplemented
    }
}