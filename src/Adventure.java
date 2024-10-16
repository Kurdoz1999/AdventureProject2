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

    public static void main(String[] args) { //Skal muligvis fjernes
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game :D\nChoose a direction or ask for help:");

        while (true) {
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "go north", "north", "n": System.out.println("Going north"); return;
                case "go south", "south", "s": System.out.println("Going south"); return;
                case "go east", "east", "e": System.out.println("Going east"); return;
                case "go west", "west", "w": System.out.println("Going west"); return;
                case "exit": System.out.println("Goodbye"); return;
                case "look", "l": System.out.println(???); break;
                case "help", "h": System.out.println("Possibilities: go north, go south, go east, go west, look, exit"); break;
                default: System.out.println("False command. Write 'help' to see your possibilities"); break;
            }
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}