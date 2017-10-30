package tag;

public class Monster implements NPC{
    
    private String name;
    private int health;
    private int attack;
    RandomMovement move = new RandomMovement();

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

    @Override
    public void takeCombatTurn(Players p) {
        System.out.println("Test");
    }
    
    public void changeHP(int dmg) {
        this.health += dmg;
    }

    @Override
    public int getHP() {
        return health;
    }
    
}
