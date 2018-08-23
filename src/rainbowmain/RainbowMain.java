/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowmain;

import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class RainbowMain {

    /**
     * @param args the command line arguments
     */
    public static final int WIDTH = 640;
      public static final int HEIGHT = 480;
   
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("");
        frame.pack();
        Panel panel = new Panel();
        
        
        frame.setTitle("instagram.com/emotionalsquatter");
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.run();
        
    }
    
}
