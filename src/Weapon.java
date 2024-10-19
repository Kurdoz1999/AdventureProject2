public abstract class Weapon extends Item {
    public Weapon(String longName, String shortName) {
        super(longName, shortName);
    }

    public abstract boolean canUse();

    public abstract void useWeapon();
}
