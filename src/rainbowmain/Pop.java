/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */

public class Pop {
    
    private double x,y,dx,dy;
    private int size = 40;
    private Image img;
    private static final double GRAVITY = .0004;
    
    
    public Pop(){
        x = (RainbowMain.WIDTH)/2;
        y = 300;
        dx = 0;
        dy = 3;   
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/resource/Pop.gif"));
        img = ii.getImage();
    }
    public void update(){
        move();
    }

    public void move(){
        if(dy<0){
            dy -= GRAVITY;
        }
        else{
            dy = this.dy;
        }
        x+=dx;
        y+=dy;
        if(x<20){
            dx = -dx;
        }
        if(y<0){
            dy = -dy;
        }
        if(x>RainbowMain.WIDTH - size - 20){
            dx = -dx;
        }
        if(y>RainbowMain.HEIGHT){
            dy = -dy;
        }
    }
    public void draw(Graphics2D g){
       /* g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4));
        g.drawRect((int)x,(int)y,(int)size,(int)size);*/
       g.drawImage(img, (int)x, (int)y, size, size, null);
    }


    public void reset(){
        x = (RainbowMain.WIDTH)/2;
        y = 300;
    }
    //accesors
    public Rectangle getHitbox(){
        return new Rectangle((int)x,(int)y,(int)size,(int)size);
    }
    public void setYdir(double dy){this.dy = dy;}
    public double getYdir(){ return dy;}
    public void setXdir(double dx){this.dx = dx;}
    public double getXdir(){ return dx;}
    public double getx(){return x;}
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
