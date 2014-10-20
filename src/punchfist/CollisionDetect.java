/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

import city.cs.engine.*;
import java.io.IOException;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Gideon
 */
public class CollisionDetect implements CollisionListener {
    // create vars for collision to read
    private Fist fist;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private LevelBase colLevel;
    private Main game;
    private AudioHandler collisionAudio;
    private static String filename;
    // constructor
    public CollisionDetect(Fist f) {
        fist = f;
        filename = "data/sfx_point.wav";
        collisionAudio = new AudioHandler(filename);
    }
    
    // collision event
    @Override
    public void collide(CollisionEvent e) {
        
        // increment a hit each time a hit occurs, but do it differently depending on which type of enemy has been hit
            if (e.getReceivingBody() instanceof Enemy) {
                Score.addCount(1);
                    if (Score.getCount() >= 20) {
                        try {
                            collisionAudio.playSound();
                        } catch (IOException ioe) {
                            System.out.println(ioe.getStackTrace());
                        }
                        e.getReceivingBody().destroy();
                        e.getOtherBody().destroy();
                        Main.publicGame.incrementLevel();
                        Main.publicGame.goToLevel();
                    }
                }
                // now destroy the fist each time it hits the enemy
                if (e.getReceivingBody() instanceof Enemy2) {
                    if(e.getOtherBody() instanceof Fist) {
                        Score.addCount(1);
                        e.getOtherBody().destroy();
                    }                    
                    if (Score.getCount() >= 20) {
                        e.getReceivingBody().destroy();
                        
                        try {
                            collisionAudio.playSound();
                        } catch (IOException ioe) {
                            System.out.println(ioe.getStackTrace());
                        }
                        
                        Main.publicGame.incrementLevel();
                        Main.publicGame.goToLevel();
                    } 
                }
            
                if (e.getReceivingBody() instanceof Enemy3) {
                    // add count and increase enemy gravity
                    if(e.getOtherBody() instanceof Fist) {
                        Score.addCount(1);
                        e.getOtherBody().destroy();
                        Enemy3.friction -= 0.1f;
                    }
                    if (Score.getCount() >= 20) {
                        e.getReceivingBody().destroy();
                        
                        try {
                            collisionAudio.playSound();
                        } catch (IOException ioe) {
                            System.out.println(ioe.getStackTrace());
                        } 
                        
                        // end game
                        Main.publicGame.finishGame();
                    } 
                }
            }
        }