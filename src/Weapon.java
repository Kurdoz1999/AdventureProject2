public abstract class Weapon extends Item {
    public Weapon(String longName, String shortName) {
        super(longName, shortName);
    }

    // Metode til at tjekke om våben kan bruges (fx om der er ammo i RangedWeapon)
    public abstract boolean canUse();

    // Bruges til at angive, hvordan våbnet skal anvendes (angreb med nærkampsvåben eller skud)
    public abstract void useWeapon();
}
