package tag;

import textio.SysTextIO;
import textio.TextIO;

public class Pickup {
    private final TextIO io = new TextIO(new SysTextIO());
    public void goldPickup(Room currRoom, Player p) {
        p.addCoins(currRoom.getGold());
    }
    
    public void itemPickup(Room currRoom, Bag bag) {
        if (currRoom.getItem() != null) {
            bag.addBagItem(currRoom.getItem());
            io.put("You picked up " + currRoom.getItem().getName() + " \n");
            currRoom.setItem(null);
            
        }
    }
}
