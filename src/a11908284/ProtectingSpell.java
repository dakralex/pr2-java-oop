package a11908284;

import java.util.HashSet;
import java.util.Set;

/**
 * The class that represents a protecting spell, which grants protection against
 * a number of specific attacking spells.
 */
public class ProtectingSpell extends Spell {

    /**
     * The set of attacking spells that the target is protected from. This field
     * must not be null or empty.
     */
    private final Set<AttackingSpell> attacks;

    /**
     * Create an protecting spell instance.
     *
     * @param name        name of the protecting spell
     * @param manaCost    cost of mana points to use the protecting spell
     * @param levelNeeded the level needed to use the protecting spell
     * @param attacks     set of attacking spells that the target is protected
     *                    from
     * @throws IllegalArgumentException if name is null or empty, manaCost is
     *                                  negative, or levelNeeded or attacks is
     *                                  null
     */
    public ProtectingSpell(String name, int manaCost, MagicLevel levelNeeded, Set<AttackingSpell> attacks) {
        super(name, manaCost, levelNeeded);

        if (attacks == null || attacks.isEmpty()) {
            throw new IllegalArgumentException("The set of attacks of the protecting spell must not be null or empty.");
        }

        this.attacks = new HashSet<>(attacks);
    }

    /**
     * Performs protection from the specified attacking spells
     *
     * @param target target of the spell
     * @throws IllegalArgumentException if target is null
     */
    @Override
    public void doEffect(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("target must not be null.");
        }

        target.setProtection(attacks);
    }

    /**
     * Returns the additional spell characteristics in the format:
     * <p>
     * "; protects against %s" with the arguments:
     * <ul>
     *  <li>{@link ProtectingSpell#attacks} (default toString() output)</li>
     * </ul>
     *
     * @return additional string representation of the protecting spell
     */
    @Override
    public String additionalOutputString() {
        return "; protects against %s".formatted(attacks);
    }
}