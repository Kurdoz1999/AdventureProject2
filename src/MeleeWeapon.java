public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String longName, String shortName) {
        super(longName, shortName);
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