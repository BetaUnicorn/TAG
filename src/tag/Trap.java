
package tag;

import textio.SysTextIO;
import textio.TextIO;

public class Trap {
    private int dmg;
    private final TextIO io = new TextIO(new SysTextIO());
    
    public Trap(int dmg) {
        this.dmg = dmg;
    }

    public Trap() {}

    public int getDmg() {
        return dmg;
    }
    
    public void checkTrap(Room currRoom, Human p) {
        if (currRoom.getTrap() != null) {
                p.changeHP(currRoom.getTrapDmg());
                io.put("********************************\n");
                io.put("You took " + currRoom.getTrapDmg() + " damage from a trap.\n");
                io.put("********************************\n");
                currRoom.setTrap(null);
            }
    }
    
    
    
    
}
