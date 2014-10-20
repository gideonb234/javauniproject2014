/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punchfist;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *  Enemy for first level
 * @author 기돈
 */
public class Enemy extends DynamicBody {
    // arm t = arm top, arm l = arm low
    private static final float ArmTW = 20f;
    private static final float ArmTH = 10f;
    private static final float ArmLW = 20f;
    private static final float ArmLH = 10f;
    
    private Fist fist;
   
    BodyImage image = new BodyImage("data/boss.png", 20f);
    
    // get the enemy onscreen and allow it to be used in other classes
    public Enemy getEnemy(Enemy currentEnemy) {
        return currentEnemy;
    }
    
    // constructor
    public Enemy(LevelBase level, float height) {
        
        super (level);
        
        float ArmTW2 = ArmTW;
        float ArmTH2 = ArmTH;
        float ArmLW2 = ArmLW;
        float ArmLH2 = ArmLH;
        
        Shape topArm = new PolygonShape(
                -2.89f,0.0f, -2.89f,8.21f, -1.43f,9.29f, 1.04f,9.32f, 2.14f,8.6f, 2.11f,0.0f, -2.89f,0.0f);
        
        Shape lowArm = new PolygonShape(
                2.86f,0.0f, 2.86f,-8.21f, 1.43f,-9.26f, -1.07f,-9.26f, -2.14f,-8.54f, -2.14f,0.0f, 2.86f,0.0f);
        
        Shape topArmShape = new BoxShape(ArmTW2, ArmTH2, new Vec2(0, ArmTH2));
        SolidFixture topArmFixture = new SolidFixture(this, topArm, 15);
        Shape lowArmShape = new BoxShape(ArmLW2, ArmLH2, new Vec2(0, ArmLW2));
        SolidFixture lowArmFixture = new SolidFixture(this, lowArm, 30);
        
        topArmFixture.setFriction(0.5f);
        lowArmFixture.setFriction(0.3f);
        
        this.addCollisionListener(new CollisionDetect(fist));
         
        setImage(image);
    }
    
}

