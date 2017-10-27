package tag;

public class Player {

    private String name;
    private int health = 2;
    private int bank = 0;
    private final Bag bag = new Bag();
    private final Action pickUp = new Action();

    public Player(String name) {
        this.name = name;
    }

    public Bag getBag() {
        return bag;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void changeHP(int hp) {
        health += hp;
        if (health > 100) {
            health = 100;
        }
    }

    public int getBank() {
        return bank;
    }

    public void addCoins(int amount) {
        bank += amount;

    }
    
    //Allows player to Pick up an item from a room
    public void loot(Room currRoom, Player p) {
        pickUp.itemPickup(currRoom, p);
    }
    
    //Allows the player to trash a item, from inventory
    public void trash(Room currRoom, Player p) {
        pickUp.itemTrash(currRoom, p);
    }
    
    public void useItem(Player p) {
        pickUp.useItem(p);
    }

}
