package tag;

public class Player {

    private String name;
    private int health = 100;
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

    public void changeHP(Player p, int hp) {
        if (p.getHealth() <= 100 && p.getHealth() > 0) {
            health += hp;
        }
        else{
            p.setHealth(100);
        }
    }

    public int getBank() {
        return bank;
    }

    public void addCoins(int amount) {
        bank += amount;

    }
    public void setHealth(int hp){
        this.health = hp;
    }

}
