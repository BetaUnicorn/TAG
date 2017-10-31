package tag;

import tag.items.Weapon;

public interface NPC extends Players{
    public Room takeTurn(Room currRoom);
    
    public MonsterInventory getInventory();
    
    public Weapon getWeapon();
    
    public Room getCurrRoom();
    
    public void setRoom(Room monsterCurrRoom);
}
