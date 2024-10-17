public class Adventure {
    private UI ui;
    private Map map;
    private Player player;

    public Adventure() {
        this.ui = new UI();
        this.map = new Map();
        this.player = new Player(map.getStartRoom(), ui);
    }

    public void start() {
        ui.showWelcMes();
        ui.dispMes(player.getCurrentRoomDesc());
        boolean isRunning = true;
        while(isRunning) {
            String input = player.getInput();
            if (input.equals("exit") || input.equals("quit")) {
                player.getDispMes("Thanks for playing. Goodbye");
                isRunning = false;
            }else{
                player.handleUI(input);
            }
        }
    }
}