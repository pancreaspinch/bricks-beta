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
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */
public class Block {
    
    private int height ,width;
    private int x,y;
    public boolean display;
    Image img;
    
    public Block(int x, int y){
        this.x = x;
        this.y = y;
        height = 40;
        width = 40;
        display = true;
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/resource/bigleg.gif"));
        img = ii.getImage();
    }
    public Rectangle getHitbox(){
        return new Rectangle(x,y,width,height);
    }
    public void draw(Graphics2D g){
        if(display == true){
          g.drawImage(img, x, y, width, height, null);
        }
        
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
