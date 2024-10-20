import java.util.ArrayList;

public class Room {
    private String name, desc;
    private Room north, south, east, west;
    private ArrayList<Item> roomInv;
    private ArrayList<Enemy> enemies;

    Room (String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.roomInv = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void removeItem(Item item) {
        roomInv.remove(item);
    }
    public void addItem(Item item) {
        roomInv.add(item);
    }
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
    public Item getItemByName(String name) {
        for(Item item : roomInv) {
            if(item.getLongName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
    public ArrayList<Enemy> getEnemies() {return enemies;}
    public Enemy getEnemyByName(String name) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(name)) {
                return enemy;
            }
        }
        return null;
    }

    public ArrayList<Item> getRoomInvList() {return roomInv;}
    public String getName() {return name;}
    public String getCurrentRoomDesc() {return desc;}
}