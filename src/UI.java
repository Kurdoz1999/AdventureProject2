import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public String getUI() {
        String input = scanner.nextLine().toLowerCase().trim();
        if (input.isEmpty()) {
            return "help";
        }
        return input;
    }
    public void dispMes(String message) {
        System.out.println(message);
    }
    public void showWelcMes() {
        System.out.print("Welcome to the Adventure Game :D");
    }
    public void showHelpMes() {
        dispMes("Possibilities:" +
                "\n-'exit' -> to exit the game"+

                "\n-'go north', 'north', 'n' -> to move north"+
                "\n-'go south', 'south', 's' -> to move south"+
                "\n-'go east', 'east', 'e' -> to move east"+
                "\n-'go west', 'west', 'w' -> to move west"+
                "\n-'inventory', 'inv' -> to see your inventory"+
                "\n-'look' -> to look around" +
                "\n\n Type your command: ");
    }
    public void showDefMes() {
        dispMes("False command. Write 'help' to see your possibilities");
    }
    public void showExitMes() {
        dispMes("Goodbye");
    }
}