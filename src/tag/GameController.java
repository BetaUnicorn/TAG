package tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import textio.SysTextIO;
import textio.TextIO;

public class GameController {

    private final Setup s = new Setup();
    private final TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();
    private boolean play = true;
    private Room currRoom;
    private LinkedList<Room> roomHist = new LinkedList<>();
    private final Player p = s.newPlayer();
    private final Pickup pick = new Pickup();
    private final Trap trap = new Trap();
    private Room monsterCurrRoom;
    private final Highscore highscore = new Highscore();
    private final Event event = new Event();

    public void play() throws IOException {
        //Setup and player intro
        NPC monster = s.newNpc("Lars", 10000);
        rooms = s.createRooms();
        currRoom = rooms.get(0);
        monsterCurrRoom = rooms.get(11);

        io.put("***********************************************************************************\n"
                + "At a short waterfall in a overcast mountain top marks the entrance to a dungeon. \n"
                + "Beyond this waterfall lies a small coridor.\n"
                + p.getName() + " wakes up in a coridor, without any recollection about how you got there,\n"
                + "and a feeling of disarray.\n"
                + "*********************************************************************************\n");

        io.put("Welcome " + p.getName() + "\nIf you're at any point throughout the game need a list of commands, type 'help' for a list of commands " + "\nPress enter to continue\n");
        io.get();

        goLoop:
        while (play) {

            io.clear();
            io.put("_________________________________________\n");
            io.put("You are standing in " + currRoom.getName() + "\n");
            io.put("-----------------------------------------" + "\n");
            io.put(currRoom.getDesc() + "\n");
            io.put("-----------------------------------------\n");
            
            //Tests for if player has reached final room
            if (currRoom.equals(rooms.get(11))) {
                //io.close();
                play = false;
                break;
            }
            
            //Prints available firections
            io.put(getDir());
            
            //GOLD AND TRAP TEST
            pick.goldPickup(currRoom, p);
            trap.checkTrap(currRoom, p);
            
            //Checks if player health if above 0, if not the game is lost
            if (p.getHealth() <= 0) {
                deathNote();
                play = false;
                break;
            }
            
            //Add room to room history
            addRoomHistory(currRoom);
            
            //Player takes turn
            currRoom = pInput();
            
            //Checks for mpnster collision
            if (currRoom.equals(monsterCurrRoom)) {
                event.monsterCollision(currRoom, monsterCurrRoom, p, monster);
                play = false;
                break;
            }
            
            monsterCurrRoom = monster.takeTurn(monsterCurrRoom);
            io.put(monsterCurrRoom.toString());
        }

        if (!roomHist.isEmpty()) {
            io.put("Room histroy: " + roomHist.toString() + "\n\n");
        }

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Takes player input commands, and processes it.
     *
     * @return Room
     */
    public Room pInput() {
        Room nextRoom = currRoom;
        boolean go = true;

        while (go) {

            io.put("What do you want to do?");

            switch (io.get().toLowerCase()) {
                case "n":
                case "north":
                    if (currRoom.getNorth() != null) {
                        nextRoom = currRoom.getNorth();
                        go = false;
                    } else {
                        io.put("You can't go North \n");
                    }
                    break;

                case "s":
                case "south":
                    if (currRoom.getSouth() != null) {
                        nextRoom = currRoom.getSouth();
                        go = false;
                    } else {
                        io.put("You can't go South \n");
                    }
                    break;

                case "e":
                case "east":
                    if (currRoom.getEast() != null) {
                        nextRoom = currRoom.getEast();
                        go = false;
                    } else {
                        io.put("You can't go East \n");
                    }
                    break;

                case "w":
                case "west":
                    if (currRoom.getWest() != null) {
                        nextRoom = currRoom.getWest();
                        go = false;
                    } else {
                        io.put("You can't go West \n");
                    }
                    break;

                case "q":
                case "quit":
                    io.put("Game Over\n");
                    play = false;
                    go = false;
                    break;

                case "h":
                case "help":
                    io.put("N & NORTH\tMove Northern direction\n"
                            + "S & SOUTH\tMove Southern direction\n"
                            + "E & EAST\tMove Eastern direction\n"
                            + "W & WEST\tMove Western direction\n"
                            + "Q & QUIT\tEnd Game\n"
                            + "Inspect\t\tSee if the room contains items, and loot\n"
                            + "Inv\t\tSee Inventory (Select item to use it)\n"
                            + "Trash\t\tThrow an item from your inventory, into the room\n"
                            + "STATS\t\tSee stats\n" 
                            + "\n");
                    break;

                case "stats":
                    io.put("----------------------------------------------\n");
                    io.put(p.getName() + "\n"
                            + p.getHealth() + " HP \n"
                            + p.getBank() + " Gold \n");
                    io.put("----------------------------------------------\n");

                    break;
                
                case "inspect":
                    p.loot(currRoom, p);
                    break;
                    
                case "inv":
                    p.useItem(p);
                    break;
                
                case "trash":
                    p.trash(currRoom, p);
                    break;

                default:
                    io.put("Please pick a valid command...\n\n");
                    break;

            }
        }

        return nextRoom;
    }

    private String getDir() {
        StringBuilder str = new StringBuilder();

        str.append("You see doors in the following directions:  ");
        if (currRoom.getNorth() != null) {
            str.append("|North|");
        }
        if (currRoom.getSouth() != null) {
            str.append("|South|");
        }
        if (currRoom.getEast() != null) {
            str.append("|East|");
        }
        if (currRoom.getWest() != null) {
            str.append("|West|");
        }

        str.append("\n");

        return str.toString();
    }

    public void addRoomHistory(Room room) {
        roomHist.add(room);
    }

    public Room getRoom() {
        return currRoom;
    }
    
    public void setPlay(boolean play) {
        this.play = play;
    }

    public void deathNote() throws IOException {
        io.put("You are dead \n");
        io.put("Here are all the people who did it better than you. \n");
        io.put(highscore.showScores());
    }

}
