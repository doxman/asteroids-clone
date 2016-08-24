/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroidsclone;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Daniel
 */
public class PlayerShip {
    private float xCoord;
    private float yCoord;
    
    private float facing; // Angle on [0, 360)
    
    private Image shipImage;
    
    public PlayerShip(float x, float y, float f) {
        xCoord = x;
        yCoord = y;
        
        facing = f;
        
        try {
            shipImage = new Image("resources/spaceship.png");
            shipImage.setRotation(f);
        } catch (SlickException ex) {
            Logger.getLogger(AsteroidsClone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Functions for the game's update method. Handle movement.
    // - Turning is done in 0.5-degree increments
    // - Movement calculations assume that 270 degrees is the angle for "up"
    
    public void turnLeft() {
        facing -= 0.5;
        
        shipImage.setRotation(facing);
    }
    
    public void turnRight() {
        facing += 0.5;
        
        shipImage.setRotation(facing);
    }
    
    public void moveForward() {
        double angle = Math.toRadians(facing);
        
        xCoord += 0.5 * Math.cos(angle);
        yCoord += 0.5 * Math.sin(angle);
    }
    
    public void moveBackward() {
        double angle = Math.toRadians(facing);
        
        xCoord -= 0.5 * Math.cos(angle);
        yCoord -= 0.5 * Math.sin(angle);
    }
    
    
    // Function to draw the ship, in the game's render method
    public void render(Graphics g) throws SlickException {
        g.drawImage(shipImage, xCoord, yCoord);
    }

}
