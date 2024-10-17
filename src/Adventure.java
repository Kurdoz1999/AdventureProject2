public class Adventure {
    private Room currentRoom;
    private Map map;
    private Player player;
    private UI ui;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartRoom());
        this.ui = new UI();
    }

    public void start() {
        ui.showWelcMes();
        player.handleUI();
    }

    public Room getCurrentRoom() {return currentRoom;}
    public void setCurrentRoom(Room currentRoom) {this.currentRoom = currentRoom;}
}