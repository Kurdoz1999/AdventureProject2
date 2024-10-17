public class Map {
    private Room[] rooms;
    private Room currentRoom;

    public Map() {
        rooms = new Room[9];
        rooms[0] = new Room("Room1","");
        rooms[1] = new Room("Room2","");
        rooms[2] = new Room("Room3","");
        rooms[3] = new Room("Room4","");
        rooms[4] = new Room("Room5","");
        rooms[5] = new Room("Room6","");
        rooms[6] = new Room("Room7","");
        rooms[7] = new Room("Room8","");
        rooms[8] = new Room("Room9","");

        rooms[0].setRoom(null, rooms[3], rooms[1], null);
        rooms[1].setRoom(null, null, rooms[2], rooms[0]);
        rooms[2].setRoom(null, rooms[5], null, rooms[1]);
        rooms[3].setRoom(rooms[0], rooms[6], null, null);
        rooms[4].setRoom(null, rooms[7], null, null);
        rooms[5].setRoom(rooms[2], rooms[8], null, null);
        rooms[6].setRoom(rooms[3], null, rooms[7], null);
        rooms[7].setRoom(rooms[4], null, rooms[8], rooms[6]);
        rooms[8].setRoom(rooms[5], null, null, rooms[7]);

        Item ball = new Item("Tennis ball","Ball");
        rooms[0].addItem(ball);
        Item notebook = new Item("Old notebook","Notebook");
        rooms[2].addItem(notebook);
        Item key = new Item("A massive key","Key");
        rooms[3].addItem(key);
        Item coin = new Item("A shiny gold coin","Coin");
        rooms[4].addItem(coin);
        Item lantern = new Item("A rusted lantern","Lantern");
        rooms[6].addItem(lantern);
        Item bottle = new Item("A water bottle","Bottle");
        rooms[8].addItem(bottle);
    }

    public Room getStartRoom() {
        return rooms[0];
    }

    public void moveNextRoom(Room nextRoom) {
        this.currentRoom = nextRoom;
    }
}