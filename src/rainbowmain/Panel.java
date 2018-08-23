/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class Panel extends JPanel implements Runnable{
    
    public boolean won;
    private boolean play;
    private BufferedImage img;
    private Graphics2D g;
    private Image background1;
    
    private Pop pop ;
    private Katch katch;
    private Map1 map1;
    private Score score;
    private Block b;
    private ArrayList<Block> biglegs; //inteded to store biglegs
    private ArrayList<Powerup> powerups;
    
    private int level = 1;
    private int lives = 3;
    private static final double GRAVITY = .4;
    
    public Panel(){
        init();
    }
    
       public void init(){
       pop = new Pop();
       katch = new Katch();
       map1 = new Map1(4,15);
       b = new Block(200,0);
       score = new Score();
       powerups = new ArrayList<Powerup>();
       biglegs = new ArrayList<Block>();
       play = true;
       img = new BufferedImage(RainbowMain.WIDTH,RainbowMain.HEIGHT,BufferedImage.TYPE_INT_RGB);
       g = (Graphics2D) img.getGraphics();
       
       //zetcode inspiration
       this.setFocusable(true);
       this.requestFocus();
       this.addKeyListener(new KeyListener(){
           @Override
           public void keyTyped(KeyEvent e) {}
           @Override
           public void keyPressed(KeyEvent e) {
               katch.keyPressed(e.getKeyCode());
           }

           @Override
           public void keyReleased(KeyEvent e) {
               katch.keyReleased(e.getKeyCode());
           }
       
       });
    }
    public void run(){
        while(play){
            update();
            paintComponent(g);
            repaint();
            try{
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public void collide(){
        Rectangle popHit = pop.getHitbox();
        Rectangle katchHit = katch.getHitbox();
        Rectangle bigHit = b.getHitbox();
        
        //pop and catch
        if(popHit.intersects(katchHit)){
            pop.setYdir(-pop.getYdir());
            //pop.setXdir(-pop.getXdir());
             if(pop.getx()<katch.getx()+katch.getWidth()/4){
                pop.setXdir(pop.getXdir() - .25);
            }
            if(pop.getx()<katch.getx()+katch.getWidth() && pop.getx() >
                    katch.getx()+katch.getWidth()/4){
                pop.setXdir(pop.getXdir() + .25);
            }
        }
        if(popHit.intersects(bigHit)){
            b.display = false;
            level++;
            if(level == 5){
                won = true;
            }
            pop.reset();
            katch.reset();
            play = false;
            String message = ("Level" + level);
            int tempScore = score.getScore();
            JOptionPane.showMessageDialog(null, message);
            init();
            score.addScore(tempScore);
            run();
            play = true;
        }
        
        //pop and block
        A: for(int i = 0;i<map1.getMap().length;i++){
            for(int j = 0;j<map1.getMap()[0].length;j++){
                if(map1.getMap()[i][j]>0){
                int blockx = j *map1.getWidth()+map1.HOR_PAD;
                int blocky = i* map1.getHeight()+map1.VER_PAD;
                int bheight = map1.getHeight();
                int bwidth= map1.getWidth();
                
                Rectangle blockHit = new Rectangle(blockx,blocky,bwidth,bheight);
                
                if(popHit.intersects(blockHit)){
                    if(map1.getMap()[i][j] > 4){ //check powerup
                        powerups.add(new Powerup(blockx,blocky,bwidth,bheight,5));
                               
                        map1.setBlock(i,j,1);
                        lives++;
                    }else{
                        map1.setBlock(i,j);
                    }
                    map1.setBlock(i,j);
                    pop.setYdir(-pop.getYdir());
                    score.addScore(10);
                    break A;
                    }     
                }
            }
        }
        
    }
    public void update(){
        collide();
        pop.update();
        katch.update();
        loseLife();
    }
    public void drawPower(){
        for(Powerup p : powerups){
            p.draw(g);
        }
    }
    
    public void loseLife(){
        if(pop.getY()>katch.y){
            lives--;
            play = false;
            katch.reset();
            pop.reset();
            play = true;
        }
        
    }


    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        //draw background
        ImageIcon bg = new ImageIcon(this.getClass().getResource("/resource/Background1.png"));
        background1 = bg.getImage();
        g.drawImage(background1, 0, 0, null);
        
        //draw walls
        ImageIcon w = new ImageIcon(this.getClass().getResource("/resource/Wall.gif"));
        Image wall = w.getImage();
        for(int i = 0;i<24;i++){
        g.drawImage(wall, 0, i*20, null);
        g.drawImage(wall, 620 , i*20, null);
        }
        
        //draw everything else
        pop.draw(g2);
        katch.draw(g2);
        map1.draw(g2);
        b.draw(g2);
        score.draw(g2);
        drawPower();
        g2.setColor(Color.ORANGE);
        g2.drawString("Lives: " + lives,20,375);
        if(won==true){
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/resource/win.png"));
            Image win = icon.getImage();
            g.drawImage(win, 0, 0, null);
            play = false;
        }
            
        
        if(lives == 0){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,50));
            g.drawString("lose",400,200);
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/resource/loss.png"));
            Image loss = ii.getImage();
            g.drawImage(loss, 0, 0, null);
            play = false;
        }
        g2.dispose();
        
    }


}
