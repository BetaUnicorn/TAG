package tag;

import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;


public class Setup {
    TextIO io = new TextIO(new SysTextIO());
    Player p;
    
    public Player newPlayer() {
        io.put("Input name: ");
        return p = new Player(io.get());
    }
    
    public ArrayList<Room> createRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        
        
        rooms.add(new Room("Entrance", "You're standing at the entrance to a dungeon, right in front of you is a wooden door, surrounded by a stone wall.", "You are feeling determined!", 0));
        rooms.add(new Room("Room1", "DESCRIPTIIIIOOOONN", "FEEEEELING", 10));
        rooms.add(new Room("room2", "DESCRIPTIIIIOOOONN", "FEEEEELING", 5));
        rooms.add(new Room("room3", "DESCRIPTIIIIOOOONN", "FEEEEELING", 0));
        rooms.add(new Room("room4", "DESCRIPTIIIIOOOONN", "FEEEEELING", 3));
        rooms.add(new Room("room5", "DESCRIPTIIIIOOOONN", "FEEEEELING", 4));
        rooms.add(new Room("room6", "DESCRIPTIIIIOOOONN", "FEEEEELING", 0));
        rooms.add(new Room("room7", "DESCRIPTIIIIOOOONN", "FEEEEELING", 15));
        rooms.add(new Room("room8", "DESCRIPTIIIIOOOONN", "FEEEEELING", 5));
        rooms.add(new Room("room9", "DESCRIPTIIIIOOOONN", "FEEEEELING", 6));
        rooms.add(new Room("room10", "DESCRIPTIIIIOOOONN", "FEEEEELING", 0));
        rooms.add(new Room("FinalRoom", "DESCRIPTIIIIOOOONN", "FEEEEELING", 50));
        
        // sets connections between the rooms
        
        //Entrance connection to room 1
        rooms.get(0).setNorth(rooms.get(1));
        rooms.get(1).setSouth(rooms.get(0));
        
        //Connections for room 1 - 2 & 1 - 3
        rooms.get(1).setWest(rooms.get(2));
        rooms.get(2).setEast(rooms.get(1));
        
        rooms.get(1).setEast(rooms.get(3));
        rooms.get(3).setWest(rooms.get(1));
        
        //Connection for room 2 -4
        rooms.get(2).setNorth(rooms.get(4));
        rooms.get(4).setSouth(rooms.get(2));
        
        //Connections for room 4 - 5
        rooms.get(4).setNorth(rooms.get(5));
        rooms.get(5).setSouth(rooms.get(4));
        
        //Conections for toom 5 - 6
        rooms.get(5).setEast(rooms.get(6));
        rooms.get(6).setWest(rooms.get(5));
        
        //Conections for toom 6 - 7 & 6 - 8
        rooms.get(6).setEast(rooms.get(8));
        rooms.get(8).setWest(rooms.get(6));
        
        rooms.get(6).setSouth(rooms.get(7));
        rooms.get(7).setNorth(rooms.get(6));
        
        //Connection for room 8-9
        rooms.get(8).setNorth(rooms.get(9));
        rooms.get(9).setSouth(rooms.get(8));
        
        //Conections for room 9 - 10
        rooms.get(9).setEast(rooms.get(10));
        rooms.get(10).setWest(rooms.get(9));
        
        //Conections for room 10 - final
        rooms.get(10).setNorth(rooms.get(11));
        rooms.get(11).setWest(rooms.get(10));
        
        
        return rooms;
    }
    
}
