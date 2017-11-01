package tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import tag.items.Weapon;
import textio.SysTextIO;
import textio.TextIO;

public class GameController {

    private final Setup s = new Setup();
    private final TextIO io = new TextIO(new SysTextIO());
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<NPC> monsters = new ArrayList<>();
    private boolean play = true;
    private Room currRoom;
    private Room prevRoom;
    private LinkedList<Room> roomHist = new LinkedList<>();
    private final Human p = s.newPlayer();
    private final Action pick = new Action();
    private final Trap trap = new Trap();
    private Room monsterCurrRoom;
    private final Highscore highscore = new Highscore();
    private boolean isDead = false;

    public void play() throws IOException {
        //Setup and player intro
        monsters = s.newNpc();
        rooms = s.createRooms();
        currRoom = rooms.get(0);
        monsters.get(0).setRoom(rooms.get(2));
        monsters.get(1).setRoom(rooms.get(11));
        p.setEquippedWeapon(new Weapon("Rusty Dagger", 5));

        io.put("***********************************************************************************\n"
                + "At a short waterfall in a overcast mountain top marks the entrance to a dungeon. \n"
                + "Beyond this waterfall lies a small coridor.\n"
                + p.getName() + " wakes up in a coridor, with a rusty dagger at his side, without any recollection about how you got there,\n"
                + "and a feeling of disarray.\n"
                + "*********************************************************************************\n");

        io.put("Welcome " + p.getName() + "\nIf you're at any point throughout the game need help, type 'help' for a list of commands " + "\nPress enter to continue\n");
        io.get();

        goLoop:
        while (play) {

            io.clear();
            io.put("_________________________________________\n");
            io.put("You are standing in " + currRoom.getName() + "\n");
            io.put("-----------------------------------------" + "\n");
            io.put(currRoom.getDesc());
            io.put("-----------------------------------------\n");
            io.put(currRoom.getFeeling() + "\n");
            io.put("-----------------------------------------\n");

            //Tests for if player has reached final room
            if (monsters.get(monsters.size() - 1).getCurrRoom().equals(currRoom)) {
                io.put("***********************************************\n");
                io.put("You met " + monsters.get(monsters.size() - 1).getName() + "\n");
                io.put("***********************************************\n");
                isDead = combatOptions(p, monsters.get(monsters.size() - 1));
                if (isDead == true) {
                    deathNote();
                    break;
                }
                addRoomHistory(currRoom);
                highscore.addScore(p);
                io.put(highscore.showScores());
                play = false;
                break;

            }

            //Prints available firections
            io.put(getDir());

            //TRAP TEST
            trap.checkTrap(currRoom, p);

            //Checks if player health if above 0, if not the game is lost
            if (p.getHealth() <= 0) {
                deathNote();
                play = false;
                break;
            }

            //Add room to room history
            addRoomHistory(currRoom);

            //Checks for monster collision
            for (int i = 0; i < monsters.size(); i++) {
                if (currRoom.equals(monsters.get(i).getCurrRoom())) {
                    io.put("***********************************************\n");
                    io.put("You met " + monsters.get(i).getName() + "\n");
                    io.put("***********************************************\n");
                    isDead = combatOptions(p, monsters.get(i));
                    if (isDead == true) {
                        deathNote();
                        break;
                    }

                }
            }

            //Player takes turn
            prevRoom = currRoom;
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
                    io.put("N & NORTH\tMove Northern direction\n"
                            + "S & SOUTH\tMove Southern direction\n"
                            + "E & EAST\tMove Eastern direction\n"
                            + "W & WEST\tMove Western direction\n"
                            + "Q & QUIT\tEnd Game\n"
                            + "INSPECT\t\tSee if the room contains items, and loot\n"
                            + "INV\t\tSee Inventory (Select item to use it or throw it away)\n"
                            + "STATS\t\tSee stats\n"
                            + "DIR\t\tShow possible directions"
                            + "\n");
                    break;

                case "stats":
                    io.put("----------------------------------------------\n");
                    io.put(p.getName() + "\n"
                            + p.getHealth() + " HP \n"
                            + p.getBank() + " Gold \n"
                            + p.getWeaponEquipped());

                    io.put("----------------------------------------------\n");

                    break;

                case "inspect":
                    p.loot(currRoom, p);
                    break;

                case "inv":
                    p.useItem(p, currRoom);
                    break;
                case "dir":
                    io.put(getDir());
                    break;

                default:
                    io.put("Please pick a valid command...\n\n");
                    break;

            }
        }

        return nextRoom;
    }

    public boolean combatOptions(Players p, NPC monster) {
        Combat c = new Combat();
        boolean isDead = false;
        boolean validInput = true;
        io.put("(f)ight or (r)un\n");
        do {

            switch (io.get().toLowerCase()) {
                case "f":
                case "fight":
                    validInput = false;
                    isDead = c.combatScenario(p, monster, currRoom, monsters);
                    return isDead;
                case "r":
                case "run":
                    validInput = false;
                    currRoom = prevRoom;
                    io.put("You ran away from " + monster.getName() + ", into " + currRoom.getName() + "\n");
                    break;

                default:
                    io.put("Please input a valid command.\n");
                    break;
            }

        } while (validInput);
        return isDead;
    }

    public String getDir() {
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

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

}
