public class Food extends Item{
    private int hp;

    public Food(String longName, String shortName, int hp) {
        super(longName,shortName);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
}
