/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

//imports
import city.cs.engine.*;

/**
 * Enemy for level 3
 * @author llama
 */
public class Enemy3 extends DynamicBody {
    // variables
    private Fist fist;
    private Main game;
    public static float friction;
    
    // set up image
    BodyImage image = new BodyImage("data/enemy3.png", 15f);
    
    // constructor
    public Enemy3(World w, float height) {
        
        super(w);
        friction = 0.5f;
        
        
        Shape Enemy3Shape = new PolygonShape (
        -5.01f,6.48f, -1.53f,7.41f, 2.43f,6.92f, 5.58f,2.3f, 5.33f,-6.52f, -3.98f,-6.52f, -5.99f,1.7f, -5.01f,6.48f);
        
        SolidFixture Enemy3Fixture = new SolidFixture(this, Enemy3Shape, 15);
        Enemy3Fixture.setFriction(friction);
        
        this.addCollisionListener(new CollisionDetect(fist));
        
        setImage(image);
    }
    
    // decrease friction
    public void decreaseFriction(float f) {
        friction -= f;
    }
}
