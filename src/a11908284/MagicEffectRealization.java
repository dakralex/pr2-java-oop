package a11908284;

import java.util.Set;

/**
 * The interface that adds the ability to have various magic effects.
 */
public interface MagicEffectRealization {
    /**
     * Reduces the health points by the specified, absolute amount of damage.
     * This method ensures that the health points will never drop below zero.
     *
     * @param amount absolute amount of damage
     * @throws IllegalArgumentException if specified damage amount is negative
     */
    default void takeDamage(int amount) {
        // Do nothing, we don't have any health points
    }

    /**
     * Reduces the health points by the specified, relative amount of damage as
     * a percentage of the health points of the object. The calculation are done
     * with the double precision type. This method ensures that the health
     * points will never drop below zero.
     *
     * @param percentage relative amount of damage (value between [0;100])
     * @throws IllegalArgumentException if the specified percentage does not lie
     *                                  somewhere between 0 and 100 (inclusive)
     */
    default void takeDamagePercent(int percentage) {
        // Do nothing, we don't have any health points
    }

    /**
     * Reduces the mana points by the specified, absolute amount of damage. This
     * method ensures that the mana points will never drop below zero.
     *
     * @param amount absolute amount of damage
     * @throws IllegalArgumentException if specified damage amount is negative
     */
    default void weakenMagic(int amount) {
        // Do nothing, we don't have any mana points
    }

    /**
     * Reduces the mana points by the specified, relative amount of damage as a
     * percentage of the mana points of the object. The calculation are done
     * with the double precision type. This method ensures that the mana points
     * will never drop below zero.
     *
     * @param percentage relative amount of damage (value between [0;100])
     * @throws IllegalArgumentException if the specified percentage does not lie
     *                                  somewhere between 0 and 100 (inclusive)
     */
    default void weakenMagicPercent(int percentage) {
        // Do nothing, we don't have any mana points
    }

    /**
     * Increases the health points by the specified, absolute amount of
     * healing.
     *
     * @param amount absolute amount of healing
     * @throws IllegalArgumentException if specified healing amount is negative
     */
    default void heal(int amount) {
        // Do nothing, we don't have any health points
    }

    /**
     * Increases the health points by the specified, relative amount of healing
     * as a percentage of the health points of the object. The calculation are
     * done with the double precision type.
     *
     * @param percentage relative amount of healing (value between [0;100])
     * @throws IllegalArgumentException if the specified percentage does not lie
     *                                  somewhere between 0 and 100 (inclusive)
     */
    default void healPercent(int percentage) {
        // Do nothing, we don't have any health points
    }

    /**
     * Increases the mana points by the specified, absolute amount of healing.
     *
     * @param amount absolute amount of healing
     * @throws IllegalArgumentException if specified healing amount is negative
     */
    default void enforceMagic(int amount) {
        // Do nothing, we don't have any mana points
    }

    /**
     * Increases the mana points by the specified, relative amount of healing as
     * a percentage of the mana points of the object. The calculation are done
     * with the double precision type.
     *
     * @param percentage relative amount of healing (value between [0;100])
     * @throws IllegalArgumentException if the specified percentage does not lie
     *                                  somewhere between 0 and 100 (inclusive)
     */
    default void enforceMagicPercent(int percentage) {
        // Do nothing, we don't have any mana points
    }

    /**
     * Checks whether the object is protected against the specified spell.
     *
     * @param spell specific spell to check for
     * @return whether the object is protected against the specified spell
     * @throws IllegalArgumentException if the specified spell is null
     */
    default boolean isProtected(Spell spell) {
        // By default, object isn't protected against any spell
        return false;
    }

    /**
     * Registers the specified spells that the object gains protection from.
     *
     * @param attacks list of spells the object gains protection from
     * @throws IllegalArgumentException if the specified list is null
     */
    default void setProtection(Set<AttackingSpell> attacks) {
        // Do nothing, we don't have a set of protections
    }

    /**
     * Removes the specified spells that the object loses protection for.
     *
     * @param attacks list of spells the object loses protection for
     * @throws IllegalArgumentException if the specified list is null
     */
    default void removeProtection(Set<AttackingSpell> attacks) {
        // Do nothing, we don't have a set of protections
    }
}