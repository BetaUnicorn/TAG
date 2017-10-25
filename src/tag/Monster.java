package tag;

public class Monster {

    private String name;
    private int health;
    MonsterMovement move = new MonsterMovement();

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

}
