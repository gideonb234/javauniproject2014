/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;
// imports
import city.cs.engine.*;
import java.awt.Graphics2D;

/**
 *  Custom view to show the score to the player
 * @author 기돈
 */
public class ScoreView extends UserView {
    // set ups the view based on user paramters
    public ScoreView(World world, int width, int height) {
        super(world, width, height);
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        
    }
    // draws the score so it is visible to the user
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + Score.getCount(), 15, 20);
    }
}
