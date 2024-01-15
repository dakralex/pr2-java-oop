package a11908284;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The class that represents a wizard that is the primary actor in the game. A
 * wizard can use and trade items, provide magic energy, cast spells, and can be
 * affected by various magical effects.
 */
public class Wizard implements MagicSource, Trader, MagicEffectRealization {

    /**
     * The name of the wizard. This field must not be null or empty.
     */
    private final String name;

    /**
     * The magic level the wizard is on. This field must not be null.
     */
    private final MagicLevel level;

    /**
     * The base level of health points, which is used for health calculations.
     * This field must not be negative.
     */
    private final int basicHP;

    /**
     * The health points of the wizard (basicHP by default). This field must not
     * be negative.
     */
    private int HP;

    /**
     * The base level of mana points, which is used for magic calculations. This
     * field must not be less than the mana points required for the
     * {@link Wizard#level} and must not be negative.
     */
    private final int basicMP;

    /**
     * The mana points of the wizard (basicMP by default). This field must not
     * be negative.
     */
    private int MP;

    /**
     * The money the wizard has. This field must not be negative.
     */
    private int money;

    /**
     * The spells the wizard can use. This field must not be null.
     */
    private final Set<Spell> knownSpells;

    /**
     * The spells the wizard is protected from. This field must not be null.
     */
    private final Set<AttackingSpell> protectedFrom;

    /**
     * The capacity of the wizard's inventory. This field must not be negative.
     */
    private final int carryingCapacity;

    /**
     * The inventory of the wizard. This field must not be null. This field's
     * value must neve exceed the {@link Wizard#carryingCapacity}.
     */
    private final Set<Tradeable> inventory;

    /**
     * Creates a wizard instance.
     *
     * @param name             name of the wizard
     * @param level            initial magic level the wizard is on
     * @param healthBase       base level of health points
     * @param health           initial health points of the wizard (healthBase
     *                         by default)
     * @param manaBase         base level of mana points
     * @param mana             initial mana points of the wizard (manaBase by
     *                         default)
     * @param money            initial money the wizard has
     * @param knownSpells      initial spells the wizard can use
     * @param protectedFrom    initial spells the wizard is protected from
     * @param carryingCapacity initial capacity of the wizard's inventory
     * @param inventory        initial inventory of the wizard
     */
    public Wizard(
            String name,
            MagicLevel level,
            int healthBase,
            int health,
            int manaBase,
            int mana,
            int money,
            Set<? extends Spell> knownSpells,
            Set<? extends AttackingSpell> protectedFrom,
            int carryingCapacity,
            Set<? extends Tradeable> inventory
    ) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of the wizard must not be null or empty.");
        }

        if (level == null) {
            throw new IllegalArgumentException("The initial magic level of the wizard must not be null.");
        }

        if (healthBase < 0 || health < 0) {
            throw new IllegalArgumentException("The (base) health points of the wizard must not be negative.");
        }

        if (manaBase < 0 || mana < 0) {
            throw new IllegalArgumentException("The (base) mana points of the wizard must not be negative.");
        }

        int minMana = level.toMana();
        if (manaBase < minMana) {
            throw new IllegalArgumentException("The mana base points of the wizard must not be less then required by their magic level.");
        }

        if (money < 0) {
            throw new IllegalArgumentException("The initial money value of the wizard must not be negative.");
        }

        if (knownSpells == null) {
            throw new IllegalArgumentException("The initial set of known spells of the wizard must not be null.");
        }

        if (protectedFrom == null) {
            throw new IllegalArgumentException("The initial set of spells the wizard is protected from must not be null.");
        }

        if (carryingCapacity < 0) {
            throw new IllegalArgumentException("The initial carrying capacity of the wizard must not be negative.");
        }

        if (inventory == null) {
            throw new IllegalArgumentException("The initial inventory of the wizard must not be null.");
        }

        int totalWeight = inventory.stream().mapToInt(Tradeable::getWeight).sum();
        if (totalWeight > carryingCapacity) {
            throw new IllegalArgumentException("The initial inventory of the wizard must not exceed the carrying capacity.");
        }

        this.name = name;
        this.level = level;
        basicHP = healthBase;
        HP = health;
        basicMP = manaBase;
        MP = mana;
        this.money = money;
        this.knownSpells = new HashSet<>(knownSpells);
        this.protectedFrom = new HashSet<>(protectedFrom);
        this.carryingCapacity = carryingCapacity;
        this.inventory = new HashSet<>(inventory);
    }

    /**
     * Returns whether the wizard is dead.
     *
     * @return whether the wizard is dead
     */
    public boolean isDead() {
        return HP == 0;
    }

    /**
     * Returns the total weight of all the items in the inventory.
     *
     * @return total weight of all items in inventory
     */
    private int inventoryTotalWeight() {
        return inventory.stream().mapToInt(Tradeable::getWeight).sum();
    }

    /**
     * Makes the wizard learn the specified spell.
     *
     * @param spell the spell to learn
     * @return whether the learning was successful
     * @throws IllegalArgumentException if spell is null
     */
    public boolean learn(Spell spell) {
        if (spell == null) {
            throw new IllegalArgumentException("The spell to learn must not be null.");
        }

        if (isDead()) {
            return false;
        }

        return knownSpells.add(spell);
    }

    /**
     * Makes the wizard forget the spell.
     *
     * @param spell the spell to forget
     * @return whether the forgetting was successful
     * @throws IllegalArgumentException if spell is null
     */
    public boolean forget(Spell spell) {
        if (spell == null) {
            throw new IllegalArgumentException("The spell to forget must not be null.");
        }

        if (isDead()) {
            return false;
        }

        return knownSpells.remove(spell);
    }

    /**
     * Makes the wizard cast the specified spell on the specified target.
     *
     * @param spell  spell to be cast
     * @param target target of the spell
     * @return whether the casting was successful
     * @throws IllegalArgumentException if spell or target is null
     */
    public boolean castSpell(Spell spell, MagicEffectRealization target) {
        if (spell == null) {
            throw new IllegalArgumentException("The spell to cast must not be null.");
        }

        if (target == null) {
            throw new IllegalArgumentException("The target of the spell must not be null.");
        }

        if (isDead() || !knownSpells.contains(spell)) {
            return false;
        }

        spell.cast(this, target);
        return true;
    }

    /**
     * Makes the wizard cast a random spell.
     *
     * @param target target of the spell
     * @return whether the casting was successful
     * @throws IllegalArgumentException if target is null
     */
    public boolean castRandomSpell(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("Target on which random spell should be cast must not be null.");
        }

        if (knownSpells.isEmpty()) {
            return false;
        }

        int randomInt = ThreadLocalRandom.current().nextInt(knownSpells.size());

        Optional<Spell> randomSpell = knownSpells.stream().skip(randomInt).findFirst();

        return randomSpell.filter(spell -> castSpell(spell, target)).isPresent();
    }

    /**
     * Makes the wizard use the specified item on the specified target.
     *
     * @param item   item to be used
     * @param target target to use the item on
     * @return whether the usage was successful
     * @throws IllegalArgumentException if item or target is null
     */
    public boolean useItem(Tradeable item, MagicEffectRealization target) {
        if (item == null) {
            throw new IllegalArgumentException("The item to use must not be null.");
        }

        if (target == null) {
            throw new IllegalArgumentException("The target to use the item on must not be null.");
        }

        if (isDead() || !possesses(item)) {
            return false;
        }

        item.useOn(target);
        return true;
    }

    /**
     * Returns a random item from the inventory.
     *
     * @return random item from the inventory or none
     */
    private Optional<Tradeable> getRandomItem() {
        if (inventory.isEmpty()) {
            return Optional.empty();
        }

        int randomInt = ThreadLocalRandom.current().nextInt(inventory.size());

        return inventory.stream().skip(randomInt).findFirst();
    }

    /**
     * Makes the wizard use a random item.
     *
     * @param target target to use the item on
     * @return whether the usage was successful
     * @throws IllegalArgumentException if target is null
     */
    public boolean useRandomItem(MagicEffectRealization target) {
        if (target == null) {
            throw new IllegalArgumentException("Trader to use random item on must not be empty.");
        }

        Optional<Tradeable> randomItem = getRandomItem();

        return randomItem.filter(item -> useItem(item, target)).isPresent();
    }

    /**
     * Makes the wizard sell the item to the specified target.
     *
     * @param item   item to sell
     * @param target target to sell the item to
     * @return whether the selling was successful
     * @throws IllegalArgumentException if item or target is null
     */
    public boolean sellItem(Tradeable item, Trader target) {
        if (item == null) {
            throw new IllegalArgumentException("The item to sell must not be null.");
        }

        if (target == null) {
            throw new IllegalArgumentException("The target to sell the item to must not be null.");
        }

        if (isDead() || !possesses(item)) {
            return false;
        }

        return item.purchase(this, target);
    }

    /**
     * Makes the wizard sell a random item from their inventory.
     *
     * @param target target to sell the item to
     * @return whether the selling was successful
     * @throws IllegalArgumentException if the target is null
     */
    public boolean sellRandomItem(Trader target) {
        if (target == null) {
            throw new IllegalArgumentException("Trader to sell random item to must not be empty.");
        }

        Optional<Tradeable> randomItem = getRandomItem();

        return randomItem.filter(item -> sellItem(item, target)).isPresent();
    }

    /**
     * Makes the wizard provide the mana, if they are not dead and have the
     * sufficient level and mana.
     *
     * @param levelNeeded magic level minimum to provide the mana points
     * @param manaAmount  amount of mana points that will be provided
     * @return whether the mana could be provided
     * @throws IllegalArgumentException when the needed magic level is null
     *                                  and/or the mana amount is negative
     */
    @Override
    public boolean provideMana(MagicLevel levelNeeded, int manaAmount) {
        if (levelNeeded == null) {
            throw new IllegalArgumentException("The needed level must not be null.");
        }

        if (manaAmount < 0) {
            throw new IllegalArgumentException("Mana amount must not be negative.");
        }

        boolean hasLevel = level.compareTo(levelNeeded) >= 0;
        boolean hasMana = MP >= manaAmount;

        if (!isDead() && hasLevel && hasMana) {
            MP -= manaAmount;

            return true;
        }

        return false;
    }

    /**
     * Returns whether the item is in the inventory of the wizard.
     *
     * @param item item to test for
     * @return whether the wizard has the item
     * @throws IllegalArgumentException if the item is null
     */
    @Override
    public boolean possesses(Tradeable item) {
        if (item == null) {
            throw new IllegalArgumentException("The item to check possession for must not be null.");
        }

        return inventory.contains(item);
    }

    /**
     * Returns whether the wizard can afford the specified money amount.
     *
     * @param amount amount to test for
     * @return whether the wizard can afford the specified money amount
     * @throws IllegalArgumentException if amount is negative
     */
    @Override
    public boolean canAfford(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Weight must not be negative.");
        }

        return money >= amount;
    }

    /**
     * Returns whether the wizard has the capacity to carry the specified
     * additional weight.
     *
     * @param weight weight to test for
     * @return whether the wizard can carry the additional weight
     * @throws IllegalArgumentException if weight is negative
     */
    @Override
    public boolean hasCapacity(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must not be negative.");
        }

        return inventoryTotalWeight() + weight <= carryingCapacity;
    }

    /**
     * Makes the wizard pay the specified amount, if they are not dead.
     *
     * @param amount amount to pay
     * @return whether the payment was successful
     * @throws IllegalArgumentException if amount is negative
     */
    @Override
    public boolean pay(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Weight must not be negative.");
        }

        if (!isDead() && canAfford(amount)) {
            money -= amount;

            return true;
        }

        return false;
    }

    /**
     * Makes the wizard earn the specified amount, if they are not dead.
     *
     * @param amount amount to earn
     * @return whether the earning was successful
     * @throws IllegalArgumentException if amount is negative
     */
    @Override
    public boolean earn(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative.");
        }

        if (!isDead()) {
            money += amount;

            return true;
        }

        return false;
    }

    /**
     * Adds the item to the inventory of the wizard, if they can carry the
     * additional item.
     *
     * @param item item to add to the inventory
     * @return whether they can carry the additional item
     * @throws IllegalArgumentException if the item is null
     */
    @Override
    public boolean addToInventory(Tradeable item) {
        if (item == null) {
            throw new IllegalArgumentException("The item to add must not be null.");
        }

        return hasCapacity(item.getWeight()) && inventory.add(item);
    }

    /**
     * Removes the item of the inventory of the wizard, if they had it before.
     *
     * @param item item to remove from the inventory
     * @return whether the item was removed successfully
     * @throws IllegalArgumentException if the item is null
     */
    @Override
    public boolean removeFromInventory(Tradeable item) {
        if (item == null) {
            throw new IllegalArgumentException("The item to remove must not be null.");
        }

        return inventory.contains(item) && inventory.remove(item);
    }

    /**
     * Returns whether the wizard can steal.
     *
     * @return whether the wizard is alive and therefore can steal
     */
    @Override
    public boolean canSteal() {
        return !isDead();
    }

    /**
     * Makes the specified thief steal from the wizard, if possible.
     *
     * @param thief the thief that steals from this object
     * @return whether the stealing was successful
     */
    @Override
    public boolean steal(Trader thief) {
        if (thief == null) {
            throw new IllegalArgumentException("Thief must not be null.");
        }

        if (thief.canSteal()) {
            Optional<Tradeable> optRandomItem = getRandomItem();

            if (optRandomItem.isPresent()) {
                Tradeable randomItem = optRandomItem.get();

                removeFromInventory(randomItem);
                return thief.addToInventory(randomItem);
            }
        }

        return false;
    }

    /**
     * Returns whether the wizard is lootable
     *
     * @return whether the wizard is dead, therefore they can be looted
     */
    @Override
    public boolean isLootable() {
        return isDead();
    }

    /**
     * Returns whether the wizard can loot
     *
     * @return whether the wizard is alive, therefore they can loot
     */
    @Override
    public boolean canLoot() {
        return !isDead();
    }

    /**
     * Makes the specified looter loot the wizard.
     *
     * @param looter the looter that loots from the object
     * @return whether the looting was successful
     */
    @Override
    public boolean loot(Trader looter) {
        if (looter == null) {
            throw new IllegalArgumentException("Looter must not be null.");
        }

        if (looter.canLoot() && isLootable()) {
            boolean anyAdded = inventory.stream()
                    .map(looter::addToInventory).anyMatch(item -> item);

            inventory.clear();

            return anyAdded;
        }

        return false;
    }

    /**
     * Reduces the health points by the specified, absolute amount of damage.
     * This method ensures that the health points will never drop below zero.
     *
     * @param amount absolute amount of damage
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The damage must not be negative.");
        }

        HP = Math.max(HP - amount, 0);
    }

    /**
     * Reduces the health points by the specified, relative amount of damage as
     * a percentage of the health points of the object. The calculation are done
     * with the double precision type. This method ensures that the health
     * points will never drop below zero.
     *
     * @param percentage relative amount of damage (value between [0;100])
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void takeDamagePercent(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("The relative damage must not be less than 0 or greater than 100.");
        }

        HP = (int) Math.max(HP - basicHP * (percentage / 100.0), 0);
    }

    /**
     * Reduces the mana points by the specified, absolute amount of damage. This
     * method ensures that the mana points will never drop below zero.
     *
     * @param amount absolute amount of damage
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void weakenMagic(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The mana decrease must not be negative.");
        }

        MP = Math.max(MP - amount, 0);
    }

    /**
     * Reduces the mana points by the specified, relative amount of damage as a
     * percentage of the mana points of the object. The calculation are done
     * with the double precision type. This method ensures that the mana points
     * will never drop below zero.
     *
     * @param percentage relative amount of damage (value between [0;100])
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void weakenMagicPercent(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("The relative mana decrease must not be less than 0 or greater than 100.");
        }

        MP = (int) Math.max(MP - basicMP * (percentage / 100.0), 0);
    }

    /**
     * Increases the health points by the specified, absolute amount of
     * healing.
     *
     * @param amount absolute amount of healing
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The healing must not be negative.");
        }

        HP += amount;
    }

    /**
     * Increases the health points by the specified, relative amount of healing
     * as a percentage of the health points of the object. The calculation are
     * done with the double precision type.
     *
     * @param percentage relative amount of healing (value between [0;100])
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void healPercent(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("The relative healing must not be less than 0 or greater than 100.");
        }

        HP = (int) Math.max(HP + basicHP * (percentage / 100.0), 0);
    }

    /**
     * Increases the mana points by the specified, absolute amount of healing.
     *
     * @param amount absolute amount of healing
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void enforceMagic(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The mana increase must not be negative.");
        }

        MP += amount;
    }

    /**
     * Increases the mana points by the specified, relative amount of healing as
     * a percentage of the mana points of the object. The calculation are done
     * with the double precision type.
     *
     * @param percentage relative amount of healing (value between [0;100])
     * @throws IllegalArgumentException if the amount does not meet criteria
     */
    @Override
    public void enforceMagicPercent(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("The relative mana increase must not be less than 0 or greater than 100.");
        }

        MP = (int) Math.max(MP + basicMP * (percentage / 100.0), 0);
    }

    /**
     * Checks whether the object is protected against the specified spell.
     *
     * @param spell specific spell to check for
     * @return whether the object is protected against the specified spell
     * @throws IllegalArgumentException if the specified spell is null
     */
    @Override
    public boolean isProtected(Spell spell) {
        if (spell == null) {
            throw new IllegalArgumentException("The spell must not be null.");
        }

        return protectedFrom.contains((AttackingSpell) spell);
    }

    /**
     * Registers the specified spells that the object gains protection from.
     *
     * @param attacks list of spells the object gains protection from
     * @throws IllegalArgumentException if the specified list is null
     */
    @Override
    public void setProtection(Set<AttackingSpell> attacks) {
        if (attacks == null) {
            throw new IllegalArgumentException("List of attacks to add must not be empty.");
        }

        protectedFrom.addAll(attacks);
    }

    /**
     * Removes the specified spells that the object loses protection for.
     *
     * @param attacks list of spells the object loses protection for
     * @throws IllegalArgumentException if the specified list is null
     */
    @Override
    public void removeProtection(Set<AttackingSpell> attacks) {
        if (attacks == null) {
            throw new IllegalArgumentException("List of attacks to remove must not be empty.");
        }

        protectedFrom.removeAll(attacks);
    }

    /**
     * Returns the string representation of the wizard in the format:
     * <p>
     * "[%s(%s): %d/%d %d/%d; %d %s; knows %s; carries %s]" with the arguments:
     * <ul>
     *     <li>{@link Wizard#name}</li>
     *     <li>{@link Wizard#level}</li>
     *     <li>{@link Wizard#HP}/{@link Wizard#basicHP}</li>
     *     <li>{@link Wizard#MP}/{@link Wizard#basicMP}</li>
     *     <li>{@link Wizard#money} (with the currency sign)</li>
     *     <li>{@link Wizard#knownSpells}</li>
     *     <li>{@link Wizard#inventory}</li>
     * </ul>
     *
     * @return string representation of the wizard
     */
    @Override
    public String toString() {
        String currencyString = money == 1 ? "Knut" : "Knuts";

        return "[%s(%s): %d/%d %d/%d; %d %s; knows %s; carries %s]"
                .formatted(name, level, HP, basicHP, MP, basicMP, money, currencyString, knownSpells, inventory);
    }
}