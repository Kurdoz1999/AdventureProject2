public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon(String longName, String shortName, int ammo) {
        super(longName, shortName);
        this.ammo = ammo;
    }

    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public void useWeapon() {
        if (ammo > 0) {
            ammo--;
            System.out.println("You fire your " + getLongName() + ". Remaining ammo: " + ammo);
        } else {
            System.out.println("Your " + getLongName() + " is out of ammo.");
        }
    }
}