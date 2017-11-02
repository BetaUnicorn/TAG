/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Martin
 */
public class Music {

    private static AudioPlayer player = AudioPlayer.player;
    private static AudioStream stream;
    private static AudioData MD;
    private static ContinuousAudioDataStream loop = null;
    

    public static void battleMusic() throws FileNotFoundException, IOException {

        try {

            InputStream battleMusic = new FileInputStream("long.wav");

            stream = new AudioStream(battleMusic);
            player.start(stream);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public static void stopMusic() {
        if (stream != null) {
            player.stop(stream);
        }
    }

    public static void bgMusic() {
        try {

            InputStream battleMusic = new FileInputStream("short.wav");

            stream = new AudioStream(battleMusic);
            //player.start(stream);
            MD = stream.getData();
            loop = new ContinuousAudioDataStream(MD);
            player.start(loop);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
    
    public static void stopBgMusic(){
        if(loop != null){
            player.stop(loop);
        }
    }

}
