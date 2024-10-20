public abstract class Weapon extends Item {
    private int damage;

    public Weapon(String longName, String shortName, int damage) {
        super(longName, shortName);
        this.damage = damage;
    }

    public abstract boolean canUse();

    public abstract void useWeapon();

    public int getDamage() {
        return damage;
    }
}