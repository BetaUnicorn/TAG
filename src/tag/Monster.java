package tag;

public class Monster implements NPC{
    
    private String name;
    private int health;
    private int attack;
    MonsterMovement move = new MonsterMovement();

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public Room takeTurn(Room currRoom) {
        return move.takeTurn(currRoom);
    }

    @Override
    public String getName(){
        return this.name;
    }
    
    
}
