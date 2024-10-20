public class Enemy {
    private String name;
    private String description;
    private int hp;
    private Weapon weapon;

    public Enemy(String name, String description, int hp, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void hit(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " has been defeated.");
        } else {
            System.out.println(name + " took " + damage + " damage. Remaining HP: " + hp);
        }
    }

    public void attack(Player player) {
        if (weapon.canUse()) {
            weapon.useWeapon();
            player.adjustHp(-weapon.getDamage());
            System.out.println(name + " attacked you with " + weapon.getLongName() + " and dealt " + weapon.getDamage() + " damage.");
        } else {
            System.out.println(name + "'s weapon cannot be used anymore.");
        }
    }

    public void dropWeapon(Room room) {
        if (hp <= 0) {
            room.addItem(weapon);
            System.out.println(name + " dropped " + weapon.getLongName() + ".");
        }
    }
}