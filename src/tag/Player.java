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
    
    public void addCoins(){
         coinPurse += amount;
    
    }
    public void lossCoins(){
        coinPurse -= amount;
    }
    
}
