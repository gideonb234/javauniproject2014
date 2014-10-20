/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

// simple level for players to get used to the world (4 bars blocking the thing falling off of the screen)

/**
 *
 * @author 기돈
 */
public class Level1 extends LevelBase{
    
    // set up private vars
    private LevelBase world;
    private Score score;
    private Main game;
    
    // draw level
    public Level1() {
        world = this;
        super.drawBodies(world);
        game = Main.getGame();
        score = new Score();
        levelEnd = false;
    }

    @Override
    public void drawBodies(World w) {
        // bodies go here
        { // to stop things falling down out of the camera view
            Shape box1 = new BoxShape(16f,0.5f);
            Body box1ground = new StaticBody(world, box1);
            box1ground.setPosition(new Vec2(0,-11f));
        }
        
        {
            Shape box2 = new BoxShape (16f, 0.5f);
            Body box2top = new StaticBody(world, box2);
            box2top.setPosition(new Vec2(0,11f));
        }
        
        {
            Shape box3 = new BoxShape (0.5f, 13f);
            Body box3left = new StaticBody(world, box3);
            box3left.setPosition(new Vec2(-15f,0f));
        }
        
        { // the big guy of the level
            Enemy enemy = new Enemy(world,10f);
            enemy.setPosition(new Vec2(10f,0.5f));
            
        }
    }

    @Override
    public boolean isCompleted() {
        return levelEnd;
    }
    
}
