/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author joao
 */
public class Menu {
    
 
    
    public Rectangle playButton = new Rectangle(80+120,150,100,50);
    public Rectangle helpButton = new Rectangle(80+120,250,100,50);
    public Rectangle quitButton = new Rectangle(80+120,350,100,50);
    
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        
        
        
        Font fnt0 = new Font("arial",Font.BOLD,50);
        g.setFont(fnt0);
        g.setColor(Color.red);
        g.drawString("SPACE GAME",80,100);
        
        
        Font fnt1 = new Font("arial",Font.BOLD,20);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("PLAY",playButton.x + 19 ,playButton.y +30);
        g2d.draw(playButton);
        g.drawString("HELP",helpButton.x + 19 ,helpButton.y +30);
        g2d.draw(helpButton);
        g.drawString("QUIT",quitButton.x + 19 ,quitButton.y +30);
        g2d.draw(quitButton);
        
    }
    

}
