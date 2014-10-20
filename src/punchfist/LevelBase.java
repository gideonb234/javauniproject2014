/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;
// imports
import city.cs.engine.*;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

// level base that the other levels use in order to keep same GUI without copy pasting code etc (OOP approach)

/**
 *
 * @author 기돈
 */
public abstract class LevelBase extends World {
    
    // set up private vars
    private static Main game;
    private World world;
    private UserView view;
    static boolean levelEnd;
    
    // draw level

    /**
     * populate the world
     */
    public void drawBodies(World w) {
        
    }
    // set and game for main class inside level
    public void setGame(Main m) {
        this.game = m;
    }
    public Main getGame() {
        return game; 
    }
    
    /**
     * is completed variable (not used)
     */
    public abstract boolean isCompleted();
    
}
