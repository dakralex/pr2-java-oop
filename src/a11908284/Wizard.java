package a11908284;

import java.util.Set;

/**
 * Wizard class objects are the primary actors in the game. They can use and trade items, provide
 * magic energy, cast spells and also are affected be various magical effects.
 */
public class Wizard implements MagicSource, Trader, MagicEffectRealization {
    /**
     * Not null not empty
     */
    private String name;
    /**
     * Not null
     */
    private MagicLevel level;
    /**
     * Not negative
     */
    private int basicHP;
    /**
     * Not negative; defaults to basicHP
     */
    private int HP;
    /**
     * Not less than the manapoints associated with the magic level
     */
    private int basicMP;
    /**
     * Not negative; defaults to basicMP
     */
    private int MP;
    /**
     * Not negative
     */
    private int money;
    /**
     * Not null, may be empty; use HashSet for instantiation
     */
    private Set<Spell> knownSpells;
    /**
     * Not null, may be empty; use HashSet for instantiation
     */
    private Set<AttackingSpell> protectedFrom;
    /**
     * Not negative
     */
    private int carryingCapacity;
    /**
     * Not null, may be empty, use HashSet for instantiation, total weight of inventory
     * may never exceed carryingCapacity
     */
    private Set<Tradeable> inventory;

    /**
     * @param name             name
     * @param level            the magic level (proficiency needed to cast spells)
     * @param basicHP          base for percentage health calculations
     * @param HP               current health
     * @param basicMP          base for percentage mana calculations
     * @param MP               current mana
     * @param money            current money
     * @param knownSpells      set of known spells
     * @param protectedFrom    set of spells the object is protected against
     * @param carryingCapacity maximum carrying capacity
     * @param inventory        set of items the object is currently carrying
     */
    public Wizard(String name, MagicLevel level, int basicHP, int HP, int basicMP, int MP, int money,
                  Set<Spell> knownSpells, Set<AttackingSpell> protectedFrom, int carryingCapacity,
                  Set<Tradeable> inventory) {
        // TODO Unimplemented
    }

    /**
     * Return true, if HP is 0, false otherwise
     *
     * @return true, if HP is 0, false otherwise
     */
    public boolean isDead() {
        // TODO Unimplemented
        return false;
    }

    /**
     * Calculates and returns the total weight of all the items in the inventory
     *
     * @return total weight of all items in inventory
     */
    private int inventoryTotalWeight() {
        // TODO Unimplemented
        return 0;
    }

    /**
     * If spell is null, IllegalArgumentException has to be thrown;
     * if wizard is dead (isDead) no action can be taken and false is returned;
     * add spell to the set of knownSpells;
     * returns true, if insertion was successful, false otherwise.
     *
     * @param s spell to be learned
     * @return true, if insertion was successful, false otherwise.
     */
    public boolean learn(Spell s) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If spell is null, IllegalArgumentException has to be thrown;
     * if wizard is dead (isDead) no action can be taken and false is returned;
     * remove spell from the set of knownSpells;
     * returns true if removal was successful, false otherwise.
     *
     * @param s spell that the object is about to learn
     * @return true, if removal was successful, false otherwise.
     */
    public boolean forget(Spell s) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If s or target is null, IllegalArgumentException has to be thrown;
     * if wizard is dead (isDead) no action can be taken and false is returned;
     * if wizard does not know the spell, false is returned;
     * call cast on s with this as source and parameter target as target
     * return true, if cast was called;
     *
     * @param s      spell to be cast
     * @param target target of the spell to cast
     * @return true, if cast was called, false otherwise;
     */
    public boolean castSpell(Spell s, MagicEffectRealization target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If this object's knownSpells is empty, return false
     * otherwise choose a random spell from knownSpells and delegate to
     * castSpell(Spell, MagicEffectRealization)
     *
     * @param target target of the spell to cast
     * @return false, if the object does not know a spell, otherwise the
     * result of the delegation to castSpell
     */
    public boolean castRandomSpell(MagicEffectRealization target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If item or target is null, IllegalArgumentException has to be thrown;
     * if wizard is dead (isDead) no action can be taken and false is returned;
     * if wizard does not possess the item, false is returned;
     * call useOn on the item with parameter target as target;
     * return true, if useOn was called.
     *
     * @param item   item to be used
     * @param target target on which item is to be used on
     * @return true, if useOn was called, false otherwise
     */
    public boolean useItem(Tradeable item, MagicEffectRealization target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If this object's inventory is empty, return false;
     * otherwise choose a random item from inventory and delegate to
     * useItem(Tradeable, MagicEffectRealization).
     *
     * @param target target on which item is to be used on
     * @return false, if the object does not possess any item, otherwise the
     * result of the delegation to useItem
     */
    public boolean useRandomItem(MagicEffectRealization target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If item or target is null, IllegalArgumentException has to be thrown;
     * if wizard is dead (isDead), no action can be taken and false is returned;
     * call purchase on the item with this as seller and target as buyer;
     * return true, if purchase was called successfully (returned true), false
     * otherwise.
     *
     * @param item   item to be sold
     * @param target object the item is sold to (buyer)
     * @return true, if purchase was called successfully (returned true), false
     * otherwise.
     */
    public boolean sellItem(Tradeable item, Trader target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If this object's inventory is empty, return false,
     * otherwise choose a random item from inventory and delegate to
     * sellItem(Tradeable, MagicEffectRealization).
     *
     * @param target object the item is sold to (buyer)
     * @return false, if the object does not possess any item, otherwise the
     * result of the delegation to sellItem
     */
    public boolean sellRandomItem(Trader target) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Returns a string in the format
     * "['name'('level'): 'HP'/'basicHP' 'MP'/'basicMP'; 'money' 'KnutOrKnuts'; knows 'knownSpells'; carries 'inventory']";
     * where 'level' is the asterisks representation of the level
     * (see MagicLevel.toString) and 'knownSpells' and 'inventory' use
     * the default toString method of Java Set; 'KnutOrKnuts' is Knut
     * if 'money' is 1, Knuts otherwise.
     * E.g. [Ignatius(**): 70/100 100/150; 72 Knuts; knows [[Episkey(*): 5 mana; +20 HP], [Confringo: 10 mana; -20 HP]]; carries []]
     *
     * @return "['name'('level'): 'HP'/'basicHP' 'MP'/'basicMP'; 'money' 'KnutOrKnuts'; knows 'knownSpells'; carries 'inventory']"
     */
    @Override
    public String toString() {
        // TODO Unimplemented
        return "";
    }

    //MagicSource Interface

    /**
     * If wizard is dead (isDead) no action can be taken and false is returned:
     * check if level is at least levelNeeded, return false otherwise;
     * if MP is less than manaAmount return false;
     * subtract manaAmount from MP and return true.
     *
     * @param levelNeeded minimum magic level needed for the action
     * @param manaAmount  amount of mana needed for the action
     * @return true, if mana can be successfully provided, false otherwise
     */
    @Override
    public boolean provideMana(MagicLevel levelNeeded, int manaAmount) {
        // TODO Unimplemented
        return false;
    }

    //Trader Interface

    /**
     * Return true, if the item is in the inventory, false otherwise
     *
     * @param item object is tested, if it possesses this item
     * @return true, if the item is in the inventory, false otherwise
     */
    @Override
    public boolean possesses(Tradeable item) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Return true, if money is greater than or equal to amount, false otherwise
     *
     * @param amount object is tested, if it owns enough money to pay this amount
     * @return true, if money is greater than or equal to amount, false otherwise
     */
    @Override
    public boolean canAfford(int amount) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Return true, if inventoryTotalWeight+weight is less than or equal to carryingCapacity, false otherwise
     *
     * @param weight test, if this weight can be added to object's inventory, without exceeding the
     *               carryingCapacity
     * @return true, if inventoryTotalWeight+weight is less than or equal to carryingCapacity, false otherwise
     */
    @Override
    public boolean hasCapacity(int weight) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If wizard is dead (isDead) no action can be taken and false is returned;
     * if this owns enough money deduct amount from money and return true,
     * return false otherwise
     *
     * @param amount to be payed
     * @return true, if payment succeeds, false otherwise
     */
    @Override
    public boolean pay(int amount) {
        // TODO Unimplemented
        return false;
    }

    /**
     * If wizard is dead (isDead), no action can be taken and false is returned;
     * add amount to this object's money and return true.
     *
     * @param amount amount to be received
     * @return true, if reception succeeds, false otherwise
     */
    @Override
    public boolean earn(int amount) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Edd item to inventory if carryingCapacity is sufficient.
     * returns true, if item is successfully added, false otherwise
     * (carrying capacity exceeded or item is already in the inventory)
     *
     * @param item item to be added to object's inventory
     * @return true. if item is successfully added, false otherwise
     */
    @Override
    public boolean addToInventory(Tradeable item) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Remove item from inventory.
     * returns true, if item is successfully removed, false otherwise
     * (item not in the inventory).
     *
     * @param item item to be removed from object's inventory
     * @return true, if item is successfully removed, false otherwise
     */
    @Override
    public boolean removeFromInventory(Tradeable item) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Returns true, if this object's HP are not 0 (alive wizard).
     *
     * @return true, if the object is alive
     */
    @Override
    public boolean canSteal() {
        // TODO Unimplemented
        return false;
    }

    /**
     * If thief is null, IllegalArgumentException has to be thrown;
     * if thief cannot steal (canSteal returns false) no action can be taken
     * and false is returned;
     * returns false if, the object's inventory is empty;
     * otherwise transfers a random item from the this object's inventory into
     * the thief's inventory;
     * if the thief's inventory has not enough capacity, the object just vanishes
     * and false is returned;
     * returns true, if theft was successful.
     *
     * @param thief object that is stealing the item from the this-object.
     * @return true, if theft was successful
     */
    @Override
    public boolean steal(Trader thief) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Returns true if, this object's HP are 0 (dead wizard)
     *
     * @return true if the object is dead
     */
    @Override
    public boolean isLootable() {
        // TODO Unimplemented
        return false;
    }

    /**
     * Returns true if this object's HP are not 0 (alive wizard)
     *
     * @return true, if the object is alive
     */
    @Override
    public boolean canLoot() {
        // TODO Unimplemented
        return false;
    }

    /**
     * Of looter is null, IllegalArgumentException has to be thrown;
     * if looter cannot loot (canLoot returns false), no action can be taken
     * and false is returned;
     * if the this object can be looted (isLootable), transfer all the items
     * in the object's inventory into the looter's inventory;
     * items that don't fit in the looter's inventory because auf the weight
     * limitation just vanish.
     * returns true, if at least one item was successfully transferred, false
     * otherwise.
     *
     * @param looter object that is looting this-object.
     * @return true, if looting was successful, false otherwise
     */
    @Override
    public boolean loot(Trader looter) {
        // TODO Unimplemented
        return false;
    }

    //MagicEffectRealization Interface

    /**
     * Reduce the object's HP by amount ensuring however that HP does not
     * become negative.
     *
     * @param amount amount to be deducted from health
     */
    @Override
    public void takeDamage(int amount) {
        // TODO Unimplemented
    }

    /**
     * Reduce the object's HP by the percentage given of the object's basic
     * HP value ensuring however, that HP does not become negative.
     * Do calculations in double truncating to int only for the assignment
     *
     * @param percentage percentage of damage done
     */
    @Override
    public void takeDamagePercent(int percentage) {
        // TODO Unimplemented
    }

    /**
     * Reduce the object's MP by amount ensuring however that MP does not
     * become negative.
     *
     * @param amount amount to be deducted from mana
     */
    @Override
    public void weakenMagic(int amount) {
        // TODO Unimplemented
    }

    /**
     * Reduce the object's MP by the percentage given of the object's basic
     * MP value ensuring however, that MP does not become negative.
     * Do calculations in double truncating to int only for the assignment
     *
     * @param percentage percentage of damage done
     */
    @Override
    public void weakenMagicPercent(int percentage) {
        // TODO Unimplemented
    }

    /**
     * Increase the object's HP by the amount given.
     *
     * @param amount amount to increase health
     */
    @Override
    public void heal(int amount) {
        // TODO Unimplemented
    }

    /**
     * Increase the object's HP by the percentage given of the object's
     * basic HP. Do calculations in double truncating to int only for
     * the assignment
     *
     * @param percentage percentage of healing done
     */
    @Override
    public void healPercent(int percentage) {
        // TODO Unimplemented
    }

    /**
     * Increase the object's MP by the amount given.
     *
     * @param amount amount to increase mana
     */
    @Override
    public void enforceMagic(int amount) {
        // TODO Unimplemented
    }

    /**
     * Increase the object's MP by the percentage given of the object's
     * basic MP. Do calculations in double truncating to int only for
     * the assignment
     *
     * @param percentage percentage of mana increase
     */
    @Override
    public void enforceMagicPercent(int percentage) {
        // TODO Unimplemented
    }

    /**
     * Return true, if s is contained in instance variable protectedFrom
     *
     * @param spell spell that is tested for
     * @return true, if object is protected against spell s, false otherwise
     */
    @Override
    public boolean isProtected(Spell spell) {
        // TODO Unimplemented
        return false;
    }

    /**
     * Add all spells from attacks to instance variable protectedFrom
     *
     * @param attacks spells against which protection is provided
     */
    @Override
    public void setProtection(Set<AttackingSpell> attacks) {
        // TODO Unimplemented
    }

    /**
     * Remove all spells from attacks from instance variable protectedFrom
     *
     * @param attacks spells against which protection is removed
     */
    @Override
    public void removeProtection(Set<AttackingSpell> attacks) {
        // TODO Unimplemented
    }
}