/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

// has angular platforms for the thing to bounce around on (set restitution to bouncy)

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 *
 * @author llama
 */
public class Level2 extends LevelBase {
    // set up private vars
    private LevelBase world;
    private Score score;
    
    public Level2() {
        world = this;
        super.drawBodies(world);
        score = new Score();
        levelEnd = false;
    }
    
    @Override 
    public void drawBodies (World w) {
        { // to stop things falling down out of the camera view
            Shape box1 = new BoxShape(16f,0.5f);
            Body box1ground = new StaticBody(world, box1);
            box1ground.setPosition(new Vec2(0,-11f));
        }
        
        // level stuff starts
        { 
            Shape angle1 = new BoxShape (7.5f, 0.5f);
            Body angle1air = new StaticBody(world, angle1);
            angle1air.setPosition(new Vec2(4, 5f));
            angle1air.setAngle(270);
        }
        
        { 
            Shape angle2 = new BoxShape (5f, 0.5f);
            Body angle2air = new StaticBody(world, angle2);
            angle2air.setPosition(new Vec2(-2, -5f));
            angle2air.setAngle(170);
        }
        
        { // the big guy of the level
            Enemy2 enemy = new Enemy2(world,10f);
            enemy.setPosition(new Vec2(0f,0.5f));
        }
    }
    
    @Override
    public boolean isCompleted() {
        return isCompleted();
    }
    
}
