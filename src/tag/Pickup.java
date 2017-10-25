package tag;

import textio.SysTextIO;
import textio.TextIO;

public class Pickup {
    private final TextIO io = new TextIO(new SysTextIO());
    public void goldPickup(Room currRoom, Player p) {
        if (currRoom.getGold() != 0) {
            p.addCoins(currRoom.getGold());
            io.put("You picked up " + currRoom.getGold() + " gold.\n");
            currRoom.setGold(0);
        }
    }
    
    public void itemPickup(Room currRoom, Bag bag) {
        if (currRoom.getItem() != null) {
            bag.addBagItem(currRoom.getItem());
            io.put("You picked up " + currRoom.getItem().getName() + " \n");
            currRoom.setItem(null);
            
        }
    }
}
