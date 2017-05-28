
package ep2;

import java.util.concurrent.ThreadLocalRandom;

public class Aliens extends Sprite {
    
    private static final int LARGURA_TELA = 500;
    private int VELOCIDADE = 2;
    private int dano;
    private int score;
    
    public Aliens(int x, int y) {
        super(x, y);
        Alen();
        
        this.x = ThreadLocalRandom.current().nextInt(0,500);
        
  
    }
    
    private void Alen(){
        
         
          setImagem(0);
         
    }
    
    public void setImagem(int qtd){
        if(qtd <= 20){
        loadImage("images/alien_EASY.png");
        setDanos(1); 
        setScore(1);
        }
        else if(qtd > 20 && qtd <= 40){
        loadImage("images/alien_MEDIUM.png");
        setVelocidade(4);
        setDanos(2); 
        setScore(2);
        }
        else {
        loadImage("images/alien_HARD.png");
        setVelocidade(8);
        setDanos(4); 
        setScore(5);
        }
    }
    
    
    
    public void setDanos(int i){
        this.dano = i;
    }
    
    public int getDanos(){
        return dano;
    }
     public void setScore(int i){
        this.score = i;
    }
    
    public int getScore(){
        return score;
    }
    
    public void explode(){
        loadImage("images/explosion.png");  
    }
    
    public void move() {
        // Moves the spaceship on the verical axis
        
        y += getVelocidade();
        
    }
    public void setVelocidade(int qtd){
        VELOCIDADE = qtd;
    } 
    public int getVelocidade(){
        return VELOCIDADE;
    }
}

