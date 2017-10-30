
package tag;

public class Combat {
    
    public void combatScenario(Players p, Players monster, Room currRoom) {
    boolean combat = true;
        
    while (combat) {
        p.takeCombatTurn(monster);
        monster.takeCombatTurn(p);
    }
    }
    
}
