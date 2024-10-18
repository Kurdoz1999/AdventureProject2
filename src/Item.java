public class Item {
/*
    private String name;

    public Item(String name) {this.name = name;}
    public String getItemName() {return name;}
*/
    private String longName;
    private String shortName;

    public Item(String longName, String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }
    public String getLongName() {
        return longName;
    }
    public String getShortName() {
        return shortName;
    }
}