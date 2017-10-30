/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Martin
 */
public class RandomMovement {
    private ArrayList<Room> dir = new ArrayList<>();
    private Random rand;

    public Room takeTurn(Room currRoom) {
        rand = new Random();
        
        if (currRoom.getNorth() != null) {
            dir.add(currRoom.getNorth());
        }
        if (currRoom.getSouth() != null) {
            dir.add(currRoom.getSouth());
        }
        if (currRoom.getEast() != null) {
            dir.add(currRoom.getEast());
        }
        if (currRoom.getWest() != null) {
            dir.add(currRoom.getWest());
        }
       
        int index = rand.nextInt(dir.size());
        Room nextRoom = dir.get(index);
        dir.clear();
        return nextRoom;
        
    }
}
