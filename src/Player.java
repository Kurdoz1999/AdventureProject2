import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private UI ui;
    private Map map;
    private ArrayList<Item> playerInv;

    public Player(Room startingRoom, UI ui) {
        this.currentRoom = startingRoom;
        this.playerInv = new ArrayList<>();
        this.ui = new UI();
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
            ui.dispMes("Items in this room: "+listItems(currentRoom.getRoomInvList()));
            map.moveNextRoom(currentRoom);
        }else{
            ui.dispMes("You can't go that way.");
        }
    }

    public void takeItem(String itemName){
        Item itemToTake = findItem(itemName,currentRoom.getRoomInvList());
        if (itemToTake != null) {
            currentRoom.removeItem(itemToTake);
            playerInv.add(itemToTake);
            ui.dispMes("You take the "+itemToTake.getLongName()+".");
        }else{
            ui.dispMes("There is nothing like "+itemName+" in room "+getCurrentRoom().getName());
        }
    }

    public void dropItem(String itemName){
        Item itemToDrop = findItem(itemName, playerInv);
        if (itemToDrop != null) {
            playerInv.remove(itemToDrop);
            currentRoom.addItem(itemToDrop);
            ui.dispMes("You left "+itemToDrop.getLongName()+" in room "+getCurrentRoom().getName());
        }else{
            ui.dispMes("You do not have anything like "+itemName+" in your inventory");
        }
    }

    public void showInv() {
        if(playerInv.isEmpty()) {
            ui.dispMes("Your inventory is empty");
        }else{
            ui.dispMes("You have the following items in your inventory: ");
            for(Item item : playerInv) {
                ui.dispMes("\n"+item.getLongName());
            }
        }
    }

    private String listItems(ArrayList<Item> items) {
        StringBuilder itemList = new StringBuilder();
        for(Item item : items) {
            if(itemList.length() > 0) {
                itemList.append("\n");
            } itemList.append(item.getLongName());
        }
        return itemList.toString();
    }

    private Item findItem(String name, ArrayList<Item> items) {
        for(Item item : items) {
            if(item.getShortName().equalsIgnoreCase(name)||item.getLongName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Object handleUI(String UI) {
        String[] inputs = UI.split(" ");
        String command = inputs[0];

            switch (command) {
                case "exit" -> ui.showExitMes();
                case "drop" -> {
                    if (inputs.length > 1) {
                        dropItem(inputs[1]);
                    }else{
                        ui.dispMes("What do you want to drop?");
                    }
                }
                case "go north", "north", "n" -> move("north");
                case "go south", "south", "s" -> move("south");
                case "go east", "east", "e" -> move("east");
                case "go west", "west", "w" -> move("west");
                case "help", "h" -> ui.showHelpMes();
                case "inventory", "invent", "inv" -> showInv();
                case "look", "l" -> ui.dispMes("Looking around: "+getCurrentRoom().getDesc());
                case "take" -> {
                    if (inputs.length > 1) {
                        takeItem(inputs[1]);
                    }else{
                        ui.dispMes("What do you want to take?");
                    }
                }
                default -> ui.showDefMes();
            }
        return null;
    }
    public void removeItem(Item item) {
        playerInv.remove(item);
    }
    public void addItem(Item item) {
        playerInv.add(item);
    }
    public ArrayList<Item> getPlayerInvList() {return playerInv;}

    protected void getDispMes(String message) {
        ui.dispMes(message);
    }

    protected String getInput() {
        return ui.getUI("Type your command: ").toLowerCase();
    }
}