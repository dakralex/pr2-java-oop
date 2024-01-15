package a11908284;

import java.util.Set;

/**
 * This class represents a spell that does some sort of damage.
 */
public class AttackingSpell extends Spell {

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
     * The damage of the attacking spell. This field must not be negative.
     * <p>
     * If this value should be interpreted as a
     * {@link AttackingSpell#percentage}, it must have a value from 0 to 100.
     */
    private final int amount;

    /**
     * Create an attacking instance.
     *
     * @param name        name of the attacking spell
     * @param manaCost    cost of mana points to use the attacking spell
     * @param levelNeeded the level needed to use the attacking spell
     * @param type        whether HP (true) or MP (false) are affected
     * @param percentage  whether amount is a percentage or not
     * @param amount      the amount of the attacking spell
     * @throws IllegalArgumentException if name is null or empty, levelNeeded is
     *                                  null or manaCost or amount are negative
     */
    public AttackingSpell(
            String name,
            int manaCost,
            MagicLevel levelNeeded,
            boolean type,
            boolean percentage,
            int amount
    ) {
        super(name, manaCost, levelNeeded);

        if (amount < 0) {
            throw new IllegalArgumentException("The damage of the attacking spell must not be negative.");
        }

        if (percentage && amount > 100) {
            throw new IllegalArgumentException("The relative damage of the attacking spell must be a percentage (value from 0 to 100).");
        }

        this.type = type;
        this.percentage = percentage;
        this.amount = amount;
    }

    /**
     * Performs the attacking spell on the specified target.
     * <p>
     * This method will remove the protection of the spell without any other
     * effect if the target had protection against the spell beforehand. Only at
     * the second invocation it will do its inherent effect.
     *
     * @param target target of the spell
     * @throws IllegalArgumentException if target is null
     */
    @Override
    public void doEffect(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("Target of effect must not be null.");
        }

        if (target.isProtected(this)) {
            target.removeProtection(Set.of(this));
            return;
        }

        if (type) {
            if (percentage) {
                target.takeDamagePercent(amount);
            } else {
                target.takeDamage(amount);
            }
        } else {
            if (percentage) {
                target.weakenMagicPercent(amount);
            } else {
                target.weakenMagic(amount);
            }
        }
    }

    /**
     * Returns the additional spell characteristics in the format:
     * <p>
     * "; -%d%s %s" with the arguments:
     * <ul>
     *  <li>{@link AttackingSpell#amount}</li>
     *  <li>{@link AttackingSpell#percentage}: "%" or ""</li>
     *  <li>{@link AttackingSpell#type}: "HP" or "MP"</li>
     * </ul>
     *
     * @return additional string representation of the attacking spell
     */
    @Override
    public String additionalOutputString() {
        String typeString = type ? "HP" : "MP";
        String percentageString = percentage ? " %" : "";

        return "; -%d%s %s"
                .formatted(amount, percentageString, typeString);
    }
}