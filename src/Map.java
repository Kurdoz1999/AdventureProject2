public class Map {
    private Room[] rooms;

    public Map() {
        //Rooms and their descriptions:
        rooms = new Room[9];
        rooms[0] = new Room("Room1", "A small, dim room with a single window and a broken chair. The air is cold.");
        rooms[1] = new Room("Room2", "A dusty hallway with peeling wallpaper and faint footsteps echoing.");
        rooms[2] = new Room("Room3", "A bright, sunlit room with an ornate rug and a fireplace. There’s a strange silence.");
        rooms[3] = new Room("Room4", "A narrow corridor with flickering lights and distant whispers.");
        rooms[4] = new Room("Room5", "A grand hall with high ceilings, chandeliers swaying slightly.");
        rooms[5] = new Room("Room6", "A damp cellar with old crates and a faint dripping sound. The smell of mildew fills the air.");
        rooms[6] = new Room("Room7", "An abandoned bedroom with tattered curtains and a bed covered in dust.");
        rooms[7] = new Room("Room8", "A large, empty room with cracked mirrors on the walls and a broken piano in the corner.");
        rooms[8] = new Room("Room9", "A quiet, eerie space with cobweb-covered bookshelves and a single chair in the center.");

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
        Item sword = new MeleeWeapon("iron sword", "sword", 10);
        rooms[0].addItem(sword);
        Item axe = new MeleeWeapon("battle axe", "axe", 15);
        rooms[4].addItem(axe);
        //RangedWeapons:
        Item gun = new RangedWeapon("pistol", "gun", 20, 3);
        rooms[5].addItem(gun);
        Item slingshot = new RangedWeapon("slingshot", "slingshot", 5, 10);
        rooms[2].addItem(slingshot);
        Item crossbow = new RangedWeapon("crossbow", "crossbow", 12, 4);
        rooms[8].addItem(crossbow);

        //Enemies:
        Weapon claw = new MeleeWeapon("Sharp Claws", "claws", 8);
        Enemy rat = new Enemy("Giant Rat", "A large and vicious rodent.", 30, claw);
        rooms[0].addEnemy(rat);
        Weapon bite = new MeleeWeapon("Sharp Teeth", "teeth", 10);
        Enemy wolf = new Enemy("Hungry Wolf", "A ferocious wolf with sharp teeth.", 40, bite);
        rooms[1].addEnemy(wolf);
        Weapon fireball = new RangedWeapon("Fireball", "fireball", 15, 3);
        Enemy dragon = new Enemy("Fire Dragon", "A fearsome dragon breathing fire.", 100, fireball);
        rooms[8].addEnemy(dragon);
    }

    public Room getStartRoom() {
        return rooms[0];
    }
}