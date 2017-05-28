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
public class Missile extends Sprite {
    
    public Missile(int x, int y) {
        super(x, y);
        loadImage("images/missile.png");
    }
    public void move() {
        
        y -= 4.5;
    }
    
}
