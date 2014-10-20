    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;

// imports
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author 기돈
 */

public class Main {
    // set up variables 
    private LevelBase base;
    private String levelname;
    public int levelCount; 
    private ScoreView view;
    private GameUI menuButtons;
    static Main publicGame;
    private AudioHandler backgroundAudio = new AudioHandler("data/bgm.wav");
    
    // set up game
    
    public Main() {
        levelCount = 1;
        base = new Level1();
        publicGame = this;
        base.drawBodies(base);
        
        // set the view
        view = new ScoreView(base, 640, 480);
        
        // add that sweet mouse listener
        view.addMouseListener(new MouseHandler(view));
        
        // wanna see a grid? here
        // view.setGridResolution(1);
        
        // display the view in a window viewable by the user
        final JFrame frame = new JFrame("Punch Fist");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        frame.add(view);
        frame.setResizable(false);
        
        menuButtons = new GameUI(base);
        frame.add(menuButtons, BorderLayout.SOUTH); 
        
        frame.pack();
        
        frame.setVisible(true);
        
        try {
            backgroundAudio.playSound();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        base.start();
        

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
    // go to level code
    
    public void goToLevel() {
        base.setPaused(true);
        if (levelCount == 1) {
            base = new Level1();
            base.drawBodies(base);
            view.setWorld(base);
            menuButtons.setLevel(base);
            base.start();
        }
        if (levelCount == 2) {
            base = new Level2();
            base.drawBodies(base);
            view.setWorld(base);
            menuButtons.setLevel(base);
            base.start();
        }
        if (levelCount == 3) {
            base = new Level3();
            base.drawBodies(base);
            view.setWorld(base);
            menuButtons.setLevel(base);
            base.start();
        }
    }
    
    public void finishGame() {
        System.out.println("You finished the game!");
        base.setPaused(true);
    }
    
    // get/set
    
    public void setGame(Main g) {
        g = this.publicGame;
    }
    public static Main getGame() {
        return publicGame;
    }
    
    // get level for save/load feature
    
    public String getLevel() {
        if (levelCount == 1) {
            levelname = "1";
        } 
        if (levelCount == 2) {
            levelname = "2";
        }
        if (levelCount == 3) {
            levelname = "3";
        }
        return levelname;
    }
    
    // set and increment level
    
    public void setLevel(int c) {
        levelCount = c;
    }
    
    public void incrementLevel() {
        levelCount++;
    }
}
