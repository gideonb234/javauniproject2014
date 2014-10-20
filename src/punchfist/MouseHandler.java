/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

// imports
import city.cs.engine.*;
import java.awt.Point;
import org.jbox2d.common.Vec2;
// imports for mouse events
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Gideon
 */
public class MouseHandler extends MouseAdapter {
    // variables
    private ScoreView view;
    private Fist fistSpawn;
    private Fist currentFist;
    private BodyImage fistimage;
    private Point startPoint;
    private Point endPoint;
    
    // constructor
    public MouseHandler(ScoreView view) {
        this.view = view;
    }
    
    // public get start point function
    public Point getStartPoint() {
        return startPoint;
    }
    // public get end point function
    public Point getEndPoint() {
        return endPoint;
    }
    // way for rest of program to get the last fist spawned
    public Fist getCurrentFist(Fist f) {
        f = fistSpawn;
        return f;
    }
    
    // spawns new fist, get point set position
    @Override
    public void mousePressed(MouseEvent e) {
        fistSpawn = new Fist(view.getWorld());
        startPoint = e.getPoint();
        fistSpawn.setPosition(view.viewToWorld(e.getPoint()));
    }
    
    // method for defining how much velocity should be applied to fist for milestone 1
    public void mouseReleased(MouseEvent e) {
        // get start and end points
        this.getStartPoint();
        endPoint = e.getPoint();
        
        // get start and end x/y point
        double startx = startPoint.getX();
        double endx = endPoint.getX();
        
        double starty = startPoint.getY();
        double endy = endPoint.getY();
        
        // print them as an ABS
//        System.out.println(Math.abs(startx - endx));
//        System.out.println(Math.abs(starty - endy));
        
        // store x/y coords and typecast them to float then ABS it
        double startEndX = startx - endx;
        float startEndXFloat = (float)startEndX;
        Math.abs(startEndXFloat);
        
        double startEndY = starty - endy;
        float startEndYFloat = (float)startEndY;
        Math.abs(startEndYFloat);
        
        // make the fist fly from where it is currently
        fistSpawn.setLinearVelocity(new Vec2(startEndXFloat/4,startEndYFloat/4));
    }
}
