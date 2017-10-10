package tag;

public class Room {
    private String name;
    private String desc;
    private String feeling;
    private Room north, east, west, south;
    
    
    public Room(String name, String desc, String feeling) {
        this.name = name;
        this.desc = desc;
        this.feeling = feeling;
        
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getSouth() {
        return south;
    }
 
    
}
