package a11908284;

/**
 * The class that represents a mana potion which increases the mana points of
 * its consumer.
 */
public class ManaPotion extends Potion {

    /**
     * The mana points the potion will bring. This field must not be negative.
     */
    private final int mana;

    /**
     * Creates an ManaPotion instance.
     *
     * @param name   name of the mana potion
     * @param usages number of usages that are remaining
     * @param price  price of the mana potion
     * @param weight weight of the mana potion
     * @param mana   mana the potion will bring
     */
    public ManaPotion(String name, int usages, int price, int weight, int mana) {
        super(name, usages, price, weight);

        if (mana < 0) {
            throw new IllegalArgumentException("The mana of the mana potion must not be negative.");
        }

        this.mana = mana;
    }

    /**
     * Uses the potion on the specified target.
     *
     * @param target target of the item's effects
     */
    @Override
    public void useOn(MagicEffectRealization target) {
        if (tryUsage()) {
            enforceMagic(mana);
        }
    }

    /**
     * Returns a string representation of the mana potion in the format:
     * <p>
     * "; +%dMP" with the arguments:
     * <ul>
     *  <li>{@link ManaPotion#mana} (with sign before)</li>
     * </ul>
     *
     * @return additional string representation of the mana potion
     */
    @Override
    public String additionalOutputString() {
        return "; +%dMP".formatted(mana);
    }
}