/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Highscore {
    private String name;
    private int score;
    private ArrayList<String> scores = new ArrayList<>();
    
    
//    public String showScores(){
//       
//    }
    
    public void addScore(Player p) throws FileNotFoundException, IOException
    {
        StringBuilder oldScores = new StringBuilder();
        String newScore;
        String line = "";
        
        File file = new File("scores.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        while((line = reader.readLine()) != null)
        {
            oldScores.append(line + "\r\n");
        }
        reader.close();
        
        newScore = oldScores.append(p.getName() + ", " + p.getBank() + "\r\n").toString();
        FileWriter writer = new FileWriter("scores.txt");
        writer.write(newScore);
        writer.close();
    }
    
}
