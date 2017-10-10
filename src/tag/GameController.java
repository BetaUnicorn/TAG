
package tag;

import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;

public class GameController {
    private Setup s = new Setup();
    private TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();
    private boolean go = true;
    private Room currRoom;
    
    
    public void play() {
        
        rooms = s.createRooms();
        currRoom = rooms.get(0);
        
        io.put("Welcome to TAG... \n");
        
        Player p = s.newPlayer();
        
        io.put("Welcome " + p.getName() + "\n");
        
        while(go) {
            io.clear();
            io.put("_________________________________________\n");
            io.put("You are standing in " + currRoom.getName() + "\n");
            io.put("-----------------------------------------" + "\n");
            io.put(currRoom.getDesc() + "\n");
            io.put("-----------------------------------------\n");
            
           // io.put("You see doors in the following directions: ");
            //TODO: prints the direction options the player has
            //TODO: Linked list remebers path through the dungeon.
            
            currRoom = pInput();
            
        }
        
        
        
    }
    
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    
    /**
     * Takes player input commands, and processes it.
     * @return Room
     */
    
    //change to playerInput/pInput
    public Room pInput() {
        Room nextRoom = currRoom;
        boolean go = true;
        
        while (go) {
        
            io.put("Which way do you want to go?");
        
        switch(io.get().toLowerCase()) {
            case "n":
            case "north":
                if(currRoom.getNorth() != null) {
                    nextRoom = currRoom.getNorth();
                    go = false;
                }
                else {
                   io.put("You can't go North \n");
                }
                break;
            
            case "s":
            case "south":
                if(currRoom.getSouth() != null) {
                    nextRoom = currRoom.getSouth();
                    go = false;
                }
                else {
                   io.put("You can't go South \n");
                }
                break;
            
            case "e":
            case "east":
                if(currRoom.getEast() != null) {
                    nextRoom = currRoom.getEast();
                    go = false;
                }
                else {
                   io.put("You can't go East \n");
                }
                break;
            
            case "w" :
            case "west":
                if(currRoom.getWest() != null) {
                    nextRoom = currRoom.getWest();
                    go = false;
                }
                else {
                   io.put("You can't go West \n");
                }
                break;
                
            default:
                io.put("Please pick a valid command bitch...\n\n");
                break;
                
        }
        }
        
        
        return nextRoom;
    }
}
