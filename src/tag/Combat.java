
package tag;


public class Combat {
    
    public boolean combatScenario(Players p, NPC monster, Room currRoom) {
    boolean combat = true;
    Action action = new Action();
        
    while (combat) {
        p.takeCombatTurn(monster);
        monster.takeCombatTurn(p);
        if(p.getHP() <= 0){
            return true;
        }
        else if(monster.getHP() <= 0)
        {
            action.monsterDrop(currRoom, monster);
            break;
        }
    }
    return false;
    }
    
    
}
