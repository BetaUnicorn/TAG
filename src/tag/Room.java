package tag;

import tag.items.Item;

public class Room {
    private final String name;
    private final String desc;
    private final String feeling;
    private int gold;
    private Room north, east, west, south;
    private Trap trap;
    private Item item;
    
    
    public Room(String name, String desc, String feeling, int gold) {
        this.name = name;
        this.desc = desc;
        this.feeling = feeling;
        this.gold = gold;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public Item getItem() {
        return this.item;
    }
}
