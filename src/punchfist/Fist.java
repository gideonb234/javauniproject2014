/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;

import city.cs.engine.*;
import java.awt.event.MouseEvent;

/**
 * the player creates this using the mouse handler (clicks)
 * @author 기돈
 */
public class Fist extends DynamicBody {
    private static final Shape shape = new PolygonShape(
            -0.682f,0.443f, -0.045f,0.68f, 0.595f,0.68f, 0.597f,-0.6f, -0.045f,-0.6f, -0.682f,-0.362f, -0.682f,0.443f);
    
    private static final BodyImage image =
            new BodyImage("data/fist.png", 2f);
    
    // constructor
    public Fist(World world) {
        super(world, shape);
        
        setImage(image);
        
        SolidFixture fixture = new SolidFixture(this, shape, 20);
        fixture.setFriction(0.2f);
    }
    
    public Fist getFist() {
        return this;
    }
    
}
