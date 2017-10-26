package tag;

import java.util.ArrayList;
import tag.items.Item;
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
    
    /**
     * Takes a Room and a player, add ITEM to player INVENTORY
     * @param Room
     * @param Player 
     */
    public void itemPickup(Room currRoom, Player p) {
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 0; i < currRoom.getInventory().getInventory().size(); i++) {
            choices.add(currRoom.getInventory().getInventory().get(i).getName());
        }
        choices.add("Exit");
        int index = io.select("The room holds:", choices, "");
        if(index == currRoom.getInventory().getInventory().size()){
            //Exit
        }else{
            Item selected = currRoom.getInventory().getInventory().get(index);
            p.getBag().addBagItem(selected);
            currRoom.getInventory().removeItem(selected);
            io.put("You looted " + selected.getName() + "\n");
            
        }
       
    }
    
    /**
     * Takes a Room and a player, throws away an ITEM into the rooms INVENTORY
     * @param Room
     * @param Player 
     */
    public void itemTrash(Room currRoom, Player p) {
        ArrayList<String> choices = new ArrayList<>();
        
        for (int i = 0; i < p.getBag().getBagSize(); i++) {
            choices.add(p.getBag().getName(i));
        }
        choices.add("Exit");
        int index = io.select("Bag:", choices, "");
        if(index == p.getBag().getBagSize()){
            //Exit
        }else{
            Item selected = p.getBag().getInventory().get(index);
            currRoom.getInventory().addBagItem(selected);
            p.getBag().removeItem(selected);
            io.put("You threw away " + selected.getName() + " into the room\n");
        }
    }
    
    public void useItem(Player p) {
        ArrayList<String> choices = new ArrayList<>();
        
        
        for (int i = 0; i < p.getBag().getBagSize(); i++) {
            choices.add(p.getBag().getName(i));
        }
        choices.add("Exit");
        int index = io.select("Bag", choices, "");
        if(index == p.getBag().getBagSize()){
            //Exit
        }else{
            Item selected = p.getBag().getInventory().get(index);
            selected.effect(p);
            p.getBag().getInventory().remove(selected);
        }

    }
}
