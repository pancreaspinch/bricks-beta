/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */
public class Katch {
    public double x;
    public static final int y = RainbowMain.HEIGHT -80;
    private final int width,height;
    private final int speed = 3;
    private int lives;
    private boolean left, right;
    private final Image img;

    
    
    
    public Katch(){
     width = 80;
     height = 30;
     left = right = false;
     lives = 3;
     x = (RainbowMain.WIDTH)/2;
     ImageIcon ii = new ImageIcon(this.getClass().getResource("/resource/Katch.gif"));
        img = ii.getImage();
     
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void update(){
    if(x>RainbowMain.WIDTH -  width-22){
        x = RainbowMain.WIDTH  - width -22; 
        }    
        if(x<22){
        x = 22; 
        }   
        if(left){            
                x-=speed;
        }
            if(right){
                x+=speed;
            }
    }
    public Rectangle getHitbox(){
        return new Rectangle((int)x, y, width, height);
    }
    public void reset(){
        x = (RainbowMain.WIDTH)/2;
        left = right = false;
    }
    
    public void draw(Graphics2D g){
        //g.setColor(Color.BLACK);
        //g.fillRect((int)x,y,width,height);
        g.drawImage(img, (int)x, y, width, height, null);
    }
    public void keyPressed(int k) {

        if(k==KeyEvent.VK_RIGHT){
            right = true;
        }
        if(k==KeyEvent.VK_LEFT){
            left = true;
        }
    }

    public void keyReleased(int k) {
        if(k==KeyEvent.VK_RIGHT){
            right = false;
        }
        if(k==KeyEvent.VK_LEFT){
            left = false;
        }
    }
    
    public int getWidth(){
        return width;
    }
    public double getx(){
        return x;
    }

}

