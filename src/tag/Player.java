package tag;

public class Player {
    private String name;
    private int health = 10;
    private int bank = 0;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getBank() {
        return bank;
    }
    
    public void addCoins(int amount){
         bank += amount;
    
    }
    
}
