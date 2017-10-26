package tag;

import textio.SysTextIO;
import textio.TextIO;

public class Event {

    private final TextIO io = new TextIO(new SysTextIO());

    public void monsterCollision(Room currRoom, Room monsterCurrRoom, Player p, NPC monster) {
        int damage = -10000;
        p.changeHP(damage);
        io.put("***********************************************\n");
        io.put("You met " + monster.getName() + " He damaged you " + damage + " damage #ded\n");
        io.put("***********************************************\n");
    }
}
