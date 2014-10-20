/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

// angular and straight platforms with the enemy falling down the platforms slowly

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 *
 * @author llama
 */
public class Level3 extends LevelBase {
    private LevelBase world;
    private Score score;
    
    public Level3() {
        world = this;
        super.drawBodies(world);
        score = new Score();
        levelEnd = false;
    }
    
    @Override
    public void drawBodies(World w) {
        { // to stop things falling down out of the camera view
            Shape box1 = new BoxShape(30f,0.5f);
            Body box1ground = new StaticBody(world, box1);
            box1ground.setPosition(new Vec2(0,-11f));
            box1ground.setAngleDegrees(-10);
        }
        // level stuff 
        {
            Shape angleBox1 = new BoxShape(5f,0.5f);
            Body angleBox1body = new StaticBody(world, angleBox1);
            angleBox1body.setPosition(new Vec2(-10f,6f));
            angleBox1body.setAngleDegrees(190);
        }
        {
            Shape angleBox2 = new BoxShape(6f, 0.5f);
            Body angleBox2body = new StaticBody(world, angleBox2);
            angleBox2body.setPosition(new Vec2(5f,5f));
            angleBox2body.setAngle(3);
        }
        {
            Shape box2 = new BoxShape(5f, 1f);
            Body box2body = new StaticBody(world, box2);
            box2body.setPosition(new Vec2(5.5f, 8f));
        }
        // enemy
        {
            Enemy3 enemy3 = new Enemy3(world,10f);
            enemy3.setPosition(new Vec2(-6f,-3f));
        }
    }
    
    @Override
    public boolean isCompleted() {
        return isCompleted();
    }
    
}
