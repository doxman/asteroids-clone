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
        
        xCoord += 0.2 * Math.cos(angle);
        yCoord += 0.2 * Math.sin(angle);
    }
    
    public void moveBackward() {
        double angle = Math.toRadians(facing);
        
        xCoord -= 0.2 * Math.cos(angle);
        yCoord -= 0.2 * Math.sin(angle);
    }
    
    
    // Function to create a shot.
    // Returns it to the main class so it can be tracked there
    public PlayerShot shoot() {
        double angle = Math.toRadians(facing);
        double x = xCoord + 48 * Math.cos(angle);
        double y = yCoord + 48 * Math.sin(angle);
        
        return new PlayerShot((float)x, (float)y, facing);
    }
    
    
    // Function to draw the ship, in the game's render method
    public void render(Graphics g) throws SlickException {
        g.drawImage(shipImage, xCoord, yCoord);
    }

}
