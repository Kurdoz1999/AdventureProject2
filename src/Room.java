public class Room {

    private String name, desc;
    private Room north, south, east, west;

    Room (String name, String desc) {
        this.name = name;
        this.desc = desc;}

    public void setRoom(Room north, Room south, Room east, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    public Room getRoom(String direction) {
        return switch(direction.toLowerCase()) {
            case "north" -> north;
            case "south" -> south;
            case "east" -> east;
            case "west" -> west;
            default -> null;
        };
    }
    public String getName() {return name;}
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
}