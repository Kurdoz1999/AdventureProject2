public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String longName, String shortName, int damage) {
        super(longName, shortName, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void useWeapon() {
        System.out.println("You swing your " + getLongName() + " at the air.");
    }
}