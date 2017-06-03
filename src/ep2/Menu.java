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
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author joao
 */


/**
 *
 * @author joao
 */
public class Menu extends JFrame {
    
 
    
    public Rectangle playButton = new Rectangle(80+95,150,150,50);
    public Rectangle helpButton = new Rectangle(80+95,250,150,50);
    public Rectangle quitButton = new Rectangle(80+95,350,150,50);
    
   
    
    public final void menuInicial(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Font fnt0 = new Font("italic",Font.BOLD,50);
        g.setFont(fnt0);
        g.setColor(Color.red);
        g.drawString("SPACE GAME",80,100);
        Font fnt1 = new Font("italic",Font.BOLD,20);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("PLAY",playButton.x + 42 ,playButton.y +30);
        g2d.draw(playButton);
        g.drawString("HELP",helpButton.x + 42 ,helpButton.y +30);
        g2d.draw(helpButton);
        g.drawString("QUIT",quitButton.x + 44 ,quitButton.y +30);
        g2d.draw(quitButton);   
    }
    public final void menuFinal(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Font fnt0 = new Font("arial",Font.BOLD,50);
        g.setFont(fnt0);
        g.setColor(Color.red);
        g.drawString("GAME OVER",80,100);        
        Font fnt1 = new Font("italic",Font.BOLD,20);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("RANK",playButton.x + 42 ,playButton.y +30);
        g2d.draw(playButton);
        g.drawString("MENU",helpButton.x + 30 ,helpButton.y +30);
        g2d.draw(helpButton);
        g.drawString("QUIT",quitButton.x + 44 ,quitButton.y +30);
        g2d.draw(quitButton);
        
    }
   
    

}


