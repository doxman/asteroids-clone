/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroidsclone;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Daniel
 */
public class AsteroidsClone extends BasicGame {
    
    int timeElapsed; // Game difficulty increases with time
    
    PlayerShip playerShip;
    
    public AsteroidsClone() {
        super ("Asteroids?");
        
        timeElapsed = 0;
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        playerShip = new PlayerShip(304, 224, 270);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        timeElapsed += 1;
        
        // Respond to player pressing keys
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_LEFT)) {
            playerShip.turnLeft();
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            playerShip.turnRight();
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            playerShip.moveForward();
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            playerShip.moveBackward();
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        playerShip.render(g);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
                AppGameContainer appgc;
                appgc = new AppGameContainer(new AsteroidsClone());
                appgc.setDisplayMode(640, 480, false);
                appgc.start();
        }
        catch (SlickException ex)
        {
                Logger.getLogger(AsteroidsClone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
