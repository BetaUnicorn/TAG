package tag;

import tag.items.Item;

public class Room {
    private final String name;
    private final String desc;
    private final String feeling;
    private Room north, east, west, south;
    private Trap trap;
    private RoomInventory inventory = new RoomInventory();
    
    
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
    
    @Override
    public String toString() {
        return name;
    }
    
    public void setTrap(Trap trap) {
        this.trap = trap;
    }
    
    public int getTrapDmg(){
        return trap.getDmg();
    }
    
    public Trap getTrap() {
        return trap;
    }
    
    public void addInventory(Item item) {
        inventory.addBagItem(item);
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public String getFeeling(){
        return this.feeling;
    }
}
