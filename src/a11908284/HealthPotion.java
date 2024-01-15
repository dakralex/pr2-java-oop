package a11908284;

/**
 * The class that represents a healing potion which increases the health points
 * of its consumer.
 */
public class HealthPotion extends Potion {

    /**
     * The health points the potion will bring. This field must not be
     * negative.
     */
    private final int health;

    /**
     * Creates an HealthPotion instance.
     *
     * @param name   name of the health potion
     * @param usages number of usages that are remaining
     * @param price  price of the health potion
     * @param weight weight of the health potion
     * @param health health the potion will bring
     * @throws IllegalArgumentException if name is null or empty, or usages,
     *                                  price, weight or health are negative
     */
    public HealthPotion(String name, int usages, int price, int weight, int health) {
        super(name, usages, price, weight);

        if (health < 0) {
            throw new IllegalArgumentException("The health of the health potion must not be negative.");
        }

        this.health = health;
    }

    /**
     * Uses the potion on the specified target.
     *
     * @param target target of the item's effects
     * @throws IllegalArgumentException if target is null
     */
    @Override
    public void useOn(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("Target of health potion must not be null.");
        }

        if (tryUsage()) {
            heal(health);
        }
    }

    /**
     * Returns a string representation of the health potion in the format:
     * <p>
     * "; +%dHP" with the arguments:
     * <ul>
     *  <li>{@link HealthPotion#health} (with sign before)</li>
     * </ul>
     *
     * @return additional string representation of the health potion
     */
    @Override
    public String additionalOutputString() {
        return "; +%dHP".formatted(health);
    }
}