package a11908284;

/**
 * The interface that adds the abilities to interact with the inventory, the
 * wallet, trade items, use items, and steal and loot from other traders.
 */
public interface Trader {
    /**
     * Checks whether the specified item is possessed by the object.
     *
     * @param item item to test for
     * @return whether the item is possessed
     * @throws IllegalArgumentException if item is null
     */
    boolean possesses(Tradeable item);

    /**
     * Checks whether the specified amount can be afforded by the object.
     *
     * @param amount amount to test for
     * @return whether the amount can be afforded
     * @throws IllegalArgumentException if amount is negative
     */
    boolean canAfford(int amount);

    /**
     * Checks whether the specified weight can be additionally carried by the
     * object.
     *
     * @param weight weight to test for
     * @return whether the weight can be additionally carried
     * @throws IllegalArgumentException if weight is negative
     */
    boolean hasCapacity(int weight);

    /**
     * Pay the specified amount.
     *
     * @param amount amount to pay
     * @return whether the payment succeeded
     * @throws IllegalArgumentException if the amount is negative
     */
    boolean pay(int amount);

    /**
     * Earn the specified amount.
     *
     * @param amount amount to earn
     * @return always true (why?)
     * @throws IllegalArgumentException if the amount is negative
     */
    boolean earn(int amount);

    /**
     * Add the specified item to the inventory.
     *
     * @param item item to add to the inventory
     * @return whether the item could be additionally carried
     * @throws IllegalArgumentException if the item is null
     */
    boolean addToInventory(Tradeable item);

    /**
     * Remove the specified item from the inventory.
     *
     * @param item item to remove from the inventory
     * @return whether the item could be removed (e.g. was not in there before)
     * @throws IllegalArgumentException if the item is null
     */
    boolean removeFromInventory(Tradeable item);

    /**
     * Checks whether the object can be stolen.
     *
     * @return whether the object could be stolen
     */
    default boolean canSteal() {
        // By default, do nothing as we don't know yet
        return false;
    }

    /**
     * Steals a random item by moving it from this object's inventory to the
     * specified thief's inventory. If the item could not be stolen because of
     * the thief doesn't have enough capacity, the item vanishes nevertheless.
     *
     * @param thief the thief that steals from this object
     * @return whether the thief can steal, this object's inventory is empty or
     *         the thief doesn't have enough capacity for the stolen item
     * @throws IllegalArgumentException if the thief is null
     */
    boolean steal(Trader thief);

    /**
     * Checks whether the object can be looted.
     *
     * @return whether the object can be looted
     */
    default boolean isLootable() {
        // By default, the object cannot be looted
        return false;
    }

    /**
     * Checks whether the object can loot other objects.
     *
     * @return whether the object can loot other objects
     */
    default boolean canLoot() {
        // By default, the object cannot loot other objects
        return false;
    }

    /**
     * Loots all the items by moving them from the object's inventory to the
     * specified looter's inventory. All of the objects that don't fit in the
     * looter's inventory will vanish nevertheless.
     *
     * @param looter the looter that loots from the object
     * @return whether the looter can loot and at least one item was looted
     */
    boolean loot(Trader looter);
}