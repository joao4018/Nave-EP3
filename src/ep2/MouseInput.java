/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * public Rectangle playButton = new Rectangle(80+120,150,100,50);
    public Rectangle helpButton = new Rectangle(80+120,250,100,50);
    public Rectangle quitButton = new Rectangle(80+120,350,100,50);
 * @author joao
 */
public class MouseInput implements MouseListener{

   
   
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int mx = e.getX();
        int my = e.getY();
        //public Rectangle playButton = new Rectangle(380,15,100,30);
        if(Map.State == Map.State.MENU){
            if(mx >= 200 && mx <= 80 +220){
            if(my >= 150 && my <= 200){
            Map.State = Map.State.GAME;
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 350 && my <= 400){
                System.exit(1);
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 350 && my <= 400){
                System.exit(0);
        }
        }
    }//public Rectangle playButton = new Rectangle(380,15,100,30);
        if(Map.State == Map.State.GAME){
            if(mx >= 380 && mx <= 480)
            if(my >= 15 && my <= 45)
            Map.State = Map.State.PAUSE;
        }
        
        else if(Map.State == Map.State.PAUSE)
            if(mx >= 380 && mx <= 480)
            if(my >= 15 && my <= 45)
            Map.State = Map.State.GAME;
       
        if(Map.State == Map.State.GAMEOVER){
            if(mx >= 200 && mx <= 80 +220){
            if(my >= 150 && my <= 200){
            
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 250 && my <= 300){
             Map.State = Map.State.MENU;
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 350 && my <= 400){
                System.exit(0);
        }
        }
    }
    
    }
    
   /* public void mouseMoved(MouseEvent e){
          int mx = e.getX();
        int my = e.getY();
        
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 150 && my <= 200){
                System.out.println("Porra");
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 350 && my <= 400){
                System.exit(1);
        }
        }
        if(mx >= 200 && mx <= 80 +220){
            if(my >= 350 && my <= 400){
                System.exit(0);
        }
        }
    }
*/
    @Override
    public void mouseClicked(MouseEvent e) {
       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
