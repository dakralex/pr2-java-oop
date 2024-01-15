package a11908284;

/**
 * The abstract class that represents items which can be traded, can have and
 * cause magic effects.
 */
public abstract class MagicItem implements Tradeable, MagicEffectRealization, MagicSource {

    /**
     * The name of the magic item. This field must not be null.
     */
    private final String name;
    /**
     * The price of the magic item. This field must not be negative.
     */
    private final int price;
    /**
     * The weight of the magic item. This field must not be negative.
     */
    private final int weight;
    /**
     * The number of usages that are remaining. This field must not be
     * negative.
     */
    private int usages;

    /**
     * Creates a magic item instance.
     *
     * @param name   name of the magic item
     * @param usages number of usages that are remaining
     * @param price  price of the magic item
     * @param weight weight of the magic item
     * @throws IllegalArgumentException if name is null or empty, or usages,
     *                                  price or weight are negative
     */
    protected MagicItem(String name, int usages, int price, int weight) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of a magic item must not be null or empty.");
        }

        if (usages < 0) {
            throw new IllegalArgumentException("The remaining usages of a magic item must not be negative.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("The price of a magic item must not be negative.");
        }

        if (weight < 0) {
            throw new IllegalArgumentException("The weight of a magic item must not be negative.");
        }

        this.name = name;
        this.usages = usages;
        this.price = price;
        this.weight = weight;
    }

    /**
     * Returns the amount of remaining usages.
     *
     * @return amount of remaining usages
     */
    public int getUsages() {
        return usages;
    }

    /**
     * Returns whether the magic item can still be used
     *
     * @return whether the magic item can still be used
     */
    public boolean tryUsage() {
        if (usages > 0) {
            usages -= 1;

            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the suffix depending on the amount of remaining usages
     *
     * @return if remaining usages are equal to 1 then "use", else "uses"
     */
    public String usageString() {
        if (usages == 1) {
            return "use";
        } else {
            return "uses";
        }
    }

    /**
     * Returns additional output for the magic item.
     *
     * @return always returns ""
     */
    public String additionalOutputString() {
        return "";
    }

    /**
     * Returns the suffix depending on the price
     *
     * @return if the price is equal to 1 then "Knut", else "Knuts"
     */
    private String currencyString() {
        if (price == 1) {
            return "Knut";
        } else {
            return "Knuts";
        }
    }

    /**
     * Returns price of the magic item.
     *
     * @return price of the magic item
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Returns the weight of the magic item.
     *
     * @return weight
     */
    @Override
    public int getWeight() {
        return weight;
    }

    /**
     * Returns whether mana could be provided
     *
     * @param levelNeeded magic level minimum to provide the mana points
     * @param amount      amount of mana points that will be provided
     * @return always returns true
     * @throws IllegalArgumentException if levelNeeded is null or amount is
     *                                  negative
     */
    @Override
    public boolean provideMana(MagicLevel levelNeeded, int amount) {
        if (levelNeeded == null) {
            throw new IllegalArgumentException("Minimum magic level must not be null.");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative.");
        }

        return true;
    }

    /**
     * Reduces usages by the specified percentage.
     *
     * @param percentage relative amount of damage (value between [0;100])
     */
    @Override
    public void takeDamagePercent(int percentage) {
        usages = (int) (usages * (percentage / 100.0));
    }

    /**
     * Returns a string representation of the magic item in the format:
     * <p>
     * "[%s; %d g; %d %s; %d %s%s]" with the arguments:
     * <ul>
     *  <li>{@link MagicItem#name}</li>
     *  <li>{@link MagicItem#weight}</li>
     *  <li>{@link MagicItem#price}</li>
     *  <li>{@link MagicItem#currencyString()}</li>
     *  <li>{@link MagicItem#usages}</li>
     *  <li>{@link MagicItem#usageString()}</li>
     *  <li>{@link MagicItem#additionalOutputString()}</li>
     * </ul>
     *
     * @return string representation of the magic item
     */
    @Override
    public String toString() {
        String currencyString = currencyString();
        String usageString = usageString();
        String additionalOutput = additionalOutputString();

        return "[%s; %d g; %d %s; %d %s%s]"
                .formatted(name, weight, price, currencyString, usages, usageString, additionalOutput);
    }
}