
package ep2;

import java.util.concurrent.ThreadLocalRandom;

public class Aliens extends Sprite {
    
    private static final int LARGURA_TELA = 480;
    private int VELOCIDADE = 2;
    private int dano;
    private int score;
    
    public Aliens(int x, int y,int qtd) {
        super(x, y);
        Alen(qtd);   
        this.x = ThreadLocalRandom.current().nextInt(0,LARGURA_TELA);
    }
    
    private void Alen(int qtd){   
        setImagem(qtd);
    }
    
    public void setImagem(int qtd){
        if(qtd < 40){
        loadImage("images/alien_EASY.png");
        setDanos(1); 
        setScore(1);
        }else if(qtd >= 40 && qtd < 100){
        loadImage("images/alien_MEDIUM.png");
        setVelocidade(4);
        setDanos(2); 
        setScore(2);
        }else {
        loadImage("images/alien_HARD.png");
        setVelocidade(8);
        setDanos(4); 
        setScore(3);
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
        y += getVelocidade();
    }
    
    public void setVelocidade(int qtd){
        VELOCIDADE = qtd;
    } 
    
    public int getVelocidade(){
        return VELOCIDADE;
    }
    
    
}

