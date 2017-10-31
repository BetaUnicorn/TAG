
package tag;


public class Combat {
    
    public boolean combatScenario(Players p, Players monster, Room currRoom) {
    boolean combat = true;
        
    while (combat) {
        p.takeCombatTurn(monster);
        monster.takeCombatTurn(p);
        if(p.getHP() <= 0){
            return true;
        }
        else if(monster.getHP() <= 0)
        {
            break;
        }
    }
    return false;
    }
    
    
}
