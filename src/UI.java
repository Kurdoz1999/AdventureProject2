import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        Scanner scanner = new Scanner(System.in);
    }

    public String getUI() {
        return scanner.nextLine().toLowerCase().trim();
    }
    public void dispMes(String message) {
        System.out.println(message);
    }
    public void showWelcMes() {
        System.out.println("Welcome to the Adventure Game :D\nChoose a direction or ask for help:");
    }
    public void showHelpMes() {
        dispMes("Possibilities: go north, go south, go east, go west, look, exit");
    }
    public void showDefMes() {
        dispMes("False command. Write 'help' to see your possibilities");
    }
    public void showExitMes() {
        dispMes("Goodbye");
    }
}