package tag;

import java.util.ArrayList;
import tag.items.Item;
import textio.SysTextIO;
import textio.TextIO;

public class Bag {

    private final TextIO io = new TextIO(new SysTextIO());
    ArrayList<Item> items = new ArrayList<>();

    public void addBagItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return items.toString();
    }

    public void useItem(Player p) {
        ArrayList<String> choices = new ArrayList<>();
        
        
        for (Item item : p.getBag().items) {
            choices.add(item.getName());
        }
        choices.add("Exit");
        int index = io.select("Bag", choices, "");
        if(index == items.size()){
            //Exit
        }else{
            Item selected = p.getBag().items.get(index);
            selected.effect(p);
            items.remove(selected);
        }

    }
}
