package a11908284;

/**
 * The abstract class that represents a potion that has a magic effect on its
 * consumer.
 */
public abstract class Potion extends MagicItem {

    /**
     * Creates a Potion instance.
     *
     * @param name   name of the magic item
     * @param usages number of usages that are remaining
     * @param price  price of the magic item
     * @param weight weight of the magic item
     * @throws IllegalArgumentException if name is null or empty, or usages,
     *                                  price, or weight is negative
     */
    protected Potion(String name, int usages, int price, int weight) {
        super(name, usages, price, weight);
    }

    /**
     * Uses the potion on the specified drinker.
     *
     * @param drinker the target of the potion's effects
     * @throws IllegalArgumentException if drinker is null
     */
    public void drink(Wizard drinker) {
        if (drinker == null) {
            throw new IllegalArgumentException("Drinker of potion must not be null.");
        }

        useOn(drinker);
    }

    /**
     * Returns the suffix of the potion usages
     *
     * @return if the remaining usages is equal to 1 then "gulp", else "gulps"
     */
    @Override
    public String usageString() {
        if (getUsages() == 1) {
            return "gulp";
        }

        return "gulps";
    }
}