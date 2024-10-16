public class Room {

    private String name;
    private String desc;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    Room (String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}