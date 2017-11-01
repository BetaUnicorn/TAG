package tag;

import java.util.ArrayList;
import tag.items.Gold;
import tag.items.Item;
import tag.items.Potion;
import tag.items.Weapon;
import tag.items.WeirdPotion;
import textio.SysTextIO;
import textio.TextIO;

public class Setup {

    TextIO io = new TextIO(new SysTextIO());
    Human p;

    public Human newPlayer() {
        io.put("Input name: ");
        return p = new Human(io.get());
    }

    public ArrayList<NPC> newNpc() {
        ArrayList<NPC> monsters = new ArrayList<>();
        monsters.add(new Monster("Lars, The Dragon", 10, new Weapon("Soul Edge", 15)));
        monsters.add(new Monster("Iron Fist", 30, new Weapon("Iron Fists", 20)));
        monsters.add(new Monster("Ogre", 40, new Weapon("Fire breath", 30)));
        monsters.add(new Monster("The Joker", 50, new Weapon("Gun", 35)));
        monsters.add(new Monster("King Dedede", 55, new Weapon("Hammer", 40)));
        monsters.add(new Monster("Deathwing", 60, new Weapon("World ending breath", 50)));

        //Lars Inventory
        monsters.get(0).getInventory().addBagItem(new Potion(30, "Health Potion"));
        monsters.get(0).getInventory().addBagItem(new Potion(40, "Health Potion"));
        monsters.get(0).getInventory().addBagItem(monsters.get(0).getWeapon());
        monsters.get(0).getInventory().addBagItem(new Gold(100));

        //IronFist Inventory
        monsters.get(1).getInventory().addBagItem(new Potion(20, "Health Potion"));
        monsters.get(1).getInventory().addBagItem(monsters.get(1).getWeapon());
        monsters.get(1).getInventory().addBagItem(new Gold(50));

        //Ogre inventory
        monsters.get(2).getInventory().addBagItem(new Potion(30, "Health Potion"));
        monsters.get(2).getInventory().addBagItem(monsters.get(2).getWeapon());
        monsters.get(2).getInventory().addBagItem(new Gold(50));

        //The Joker
        monsters.get(3).getInventory().addBagItem(new Potion(20, "Health Potion"));
        monsters.get(3).getInventory().addBagItem(monsters.get(3).getWeapon());
        monsters.get(3).getInventory().addBagItem(new Gold(100));

        //King Dedede
        monsters.get(4).getInventory().addBagItem(new Potion(30, "Health Potion"));
        monsters.get(4).getInventory().addBagItem(monsters.get(4).getWeapon());
        monsters.get(4).getInventory().addBagItem(new Gold(150));

        return monsters;
    }

    public ArrayList<Room> createRooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Entrance", "In the room there is barely any light except for the few wall torches.\n"
                + "when you look around, you see a room decayed by time.\n"
                + "Skeletons on the ground covered in spiderwebs, and empty barrels. \n",
                "feeling disoriented but determined"));
        rooms.add(new Room("Pottery Room", p.getName() + " walks carefully into room.\n"
                + "the room is filled with broken glass and pottery.\n",
                "Feeling Anxious"));
        rooms.add(new Room("Dragon Lair", p.getName() + " enters the room, it is bright enough so you can see clearly. \n"
                + "you see two statues of dragons and a few empty crates and not much else.\n",
                "feeling discouraged but still curious."));
        rooms.add(new Room("Unsuspicious room", p.getName() + " walks proudly into the room. before you is a dragon's hoard of treasure. \n"
                + "Coins cover every inch of the room, \n"
                + "and jeweled objects of precious metal jut up from the money like glittering islands in a sea of gold\n"
                + "but wait!!! oh no!!!\n",
                "feeling Stupid"));
        rooms.add(new Room("Igloo Room", p.getName() + " enters a room.\n"
                + "where there appears to be ice on the walls.\n",
                "feeling cold."));
        rooms.add(new Room("Stone Room", "This otherwise bare room has one distinguishing feature. \n"
                + "The stone around one of the other doors has been pulled over its edges, \n"
                + "as though the rock were as soft as clay and could be moved with fingers.\n"
                + "The stone of the door and wall seems hastily molded together.\n",
                "feeling Tired"));
        rooms.add(new Room("Bathroom", "This room holds six dry circular basins large enough to hold a man and a dry fountain at its center. \n"
                + "All possess chipped carvings of merfolk and other sea creatures. \n"
                + "It looks like this room once served some group of people as a bath.\n",
                "feeling hopeful"));
        rooms.add(new Room("Fire pit", "You open the door and a gout of flame rushes at your face. \n"
                + "A wave of heat strikes you at the same time and light fills the hall. \n"
                + "The room beyond the door is ablaze! \n"
                + "An inferno engulfs the place, clinging to bare rock and burning without fuel.\n",
                "feeling burned out"));
        rooms.add(new Room("Spider Room", p.getName() + " walks into room\n"
                + "Thick cobwebs fill the corners of the room,\n"
                + "and wisps of webbing hang from the ceiling and waver in a wind you can barely feel\n",
                "feeling Afraid"));
        rooms.add(new Room("Chamber", "you burst into the room\n"
                + "This small bare chamber holds nothing but a large empty ironbound chest, \n"
                + "which is big enough for a man to fit in.\n",
                "feeling dissapointed"));
        rooms.add(new Room("Throne Room", p.getName() + " enters a room with a massive black throne, on it sits a\n"
                + "creature in full plate. The creature almost seems alive.\n",
                "feeling Ready"));
        rooms.add(new Room("Final Destination", "A tall granite door opens up. with countless runes all over.\n"
                + "it is somehow untouched by the elements.\n"
                + "you step closer to it to get a better look and it opens.\n"
                + p.getName() + " enter into, the final Room of the dungeon.\n"
                + "Before you stands a humongus Dragon, clad in crimson scales, \n"
                + "like the colour of the fire it spews.\n"
                + "you glance at it's long sharp claws, capable of slicing you apart with a single grace. \n"
                + "The dragon gets a glimpse of you, and when it realizes that you are standing \n"
                + "in its room. It starts charging against you. \n", "feeling nerveous"));

//                + "Behind the dragon you notice a door it's your only chance.\n"
//                + "you look at the dragon it hasen't noticed you. \n"
//                + "you run for the door in a desperate attempt, it worked you reached the door and you escaped with your life.\n"
//                + "Feeling Happy and Victorious", "FEEEEELING"));
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
        rooms.get(1).addInventory(new Potion(20, "Health Potion"));
        rooms.get(4).addInventory(new Potion(40, "Health Potion"));
        rooms.get(3).addInventory(new WeirdPotion(35, "Weird Potion"));
        rooms.get(1).addInventory(new Weapon("Bastard Sword", 10));
        rooms.get(5).addInventory(new Potion(40, "Health Potion"));

        //ADD GOLD TO ROOMS
        rooms.get(1).addInventory(new Gold(5));
        rooms.get(2).addInventory(new Gold(10));
        rooms.get(3).addInventory(new Gold(20));
        rooms.get(4).addInventory(new Gold(10));
        rooms.get(5).addInventory(new Gold(30));
        rooms.get(6).addInventory(new Gold(35));
        rooms.get(7).addInventory(new Gold(5));
        rooms.get(8).addInventory(new Gold(10));
        rooms.get(9).addInventory(new Gold(20));
        rooms.get(10).addInventory(new Gold(50));

        return rooms;
    }

}
