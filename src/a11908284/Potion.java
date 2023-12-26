package a11908284;

/**
 * A potion has a specific magic effect on its consumer
 */
public abstract class Potion extends MagicItem {
    /**
     * @param name   name
     * @param usages number of usages still left
     * @param price  price
     * @param weight weight
     */
    protected Potion(String name, int usages, int price, int weight) {
        super(name, usages, price, weight);
        // TODO Unimplemented
    }

    /**
     * Delegates to method call useOn(drinker)
     *
     * @param drinker the consumer of the potion
     */
    public void drink(Wizard drinker) {
        // TODO Unimplemented
    }

    /**
     * returns "gulp" if usages is equal to 1, "gulps" otherwise
     *
     * @return "gulp" or "gulps" depending on number of usages left
     */
    @Override
    public String usageString() {
        // TODO Unimplemented
        return "";
    }
}