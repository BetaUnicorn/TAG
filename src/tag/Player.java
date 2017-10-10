package tag;

public class Player {
    private String name;
    private int health = 10;
    private int coinPurse = 0;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getCoinPurse() {
        return coinPurse;
    }
    
    public void addCoins(int amount){
         coinPurse += amount;
    
    }
    public void loseCoins(int amount){
        coinPurse -= amount;
    }
    
}
