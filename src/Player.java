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
            ui.dispMes(getCurrentRoomDesc());
        }else{
            ui.dispMes("You can't go that way.");
        }
    }

    public String getCurrentRoomDesc() {
        StringBuilder desc = new StringBuilder(currentRoom.getCurrentRoomDesc());
        ArrayList<Item> itemsInRoom = currentRoom.getRoomInvList();

        if(itemsInRoom.isEmpty()) {
            desc.append("\nThere isn't any pickable items in this room (").append(getCurrentRoom().getName()).append(").");
        }else{
            desc.append("\nItems in the current (").append(getCurrentRoom().getName()).append(") room:");
            for (Item item : itemsInRoom) {
                desc.append("\n- ").append(item.getLongName());
            }
        }return desc.toString();
    }

    public void takeItem(String itemName){
//        Item itemToTake = findItem(itemName,currentRoom.getRoomInvList());
        Item itemToTake = currentRoom.getItemByName(itemName);
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
/*
    private String listItems(ArrayList<Item> items) {
        StringBuilder itemList = new StringBuilder();
        for(Item item : items) {
            if(itemList.length() > 0) {
                itemList.append("\n");
            } itemList.append(item.getLongName());
        }
        return itemList.toString();
    }
*/
    private Item findItem(String name, ArrayList<Item> items) {
        for(Item item : items) {
            if(item.getShortName().equalsIgnoreCase(name)||item.getLongName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void handleUI(String UI) {
        String[] inputs = UI.split(" ");
        String command = inputs[0];

            switch (command) {
                case "exit": ui.showExitMes();
                case "drop":
                    if (inputs.length > 1) {
                        dropItem(inputs[1]);
                    }else{
                        ui.dispMes("What do you want to drop?");
                    } break;
                case "go":
                    if (inputs.length > 1) {
                        move(inputs[1]);
                    } else {
                        ui.dispMes("Where do you want to go?");
                    } break;
                case "go north", "north", "n": move("north"); break;
                case "go south", "south", "s": move("south"); break;
                case "go east", "east", "e": move("east"); break;
                case "go west", "west", "w": move("west"); break;
                case "help", "h": ui.showHelpMes(); break;
                case "inventory", "invent", "inv": showInv(); break;
                case "look", "l": ui.dispMes("Looking around: "+getCurrentRoomDesc()); break;
                case "take", "t":
                    if (inputs.length > 1) {
                        takeItem(inputs[1]);
                    }else{
                        ui.dispMes("What do you want to take?");
                    } break;
                default: ui.showDefMes(); break;
            }
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
        return ui.getUI().toLowerCase();
    }
}