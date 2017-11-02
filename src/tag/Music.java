/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Martin
 */
public class Music {

    private static Clip clip;

    public static void loadSound(String musicName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(musicName);
        try {
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }

        } catch (IOException e) {

        } catch (UnsupportedAudioFileException e) {

        } catch (LineUnavailableException e) {

        }

    }

    public static void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public static void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

}
