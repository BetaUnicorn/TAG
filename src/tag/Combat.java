
package tag;

public class Combat {
    
    public void combatScenario(Players p, Players monster, Room currRoom) {
    boolean combat = true;
        
    while (combat) {
        p.takeCombatTurn(monster);
        monster.takeCombatTurn(p);
        if(p.getHP() <= 0){
            break;
        }
        else if(monster.getHP() <= 0)
        {
            break;
        }
    }
    }
    
}
