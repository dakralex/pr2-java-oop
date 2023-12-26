package a11908284;

/**
 * The interface that adds the ability to provide mana points.
 */
@FunctionalInterface
public interface MagicSource {
    /**
     * Checks whether the mana points can be provided to the object with their
     * specific set of properties.
     *
     * @param levelNeeded magic level minimum to provide the mana points
     * @param manaAmount  amount of mana points that will be provided
     * @return whether mana points can be provided
     * @throws IllegalArgumentException when the needed magic level is null
     *                                  and/or the mana amount is negative
     */
    boolean provideMana(MagicLevel levelNeeded, int manaAmount);
}