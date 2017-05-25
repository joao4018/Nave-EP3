
package ep2;

import java.util.concurrent.ThreadLocalRandom;

public class Aliens extends Sprite {
    
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1;
    
    public Aliens(int x, int y) {
        super(x, y);
        Alen();
        
        this.x = ThreadLocalRandom.current().nextInt(0,500);
        
  
    }
    
    private void Alen(){
        loadImage("images/alien_EASY.png"); 
        
    }
    
    public void move() {
        // Moves the spaceship on the verical axis
        if(this.y > LARGURA_TELA){
            this.y = 0;
          
            
        }
        y += VELOCIDADE;
        
    }
    
}

