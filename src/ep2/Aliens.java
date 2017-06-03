
package ep2;

import java.util.concurrent.ThreadLocalRandom;

public class Aliens extends Sprite {
    
    private static final int LARGURA_TELA = 480;
    private int VELOCIDADE = 2;   
    private int dano;
    private int score;
    
    public Aliens(int x, int y,int nivel) {
        super(x, y);
        Alen(nivel);   
        this.x = ThreadLocalRandom.current().nextInt(0,LARGURA_TELA);
    }
    
    private void Alen(int nivel){   
        setImagem(nivel);
    }
    
    public void setImagem(int nivel){
        if(nivel < 40)
        {
            loadImage("images/alien_EASY.png");
            setDanos(1); 
            setScore(1);
        }
        else if(nivel >= 40 && nivel < 100)
        {
            loadImage("images/alien_MEDIUM.png");
            setVelocidade(4);
            setDanos(2); 
            setScore(2);
        }
        else
        {
            loadImage("images/alien_HARD.png");
            setVelocidade(8);
            setDanos(4); 
            setScore(3);
        }
    }
    
    
    
    public void setDanos(int dano){
        this.dano = dano;
    }
    
    public int getDanos(){
        return dano;
    }
     public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public void explode(){
        loadImage("images/explosion.png");  
    }
    
    public void move() {
        y += getVelocidade();
    }
    
    public void setVelocidade(int velocidade){
        VELOCIDADE = velocidade;
    } 
    
    public int getVelocidade(){
        return VELOCIDADE;
    }
    
    
}

