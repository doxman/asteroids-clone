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
import org.newdawn.slick.SlickException;

/**
 *
 * @author Daniel
 */
public class AsteroidsClone extends BasicGame {
    
    public AsteroidsClone() {
        super ("Asteroids?");
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException {}

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
            g.drawString("Howdy!", 100, 100);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
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
