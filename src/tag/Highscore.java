package tag;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore {

    private String name;
    private int score;

    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public Highscore()
    {
        
    }

    public class scoreCompare implements Comparator<Highscore> {

        @Override
        public int compare(Highscore h1, Highscore h2) {
            return h2.score - h1.score;
        }

    }

    public String showScores() throws IOException {
        System.out.println("*********************************SCORE*********************************");
        sortHighscore();
        StringBuilder oldScores = new StringBuilder();
        String line = "";

        File file = new File("scores.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int i = 0;
        while ((line = reader.readLine()) != null && i < 10) {
            oldScores.append(line + "\r\n");
            i++;
        }
        reader.close();

        return oldScores.toString();
       
    }

    public void addScore(Human p) throws FileNotFoundException, IOException {
        StringBuilder oldScores = new StringBuilder();
        String newScore;
        String line = "";

        File file = new File("scores.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((line = reader.readLine()) != null) {
            oldScores.append(line + "\r\n");
        }
        reader.close();

        newScore = oldScores.append(p.getName() + " " + p.getBank() + "\r\n").toString();
        FileWriter writer = new FileWriter("scores.txt");
        writer.write(newScore);
        writer.close();
        
    }

    public void sortHighscore() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));

        ArrayList<Highscore> scores = new ArrayList<>();

        String line = reader.readLine();

        while (line != null) {
            String[] scoreDetail = line.split(" ");
            String name = scoreDetail[0];
            int score = Integer.valueOf(scoreDetail[1]);

            scores.add(new Highscore(name, score));

            line = reader.readLine();
        }
        
        Collections.sort(scores, new scoreCompare());
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"));
        
        for(Highscore h : scores)
        {
            writer.write(h.name);
            writer.write(" " + h.score);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

}
