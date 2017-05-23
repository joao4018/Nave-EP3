/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

/**
 *
 * @author joao
 */
public class Aliens extends Sprite {
    
    public Aliens(int x, int y) {
        super(x, y);
        Alen();
    }
    
    private void Alen(){
        loadImage("images/alien_EASY.png"); 
    }
    
    public void move() {
        
        
     
        // Moves the spaceship on the verical axis
        y += 1;
        
    }
    
}

