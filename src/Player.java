import java.util.ArrayList;

public class Player {
    private int hp;
    private UI ui;
    private Room currentRoom;
    private ArrayList<Item> playerInv;

    public Player(Room startingRoom, UI ui) {
        this.currentRoom = startingRoom;
        this.playerInv = new ArrayList<>();
        this.ui = new UI();
        this.hp = 50;
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
        Item itemToTake = currentRoom.getItemByName(itemName);
        if (itemToTake != null) {
            playerInv.add(itemToTake);
            currentRoom.removeItem(itemToTake);
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
                case "go north", "north", "n": move("north"); break;
                case "go south", "south", "s": move("south"); break;
                case "go east", "east", "e": move("east"); break;
                case "go west", "west", "w": move("west"); break;
                case "eat":
                    if (inputs.length > 1) {
                        eatItem(inputs[1]);
                    }else{
                        ui.dispMes("What do you want to take?");
                    } break;
                case "healthpoints", "health", "hp": showHp(); break;
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

    public void eatItem(String itemName) {
        Item itemToEat = findItem(itemName, playerInv);
        // If not found in inventory, check the current room
        if (itemToEat == null) {
            itemToEat = currentRoom.getItemByName(itemName);
            if (itemToEat != null) {
                currentRoom.removeItem(itemToEat);
            }
        }
        // If the item is found, check if it is food
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;
            adjustHp(food.getHp());
            ui.dispMes("You ate the "+food.getLongName()+". HP adjusted by "+food.getHp());
            removeItem(itemToEat);
        } else if (itemToEat != null) {
            ui.dispMes("You can't eat the "+itemToEat.getLongName()+".");
        } else {
            ui.dispMes("There is no "+itemName+" to eat.");
        }
    }
    public int getHp(){
        return hp;
    }
    public void adjustHp(int healthPoints) {
        this.hp += healthPoints;
        if (this.hp > 100)
            {this.hp = 100;}
        if (this.hp < 0)
            {this.hp = 0;}
    }
    public void showHp() {
        ui.dispMes("HP: " + hp + " - " + getHpDesc());
    }
    private String getHpDesc() {
        if (hp >= 70) return "You are in great health!";
        if (hp >= 50) return "You are in good health, but avoid fighting right now.";
        if (hp >= 20) return "You are in poor health. Eat something or rest!";
        return "You are critically injured!";
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