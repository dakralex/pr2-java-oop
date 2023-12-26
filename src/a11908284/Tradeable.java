package a11908284;

/**
 * The interface that adds the ability to trade an item.
 */
public interface Tradeable {
    /**
     * Return the price of the object.
     *
     * @return price of the object
     */
    int getPrice();

    /**
     * Returns the weight of the object.
     *
     * @return weight of the object
     */
    int getWeight();

    /**
     * Transfer the item from the specified trader's inventory to the other's
     * inventory. This method does not check if the first has the item and the
     * latter can carry the item.
     *
     * @param src  the inventory the item will be taken from
     * @param dest the inventory the item will be transferred to
     * @return whether the transfer succeeded
     */
    private boolean transfer(Trader src, Trader dest) {
        // By default, remove the item from the source and add it to the destination
        return src.removeFromInventory(this) && dest.addToInventory(this);
    }

    /**
     * Gives the item from the specified giver to the specified taker for free.
     * This method will check whether the giver has the item and the taker can
     * carry the item.
     *
     * @param giver the one who gives the object away
     * @param taker the one who receives the object
     * @return whether the giver had the item, the taker has the capacity and
     *         the transfer was successful
     * @throws IllegalArgumentException if the giver and/or taker is/are null or
     *                                  are the same object
     */
    default boolean give(Trader giver, Trader taker) {
        if (giver == null || taker == null) {
            throw new IllegalArgumentException("Giver and taker must not be null.");
        }

        if (giver == taker) {
            throw new IllegalArgumentException("Giver and taker must not be the same object.");
        }

        int itemWeight = getWeight();
        if (giver.possesses(this) && taker.hasCapacity(itemWeight)) {
            return transfer(giver, taker);
        }

        return false;
    }

    /**
     * Purchase the item from the specified seller to the specified buyer. This
     * method will check whether the seller has the item, the taker can afford
     * and carry the item and then does the transfer.
     *
     * @param seller the one who sells the item
     * @param buyer  the one who buys the item
     * @return whether the seller had the item, the buyer has the money and
     *         capacity and the transfer was successful
     * @throws IllegalArgumentException if the seller and/or buyer is/are null
     *                                  or are the same object
     */
    default boolean purchase(Trader seller, Trader buyer) {
        if (seller == null || buyer == null) {
            throw new IllegalArgumentException("Seller and buyer must not be null.");
        }

        if (seller == buyer) {
            throw new IllegalArgumentException("Seller and buyer must not be the same object.");
        }

        int itemPrice = getPrice();
        int itemWeight = getWeight();
        if (seller.possesses(this) && buyer.canAfford(itemPrice) && buyer.hasCapacity(itemWeight)) {
            return buyer.pay(itemPrice) && seller.earn(itemPrice) && transfer(seller, buyer);
        }

        return false;
    }

    /**
     * Use item on the specified target.
     *
     * @param target target of the item's usage
     * @throws IllegalArgumentException if the target is null
     */
    void useOn(MagicEffectRealization target);
}