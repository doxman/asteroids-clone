/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroidsclone;

import asteroidsclone.exceptions.ShotTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Daniel
 */
public class PlayerShot {
    private float xCoord;
    private float yCoord;
    
    private float facing; // Angle on [0, 360)
    
    // Each shot is given 2000 "ticks" to hit something or leave the screen
    private int age;
    
    private Image laserImage;
    
    public PlayerShot(float x, float y, float f) {
        xCoord = x;
        yCoord = y;
        
        facing = f;
        
        age = 0;
        
        try {
            laserImage = new Image("resources/laser.png");
            laserImage.setRotation(f);
        } catch (SlickException ex) {
            Logger.getLogger(AsteroidsClone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Function to draw the shot, in the game's render method
    // (before drawing it also moves the shot an appropriate distance)
    public void render(Graphics g) throws SlickException, ShotTimeoutException {
        if (age > 2000) {
            throw new ShotTimeoutException("Shot can safely be deleted");
        }
        
        double angle = Math.toRadians(facing);
        
        xCoord += 0.5 * Math.cos(angle);
        yCoord += 0.5 * Math.sin(angle);
        
        g.drawImage(laserImage, xCoord, yCoord);
        
        age += 1;
    }
}
