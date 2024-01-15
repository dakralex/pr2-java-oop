package a11908284;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that represents a concoction potion that affects health and mana on
 * a target at the same time and additionally casts any number of spells on
 * them.
 */
public class Concoction extends Potion {

    /**
     * The change of health points on the target.
     */
    private final int health;

    /**
     * The change of mana points on the target.
     */
    private final int mana;

    /**
     * The spells that are cast when this potion is consumed. This field must
     * not be null.
     */
    private final List<Spell> spells;

    /**
     * Creates a concoction instance.
     * <p>
     * It is not allowed that health and mana points are both 0 and the spells
     * list is empty.
     *
     * @param name   name of the magic item
     * @param usages number of usages that are remaining
     * @param price  price of the magic item
     * @param weight weight of the magic item
     * @param health change of health on target
     * @param mana   change of mana on target
     * @param spells list of spells that are cast when consuming the concoction
     * @throws IllegalArgumentException if name is null or empty, usages, price
     *                                  or weight is negative, or spells is
     *                                  null
     */
    public Concoction(
            String name,
            int usages,
            int price,
            int weight,
            int health,
            int mana,
            List<Spell> spells
    ) {
        super(name, usages, price, weight);

        if (spells == null) {
            throw new IllegalArgumentException("The list of spells of a concoction potion must not be null.");
        }

        if (health == 0 && mana == 0 && spells.isEmpty()) {
            throw new IllegalArgumentException("The health points, mana points and spells list of the concoction potion must not be zero or empty at the same time.");
        }

        this.health = health;
        this.mana = mana;
        this.spells = new ArrayList<>(spells);
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
            throw new IllegalArgumentException("Target of the concoction potion must not be null.");
        }

        if (!tryUsage()) {
            return;
        }

        if (health >= 0) {
            heal(health);
        } else {
            takeDamage(health);
        }

        if (mana >= 0) {
            enforceMagic(mana);
        } else {
            weakenMagic(mana);
        }

        spells.forEach(spell -> spell.cast(this, target));
    }

    /**
     * Returns a string representation of the concoction in the format:
     * <p>
     * "; %s%d HP; %s%d MP; cast %s " with the arguments:
     * <ul>
     *  <li>{@link Concoction#health} (with sign before)</li>
     *  <li>{@link Concoction#mana} (with sign before)</li>
     *  <li>{@link Concoction#spells} (default toString() output)</li>
     * </ul>
     *
     * @return additional string representation of the concoction
     */
    @Override
    public String additionalOutputString() {
        String healthSign = health >= 0 ? "+" : "-";
        String manaSign = mana >= 0 ? "+" : "-";

        String healthString = health == 0 ? "" : " %s%d HP;".formatted(healthSign, health);
        String manaString = mana == 0 ? "" : " %s%d MP;".formatted(manaSign, mana);
        String spellsString = spells.isEmpty() ? "" : " cast %s".formatted(spells);

        return ";%s%s%s".formatted(healthString, manaString, spellsString);
    }
}