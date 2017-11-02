package tag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import textio.SysTextIO;
import textio.TextIO;

public class Combat {

    private final TextIO io = new TextIO(new SysTextIO());


    public boolean combatScenario(Players p, NPC monster, Room currRoom, ArrayList<NPC> monsters) {

        boolean combat = true;
        Action action = new Action();

        while (combat) {
            p.takeCombatTurn(monster);
            monster.takeCombatTurn(p);
            if (p.getHP() <= 0) {
                return true;
            } else if (monster.getHP() <= 0) {
                io.put(monster.getName() + " died and may have dropped phat lootz, try inspect to see what.\n");
                action.monsterDrop(currRoom, monster);
                monsters.remove(monster);
                Music.stopMusic();
                break;
            }
        }
        return false;
    }

   
}
