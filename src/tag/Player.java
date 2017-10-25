package tag;

public class Player {
    private String name;
    private int health = 10;
    private int bank = 0;
    private final Bag bag = new Bag();
    
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
    }

    public int getBank() {
        return bank;
    }
    
    public void addCoins(int amount){
         bank += amount;
    
    }
    
}
