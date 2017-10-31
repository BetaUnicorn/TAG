
package tag;

import textio.SysTextIO;
import textio.TextIO;


public class Combat {
    private final TextIO io = new TextIO(new SysTextIO());
    
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
                io.put(monster.getName() + " died and may have dropped phat lootz, try inspect to see what." );
                action.monsterDrop(currRoom, monster);
                break;
            }
        }
        return false;
        }
    
    
}
