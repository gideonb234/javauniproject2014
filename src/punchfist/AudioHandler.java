/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

// imports
import javax.sound.sampled.*; 
import city.cs.engine.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles audio in the game, with different constructors used for different types of audio in game
 * @author gideon
 */
public class AudioHandler {
    // variables
    private String soundName;
    private File soundFile;
    private AudioInputStream audioIn;
    private Clip soundClip;
    
    // set sound file name
    public AudioHandler(String f) {
        soundName = f;
    }
    
    public void playSound() throws IOException {
        // grabs file from soundclip name 
        File soundFile = new File(soundName);
        // creates stream and puts it into clip ready to play
        try {
            audioIn = AudioSystem.getAudioInputStream(soundFile);
            soundClip = AudioSystem.getClip();
            if(!soundClip.isRunning()){
                soundClip.open(audioIn);
                soundClip.start();
            } else {
                
            }
        // exception catching
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } 
    }
    
}
