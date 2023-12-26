package a11908284;

/**
 * The enumeration for the different magic levels throughout the application.
 * <p>
 * It is mainly used to specify the minimum magic level that a wizards needs to
 * use specific spells. Each magic level has a specific amount of mana points
 * and a representation in form of asterisks for each level.
 */
public enum MagicLevel {
    NOOB(50),
    ADEPT(100),
    STUDENT(200),
    EXPERT(500),
    MASTER(1000);

    private final int manaPoints;

    MagicLevel(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    /**
     * Returns the amount of mana points for this level.
     *
     * @return amount of mana points for this level
     */
    public int toMana() {
        return manaPoints;
    }

    @Override
    public String toString() {
        return switch (this) {
            case NOOB -> "*";
            case ADEPT -> "**";
            case STUDENT -> "***";
            case EXPERT -> "****";
            case MASTER -> "*****";
        };
    }
}