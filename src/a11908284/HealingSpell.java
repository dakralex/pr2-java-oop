package a11908284;

/**
 * This class represents a spell that does some sort of healing.
 */
public class HealingSpell extends Spell {

    /**
     * Whether health points (true) or mana points (false) are affected.
     */
    private final boolean type;

    /**
     * Whether amount is interpreted as a percentage (true) or as an absolute
     * (false).
     */
    private final boolean percentage;

    /**
     * The healing of the healing spell. This field must not be negative.
     * <p>
     * If this value should be interpreted as a {@link HealingSpell#percentage},
     * it must have a value from 0 to 100.
     */
    private final int amount;

    /**
     * Create an healing spell instance.
     *
     * @param name        name of the attacking spell
     * @param manaCost    cost of mana points to use the attacking spell
     * @param levelNeeded the level needed to use the attacking spell
     * @param type        whether HP (true) or MP (false) are affected
     * @param percentage  whether amount is a percentage or not
     * @param amount      the amount of the attacking spell
     */
    public HealingSpell(String name, int manaCost, MagicLevel levelNeeded, boolean type, boolean percentage, int amount) {
        super(name, manaCost, levelNeeded);

        if (amount < 0) {
            throw new IllegalArgumentException("The healing of the healing spell must not be negative.");
        }

        if (percentage && amount > 100) {
            throw new IllegalArgumentException("The relative healing of the healing spell must be a percentage (value from 0 to 100).");
        }

        this.type = type;
        this.percentage = percentage;
        this.amount = amount;
    }

    /**
     * Performs the healing spell on the specified target.
     *
     * @param target target of the spell
     */
    @Override
    public void doEffect(MagicEffectRealization target) {
        if (type) {
            if (percentage) {
                target.healPercent(amount);
            } else {
                target.heal(amount);
            }
        } else {
            if (percentage) {
                target.enforceMagicPercent(amount);
            } else {
                target.enforceMagic(amount);
            }
        }
    }

    /**
     * Returns the additional spell characteristics in the format:
     * <p>
     * "; -%d%s %s" with the arguments:
     * <ul>
     *  <li>{@link HealingSpell#amount}</li>
     *  <li>{@link HealingSpell#percentage}: "%" or ""</li>
     *  <li>{@link HealingSpell#type}: "HP" or "MP"</li>
     * </ul>
     *
     * @return additional string representation of the healing spell
     */
    @Override
    public String additionalOutputString() {
        String typeString = type ? "HP" : "MP";
        String percentageString = percentage ? " %" : "";

        return "; +%d%s %s"
                .formatted(amount, percentageString, typeString);
    }
}