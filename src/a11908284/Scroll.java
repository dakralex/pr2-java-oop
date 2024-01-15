package a11908284;

/**
 * The class that represents a scroll that can be read by someone. The scroll
 * provides the mana, magic level and capabilities to use any spell.
 */
public class Scroll extends MagicItem {

    /**
     * The spell that is written on the scroll and can be cast. This field must
     * not be null.
     */
    private final Spell spell;

    /**
     * Creates a scroll instance.
     *
     * @param name   name of the scroll
     * @param usages number of usages that are remaining
     * @param price  price of the scroll
     * @param weight weight of the scroll
     * @param spell  the spell that is written on the scroll
     * @throws IllegalArgumentException if name is null or empty, usages, price,
     *                                  or weight is negative or spell is null
     */
    public Scroll(String name, int usages, int price, int weight, Spell spell) {
        super(name, usages, price, weight);

        if (spell == null) {
            throw new IllegalArgumentException("The spell of the scroll must not be null.");
        }

        this.spell = spell;
    }

    /**
     * If usages is greater than 0 reduce usages by 1 (tryUsage method) and cast
     * the spell using this as magic source and parameter target as target
     *
     * @param target target of the spell cast by reading the scroll
     * @throws IllegalArgumentException if target is null
     */
    @Override
    public void useOn(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("Target of scroll must not be null.");
        }

        if (tryUsage()) {
            spell.cast(this, target);
        }
    }

    /**
     * Returns a string representation of the scroll in the format:
     * <p>
     * "; casts %s" with the arguments:
     * <ul>
     *  <li>{@link Scroll#spell}</li>
     * </ul>
     *
     * @return additional string representation of the scroll
     */
    @Override
    public String additionalOutputString() {
        return "; casts %s".formatted(spell);
    }
}