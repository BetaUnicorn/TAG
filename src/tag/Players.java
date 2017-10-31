package tag;

public interface Players {
    public boolean takeCombatTurn(Players p);
    
    public String getName();
    
    public void changeHP(int dmg);
    
    public int getHP();

}
