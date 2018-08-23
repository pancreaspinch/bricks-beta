/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */
public class Map1 {
    private int [][] map;
    private int height, width;
    
    private Color c1 = new Color(50,50,50);
    private Color c2 = new Color(100,100,100);
    private Color c3 = new Color(150,150,150);
    private Color c4 = new Color(200,200,200);
    private Color c5 = new Color(50,50,50);
    private Image block1,block2,block3,block4,block5;
    
    public final int HOR_PAD = 20, VER_PAD = 50; 
    
    //image init
    public void imageInit(){
        
        try{
 
        block1 = ImageIO.read(getClass().getResource("resource/Block1.ong"));
        block2 = ImageIO.read(getClass().getResource("resource/Block2.gif"));
        block3 = ImageIO.read(getClass().getResource("resource/Block3.gif"));
        block4 = ImageIO.read(getClass().getResource("resource/Block4.gif"));
        }catch(Exception e){
            System.out.println("no rsc");
        }
}
    
    
    
    public Map1(int row,int col){
        initMap(row,col);
        width = 40;
        height = 20;
    }
    
    public void initMap(int row,int col){
        
        map = new int [row][col];
        for(int i = 0 ;  i < map.length;i++){
            for(int j = 0 ; j < map[0].length;j++){
                int r = (int)(Math.random()*5+1);
            // map[i][0] = 1;
            map[i][j]=r;            
             
            }

        }

    }
    public void draw(Graphics2D g){

        
       for(int i = 0 ;  i < map.length;i++){
         for(int j = 0 ; j < map[0].length;j++){
             
             if(map[i][j]> 0){
                 if(map[i][j] == 1 ){
                     g.setColor(c2);
                     g.drawImage(block1, i, j, width, height, null);
                     
                 }
                 if(map[i][j] == 2 ){
                     g.setColor(c2);
                     
                 }
                 if(map[i][j] == 3 ){
                     g.setColor(c3);
                 }
                 if(map[i][j] == 4 ){
                     g.setColor(c4);
                 }
                 if(map[i][j] == 5 ){
                     g.setColor(Color.GREEN);
                 }
            
            g.fillRect(j*width+HOR_PAD, i*height +VER_PAD , width, height);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.WHITE);
            g.drawRect(j*width+HOR_PAD, i*height +VER_PAD , width, height);
            }
         }
        }
    }
    public void setBlock(int row, int col){
        map[row][col] -=1;
        if(map[row][col]<0){
            map[row][col] = 0;
        }
    }

    
    //accessors/mutators
        public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int [][] getMap(){return map;}
    public void setBlock(int row, int col, int val){
        map[row][col] = val;
    }
    
}
