/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class RandomMovementTest {
    
    RandomMovement ran = new RandomMovement();
    Room room = new Room("testRoom", "testdesc", "testfeel");
    Room room2 = new Room("test2", "dsf", "af");
    
    
    public RandomMovementTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testTakeTurn() {
        room.setEast(room2);
        
        assertEquals(ran.takeTurn(room), room2);
        
    }
    
}
