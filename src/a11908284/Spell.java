package a11908284;

/**
 * The abstract class that generates the magic effect on a target.
 */
public abstract class Spell {
    /**
     * The name of the spell. This field must not be empty.
     */
    private final String name;

    /**
     * The amount of mana points are needed for the spell. This field must not
     * be negative.
     */
    private final int manaCost;

    /**
     * The magic level needed for the spell. This field must not be null.
     */
    private final MagicLevel levelNeeded;

    /**
     * Create a abstract Spell instance.
     *
     * @param name        name of the attacking spell
     * @param manaCost    cost of mana points to use the attacking spell
     * @param levelNeeded the level needed to use the attacking spell
     * @throws IllegalArgumentException if name is null or empty, manaCost is
     *                                  negative or levelNeeded is null
     */
    protected Spell(String name, int manaCost, MagicLevel levelNeeded) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of a spell must not be null or empty.");
        }

        if (manaCost < 0) {
            throw new IllegalArgumentException("The mana cost of a spell must not be negative.");
        }

        if (levelNeeded == null) {
            throw new IllegalArgumentException("The minimum magic level of a spell must not be null.");
        }

        this.name = name;
        this.manaCost = manaCost;
        this.levelNeeded = levelNeeded;
    }

    /**
     * Perform a cast between a source and a target.
     *
     * @param source caster of the spell
     * @param target target of the spell
     * @throws IllegalArgumentException if source or target is null
     */
    public void cast(MagicSource source, MagicEffectRealization target) {
        if (source == null) {
            throw new IllegalArgumentException("Source of the spell must not be null.");
        }

        if (target == null) {
            throw new IllegalArgumentException("Target of the spell must not be null.");
        }

        boolean satisfyCriteria = source.provideMana(levelNeeded, manaCost);

        if (satisfyCriteria) {
            doEffect(target);
        }
    }

    /**
     * Performs the spell on the specified target.
     *
     * @param target target of the spell
     */
    public abstract void doEffect(MagicEffectRealization target);

    /**
     * Returns additional output for the spell.
     *
     * @return always an empty string ("")
     */
    public String additionalOutputString() {
        return "";
    }

    /**
     * Returns a string representation of the spell in the format:
     * <p>
     * [%s(%s): %d mana%s] with the arguments:
     * <ul>
     *  <li>{@link Spell#name}</li>
     *  <li>{@link Spell#levelNeeded}</li>
     *  <li>{@link Spell#manaCost}</li>
     *  <li>{@link Spell#additionalOutputString()}</li>
     * </ul>
     *
     * @return string representation of the spell
     */
    @Override
    public String toString() {
        String additionalOutput = additionalOutputString();

        return "[%s(%s): %d mana%s]"
                .formatted(name, levelNeeded, manaCost, additionalOutput);
    }
}