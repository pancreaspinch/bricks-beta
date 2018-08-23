/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author acer
 */
public class Powerup {
    private int x,y,width,height,type;
    private final int speed = 3; 
    private boolean display,hit;
    public static final Color color = Color.MAGENTA;
    private Image image;
    
    public Powerup(int x,int y,int width, int height,int type){
        this.x=x;
        this.y=y;
        this.width= width;
        this.height=height;
        this.type = 5;
        this.hit = false;
                
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
   public void update(){

    }
    public Rectangle getHitbox(){
        return new Rectangle(x,y,width,height);
}
    
    //auto getters are a thing
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
