package tag;

import java.util.ArrayList;
import tag.items.Potion;
import textio.SysTextIO;
import textio.TextIO;

public class Setup {

    TextIO io = new TextIO(new SysTextIO());
    Player p;

    public Player newPlayer() {
        io.put("Input name: ");
        return p = new Player(io.get());
    }
    
    public NPC newNpc(String name, int hp){
        return new Monster(name, hp);
    }

    public ArrayList<Room> createRooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Entrance", "In the room there is barely any light except for the few wall torches.\n"
                + "when you look around, you see a room decayed by time.\n"
                + "Skeletons on the ground covered in spiderwebs, and empty barrels. \n"
                + "You feel disoriented but determined", "", 0));
        rooms.add(new Room("Room1", p.getName() + " enters the room, it is bright enough so you can see clearly. \n"
                + "you see two statues of dragons and a few empty crates and not much else.\n"
                + "you feel discouraged but still curious.", "FEEEEELING", 10));
        rooms.add(new Room("room2", p.getName() + " walks carefully into room.\n"
                + "the room is filled with broken glass and pottery.\n"
                + "Feeling Anxious", "FEEEEELING", 5));
        rooms.add(new Room("Trap room", p.getName() + " walks proudly into the room. before you is a dragon's hoard of treasure. \n"
                + "Coins cover every inch of the room, \n"
                + "and jeweled objects of precious metal jut up from the money like glittering islands in a sea of gold\n"
                + "but wait!!! oh no!!!\n"
                + "Feeling Stupid", "FEEEEELING", 0));
        rooms.add(new Room("room4", p.getName() + " enters a room.\n"
                + "where there appears to be ice on the walls.\n"
                + "Feeling Perplexed.", "FEEEEELING", 3));
        rooms.add(new Room("room5", "This otherwise bare room has one distinguishing feature. \n"
                + "The stone around one of the other doors has been pulled over its edges, \n"
                + "as though the rock were as soft as clay and could be moved with fingers.\n"
                + "The stone of the door and wall seems hastily molded together.\n"
                + "Feeling Tired", "FEEEEELING", 4));
        rooms.add(new Room("room6", "This room holds six dry circular basins large enough to hold a man and a dry fountain at its center. \n"
                + "All possess chipped carvings of merfolk and other sea creatures. \n"
                + "It looks like this room once served some group of people as a bath.\n"
                + "Feeling hopeful", "FEEEEELING", 0));
        rooms.add(new Room("Fire pit", "You open the door and a gout of flame rushes at your face. \n"
                + "A wave of heat strikes you at the same time and light fills the hall. \n"
                + "The room beyond the door is ablaze! \n"
                + "An inferno engulfs the place, clinging to bare rock and burning without fuel.\n"
                + "Feeling burned out", "FEEEEELING", 15));
        rooms.add(new Room("room8", p.getName() + " walks into room\n"
                + "Thick cobwebs fill the corners of the room,\n"
                + "and wisps of webbing hang from the ceiling and waver in a wind you can barely feel\n"
                + "Feeling Afraid", "FEEEEELING", 5));
        rooms.add(new Room("room9", "you burst into the room\n"
                + "This small bare chamber holds nothing but a large empty ironbound chest, \n"
                + "which is big enough for a man to fit in.\n"
                + "feeling dissapointed", "FEEEEELING", 6));
        rooms.add(new Room("room10", p.getName() + " enters a room with a massive black throne, on it sits a\n"
                + "creature in full plate. The creature almost seems alive.\n"
                + "Feeling Ready", "FEEEEELING", 0));
        rooms.add(new Room("FinalRoom", "A tall granite door opens up. with countless runes all over.\n"
                + "it is somehow untouched by the elements.\n"
                + "you step closer to it to get a better look and it opens.\n"
                + p.getName() + " enter into, the final Room of the dungeon.\n"
                + "Before you stands a humongus Dragon, clad in crimson scales, \n"
                + "like the colour of the fire it spews.\n"
                + "you glance at it's long sharp claws, capable of slicing you apart with a single grace. \n"
                + "and begin to realize you have no shred of a chance to survive. \n"
                + "frigthened you try to push the door behind and escape but it won't budge. \n"
                + "Behind the dragon you notice a door it's your only chance.\n"
                + "you look at the dragon it hasen't noticed you. \n"
                + "you run for the door in a desperate attempt, it worked you reached the door and you escaped with your life.\n"
                + "Feeling Happy and Victorious", "FEEEEELING", 50));

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
        rooms.get(9).setWest(rooms.get(10));
        rooms.get(10).setEast(rooms.get(9));

        //Conections for room 10 - final
        rooms.get(10).setNorth(rooms.get(11));
        rooms.get(11).setSouth(rooms.get(10));

        //Sets up traps for the rooms 3 and 7
        rooms.get(3).setTrap(new Trap(-4));
        rooms.get(7).setTrap(new Trap(-5));

        //add items to rooms
        rooms.get(1).setItem(new Potion(10, "Health Potion"));
        
        
        return rooms;
    }

}
