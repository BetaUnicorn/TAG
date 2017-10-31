package tag;

import java.util.ArrayList;
import tag.items.Gold;
import tag.items.Item;
import textio.SysTextIO;
import textio.TextIO;

public class Action {

    private final TextIO io = new TextIO(new SysTextIO());

    public void goldPickup(Room currRoom, Human p) {
        if (currRoom.getGold() != 0) {
            p.addCoins(currRoom.getGold());
            io.put("You picked up " + currRoom.getGold() + " gold.\n");
            currRoom.setGold(0);
        }
    }

    /**
     * Takes a Room and a player, add ITEM to player INVENTORY
     *
     * @param Room
     * @param Player
     */
    public void itemPickup(Room currRoom, Human p) {
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 0; i < currRoom.getInventory().getInventory().size(); i++) {
            choices.add(currRoom.getInventory().getInventory().get(i).getName());
        }
        choices.add("Exit");
        int index = io.select("The room holds:", choices, "");
        if (index == currRoom.getInventory().getInventory().size()) {
            //Exit
        } else {
            Item selected = currRoom.getInventory().getInventory().get(index);
            if (selected instanceof Gold) {
                selected.effect(p);
                io.put("You looted " + selected.getName() + "\n");
            } else {
                p.getBag().addBagItem(selected);
                currRoom.getInventory().removeItem(selected);
                io.put("You looted " + selected.getName() + "\n");
            }

        }

    }

    /**
     * Takes a Room and a player, displays player inventory and gives player
     * options for what to do with items in inventory
     *
     * @param Room
     * @param Player
     */
    public void useItem(Human p, Room currRoom) {
        ArrayList<String> choices = new ArrayList<>();

        for (int i = 0; i < p.getBag().getBagSize(); i++) {
            choices.add(p.getBag().getName(i));
        }
        choices.add("Exit");
        int index = io.select("Bag", choices, "");
        if (index == p.getBag().getBagSize()) {
            //Exit
        } else {
            Item selected = p.getBag().getInventory().get(index);
            io.put("What do you want to do with " + selected.getName() + "\n(t)hrow away, (u)se or (n)othing");

            boolean validInput = false;
            do {
                String pInput = io.get();
                //Throw away case
                if (pInput.toLowerCase().equals("t") || pInput.toLowerCase().equals("trash")) {
                    currRoom.getInventory().addBagItem(selected);
                    p.getBag().removeItem(selected);
                    io.put("You threw away " + selected.getName() + " into the room\n");
                    validInput = true;
                } //Use uses item effect and removes it from player bag
                else if (pInput.toLowerCase().equals("u") || pInput.toLowerCase().equals("use")) {
                    selected.effect(p);
                    p.getBag().getInventory().remove(selected);
                    validInput = true;
                } //exit case
                else if (pInput.toLowerCase().equals("n") || pInput.toLowerCase().equals("nothing")) {
                    io.put("You put " + selected + " back in you bag.\n");
                    validInput = true;
                } else {
                    io.put("Please input a valid command.\n");
                }

            } while (validInput == false);

        }

    }

    public void useItemCombat(Human p) {
        ArrayList<String> choices = new ArrayList<>();

        for (int i = 0; i < p.getBag().getBagSize(); i++) {
            choices.add(p.getBag().getName(i));
        }
        choices.add("Exit");
        int index = io.select("Bag", choices, "");
        if (index == p.getBag().getBagSize()) {
            //Exit
        } else {
            Item selected = p.getBag().getInventory().get(index);
            io.put("What do you want to do with " + selected.getName() + "\n(u)se item or (n)othing");

            boolean validInput = false;
            do {
                String pInput = io.get();

                //Use uses item effect and removes it from player bag
                if (pInput.toLowerCase().equals("u") || pInput.toLowerCase().equals("use")) {
                    selected.effect(p);
                    p.getBag().getInventory().remove(selected);
                    validInput = true;
                } //exit case
                else if (pInput.toLowerCase().equals("n") || pInput.toLowerCase().equals("nothing")) {
                    io.put("You put " + selected + " back in you bag.\n");
                    validInput = true;
                } else {
                    io.put("Please input a valid command.\n");
                }

            } while (validInput == false);

        }

    }

    public void monsterDrop(Room monsterCurrRoom, NPC monster) {
        for (int i = 0; i < monster.getInventory().getInventory().size(); i++) {
            monsterCurrRoom.addInventory(monster.getInventory().getInventory().get(i));
        }
    }

    //Switch weapon from equipped to inventory!!!!!!
}
