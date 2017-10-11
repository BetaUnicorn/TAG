package tag;

import java.util.ArrayList;
import java.util.LinkedList;
import textio.SysTextIO;
import textio.TextIO;

public class GameController {

    private Setup s = new Setup();
    private TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();
    private boolean play = true;
    private Room currRoom;
    private LinkedList<Room> roomHist = new LinkedList<>();
    ;
    Player p = s.newPlayer();

    public void play() {

        rooms = s.createRooms();
        currRoom = rooms.get(0);

        io.put("Welcome to TAG... \n");

        io.put("Welcome " + p.getName() + "\n");
        
        goLoop:
        while (play) {
            io.clear();
            io.put("_________________________________________\n");
            io.put("You are standing in " + currRoom.getName() + "\n");
            io.put("-----------------------------------------" + "\n");
            io.put(currRoom.getDesc() + "\n");
            io.put("-----------------------------------------\n");
            io.put(getDir());

            // io.put("You see doors in the following directions: ");
            //TODO: prints the direction options the player has
            //TODO: Linked list remebers path through the dungeon.
            p.addCoins(currRoom.getGold());

            if (currRoom.getTrap() != null) {
                p.changeHP(currRoom.getTrapDmg());
                io.put("********************************\n");
                io.put("You took " + currRoom.getTrapDmg() + " damage from a trap.\n");
                io.put("********************************\n");
            }

            addRoomHistory(currRoom);
            currRoom = pInput();

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
                    io.put("N & NORTH\tmove Northern direction\n"
                            + "S & SOUTH\tmove Southern direction\n"
                            + "E & EAST\tmove Eastern direction\n"
                            + "W & WEST\tmove Western direction\n"
                            + "Q & QUIT\tEnd Game\n"
                            + "\n");
                    break;

                case "stats":
                    io.put("----------------------------------------------\n");
                    io.put(p.getName() + "\n"
                            + p.getHealth() + " HP \n"
                            +p.getBank() + " Gold \n" );
                    io.put("----------------------------------------------\n");

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

    private void addRoomHistory(Room room) {
        roomHist.add(room);
    }
}
