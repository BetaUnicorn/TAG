package tag;

public class Player {

    private String name;
    private int health = 2;
    private int bank = 0;
    private final Bag bag = new Bag();
    private final Pickup pickUp = new Pickup();

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
    
    public void loot(Room currRoom, Player p) {
        pickUp.itemPickup(currRoom, p);
    }
    
    public void trash(Room currRoom, Player p) {
        pickUp.itemTrash(currRoom, p);
    }

}
