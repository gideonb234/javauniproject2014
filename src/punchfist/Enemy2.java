/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;

// imports
import city.cs.engine.*;

/**
 *  Enemy for level 2
 * @author llama
 */
public class Enemy2 extends DynamicBody {
    // set vars
    private Fist fist;
    private Main game;

    BodyImage image = new BodyImage("data/enemy2.png", 15f);
    
    // constructor
    public Enemy2(World w, float height) {
        
        super(w);

        Shape Enemy2Shape = new PolygonShape(
                -4.79f, 0.81f, 0.83f, 4.81f, 2.92f, 4.11f, 3.75f, -2.78f, 0.44f, -4.83f, -4.74f, -0.12f, -4.81f, 0.79f);
        SolidFixture Enemy2Fixture = new SolidFixture(this, Enemy2Shape, 15);

        Enemy2Fixture.setFriction(0.5f);
        
        this.addCollisionListener(new CollisionDetect(fist));

        setImage(image);
    }
    
}
