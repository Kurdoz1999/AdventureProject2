public class Map {
    private Room[] rooms;

    public Map() {
        //Rooms:
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

        //Navigation in the map:
        rooms[0].setRoom(null, rooms[3], rooms[1], null);
        rooms[1].setRoom(null, null, rooms[2], rooms[0]);
        rooms[2].setRoom(null, rooms[5], null, rooms[1]);
        rooms[3].setRoom(rooms[0], rooms[6], null, null);
        rooms[4].setRoom(null, rooms[7], null, null);
        rooms[5].setRoom(rooms[2], rooms[8], null, null);
        rooms[6].setRoom(rooms[3], null, rooms[7], null);
        rooms[7].setRoom(rooms[4], null, rooms[8], rooms[6]);
        rooms[8].setRoom(rooms[5], null, null, rooms[7]);

        //Items:
        Item ball = new Item("tennis ball","ball");
        rooms[0].addItem(ball);
        Item notebook = new Item("old notebook","notebook");
        rooms[2].addItem(notebook);
        Item key = new Item("a massive key","key");
        rooms[3].addItem(key);
        Item coin = new Item("a shiny gold coin","coin");
        rooms[4].addItem(coin);
        Item lantern = new Item("a rusted lantern","lantern");
        rooms[6].addItem(lantern);
        Item bottle = new Item("a water bottle","bottle");
        rooms[8].addItem(bottle);

        //Food items:
        Food rottenMeat = new Food("A piece of rotten meat", "meat", -20);
        rooms[1].addItem(rottenMeat);
        Food apple = new Food("A delicious apple", "apple", 10);
        rooms[8].addItem(apple);
        Food fries = new Food("A portion of fries", "fries", -15);
        rooms[3].addItem(fries);
        Food salad = new Food("A healthy green salad", "salad", 20);
        rooms[4].addItem(salad);
        Food bread = new Food("A loaf of fresh bread", "bread", 15);
        rooms[7].addItem(bread);

        //MeleeWeapons:
        Item sword = new MeleeWeapon("iron sword", "sword");
        rooms[0].addItem(sword);
        //RangedWeapons:
        Item gun = new RangedWeapon("pistol", "gun", 3);
        rooms[2].addItem(gun);
    }

    public Room getStartRoom() {
        return rooms[0];
    }
}