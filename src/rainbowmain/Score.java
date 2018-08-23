/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author acer
 */
public class Score {
    private int score;
    
    public Score(){
        init();
    }
    public void init(){
        score = 0;
        
    }
    public void draw(Graphics2D g){
        g.setColor(Color.ORANGE);
        g.drawString("Score: " + score,20,400);
        
    }
    
    public void addScore(int add){
        score += add;
        
    }
    
    public int getScore(){return score;}
    
}
