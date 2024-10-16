import java.util.Scanner;

public class Adventure {
    private Room currentRoom;

    Room room1 = new Room("Room1","");
    Room room2 = new Room("Room2","");
    Room room3 = new Room("Room3","");
    Room room4 = new Room("Room4","");
    Room room5 = new Room("Room5","");
    Room room6 = new Room("Room6","");
    Room room7 = new Room("Room7","");
    Room room8 = new Room("Room8","");
    Room room9 = new Room("Room9","");

    public Adventure() {
        currentRoom = room1;

        room1.setRoom(null, room4, room2, null);
        room2.setRoom(null, null, room3, room1);
        room3.setRoom(null, room6, null, room2);
        room4.setRoom(room1, room7, null, null);
        room5.setRoom(null, room8, null, null);
        room6.setRoom(room3, room9, null, null);
        room7.setRoom(room4, null, room8, null);
        room8.setRoom(room5, null, room9, room7);
        room9.setRoom(room6, null, null, room8);
    }

    public static void main(String[] args) { //Skal muligvis fjernes
        Adventure adventure = new Adventure();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game :D\nChoose a direction or ask for help:");

        while (true) {
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "go north", "north", "n":
                    if (adventure.currentRoom.getRoom("north") != null) {
                        adventure.currentRoom = adventure.currentRoom.getRoom("north");
                        System.out.println("Going north to "+adventure.currentRoom.getName());
                    }else{System.out.println("You cannot go that way");}
                    break;
                case "go south", "south", "s":
                    if (adventure.currentRoom.getRoom("south") != null) {
                        adventure.currentRoom = adventure.currentRoom.getRoom("south");
                        System.out.println("Going south to "+adventure.currentRoom.getName());
                    }else{System.out.println("You cannot go that way");}
                    break;
                case "go east", "east", "e":
                    if (adventure.currentRoom.getRoom("east") != null) {
                        adventure.currentRoom = adventure.currentRoom.getRoom("east");
                        System.out.println("Going east to "+adventure.currentRoom.getName());
                    }else{System.out.println("You cannot go that way");}
                    break;
                case "go west", "west", "w":
                    if (adventure.currentRoom.getRoom("west") != null) {
                        adventure.currentRoom = adventure.currentRoom.getRoom("west");
                        System.out.println("Going west to "+adventure.currentRoom.getName());
                    }else{System.out.println("You cannot go that way");}
                    break;
                case "exit":
                    System.out.println("Goodbye");
                    return;
                case "look", "l":
                    System.out.println(adventure.currentRoom.getName()+".");
                    System.out.println(adventure.currentRoom.getDesc());
                    break;
                case "help", "h":
                    System.out.println("Possibilities: go north, go south, go east, go west, look, exit");
                    break;
                default:
                    System.out.println("False command. Write 'help' to see your possibilities");
                    break;
            }
        }
    }
    public Room getCurrentRoom() {return currentRoom;}
    public void setCurrentRoom(Room currentRoom) {this.currentRoom = currentRoom;}
}