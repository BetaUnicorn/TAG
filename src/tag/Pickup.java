package tag;

public class Pickup {
    
    public void goldPickup(Room currRoom, Player p) {
        p.addCoins(currRoom.getGold());
    }
    
    public void itemPickup(Room currRoom, Bag bag) {
        if (currRoom.getItem() != null) {
            bag.addBagItem(currRoom.getItem());
        }
    }
}
