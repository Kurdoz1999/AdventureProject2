public class Player {
    private Room currentRoom;
    private UI ui;
    private Map map;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            ui.dispMes("You move "+direction+".");
            ui.dispMes(getCurrentRoom().getDesc());
            map.moveNextRoom(currentRoom);
        }else{
            ui.dispMes("You can't go that way.");
        }
    }

    public void handleUI() {
            String input = ui.getUI();
            switch (input) {
                case "go north", "north", "n" -> move("north");
                case "go south", "south", "s" -> move("south");
                case "go east", "east", "e" -> move("east");
                case "go west", "west", "w" -> move("west");
                case "exit" -> ui.showExitMes();
                case "look", "l" -> ui.dispMes("Looking around: "+getCurrentRoom().getDesc());
                case "help", "h" -> ui.showHelpMes();
                default -> ui.showDefMes();
            }
    }
}