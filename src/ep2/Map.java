package ep2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;


public final class Map extends JPanel implements ActionListener {

    private final int SPACESHIP_X = 220;
    private final int SPACESHIP_Y = 430; 
    private int i = 0;
    private int qtd = 40;
    private int count = 0, d = 0;
    
    private final Timer timer_map;
    private final Timer timer_aliens;
    private final Image background;
    private final Image backgrounds;
    private final Image backgroundsSpace;
    private final Spaceship spaceship;
    public static Menu menu;
    private Rank rank;
    private Cadastro cadastro;
    private Sound som;
    private Sound somfundo;
    private Sound gameover;
    private Sound game;
    private int cadastrue = 1;
   
    private final ArrayList<Aliens> aliens = new ArrayList<>();
    public Rectangle playButton = new Rectangle(380,15,100,30);
    
    public static enum STATE{
        MENU,
        GAME,
        HELP,
        GAMEOVER,
        PAUSE,
        PLAY,
        CADASTRO
    };
    
    public static STATE State = STATE.MENU;

    public Map() {
        
        addKeyListener(new KeyListerner());
        addMouseListener(new MouseInput());
        som = new Sound("boom");
        somfundo = new Sound("fundo");
        gameover = new Sound("gameover");
        game = new Sound("fundoGame");
        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon image = new ImageIcon("images/images.gif");
        this.background = image.getImage();
        
        ImageIcon images = new ImageIcon("images/giphy.gif");
        this.backgrounds = images.getImage();
        
        ImageIcon imagesSpace = new ImageIcon("images/space.jpg");
        this.backgroundsSpace = imagesSpace.getImage();
        rank = new Rank();
        menu = new Menu();
        cadastro = new Cadastro();
        spaceship = new Spaceship(SPACESHIP_X, SPACESHIP_Y);                     
        timer_map = new Timer(Game.getDelay(), this);     
        timer_map.start();
        timer_aliens = new Timer(150, new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                if(State == STATE.GAME)
                                                    aliens.add(new Aliens(0,0,spaceship.getScore()));
     
                                            }          
                                });     
         timer_aliens.start();
         
                            
    }
   
    @Override
    public void paintComponent(Graphics g) {
        
       
        
        super.paintComponent(g);
        
  
        
        if(State == STATE.PAUSE)
           g.drawImage(this.backgroundsSpace, 0, 0, null); 
        
        else if(State != STATE.GAME && State != STATE.PAUSE) 
            g.drawImage(this.backgrounds, 0, 0, null); 
        
        
        if(State == STATE.CADASTRO && cadastrue == 1){
            //rank.render();
            cadastro.Cadastro();
            cadastrue = 0;
        }
        if(State == STATE.GAME){
            cadastro = new Cadastro();
            Graphics2D g2d = (Graphics2D)g;
            g.drawImage(this.background, 0, 0, null); 
            Font fnt1 = new Font("italic",Font.BOLD,20);
            g.setFont(fnt1);
            g.setColor(Color.WHITE);
            g.drawString("Pause",playButton.x + 17 ,playButton.y +20);
            g.setColor(Color.BLACK);
            g2d.draw(playButton);
            cadastrue = 1;
        }else if(State == STATE.PAUSE){ 
            Graphics2D g2d = (Graphics2D)g;
            Font fnt1 = new Font("italic",Font.BOLD,20);
            g.setFont(fnt1);
            g.setColor(Color.WHITE);
            g.drawString("Play",playButton.x + 17 ,playButton.y +20);
            g.setColor(Color.BLACK);
            
        }
        //if(State == STATE.GAME || State == STATE.PAUSE)   
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g) {
        
        
       if(State == STATE.GAME || State == STATE.PAUSE) 
       {   
            somfundo.getSom().stop();
            if(d == 2){
                
                game.getSom().loop(); 
                d = 1;
           }
            con(g);
            if(spaceship.getScore() == 40 || spaceship.getScore() == 100)
                dranMissionAccomplished(g);
       }
       else if(State == STATE.MENU){
                if(d == 0){
                    
                    gameover.getSom().stop();
                    somfundo.getSom().loop();
                    
                    d = 2;
                }
                 menu.menuInicial(g);
           
           
           
       }
       else if (State == STATE.GAMEOVER){
           menu.menuFinal(g);
           game.getSom().stop(); 
                if(d == 1){
                    rank.escritor(cadastro.getNome(),spaceship.getScore());
                    
                    gameover.getSom().play(); 
                    d = 0;
                }
       }
            
           
       
               
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        transicao();
        Clear();              
        updateSpaceship();   
        updateAliens();
        UpdateMissiles();         
        checarColisoes();               
        repaint();
        //i++;
        
        
    }
    
    private void dranMissionAccomplished(Graphics g) {

        String message = "MISSION ACCOMPLISHED LOADING...";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Game.getWidth() - metric.stringWidth(message)) / 2, Game.getHeight() / 2);
    }
    /*
    private void drawGameOver(Graphics g) {

        String message = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Game.getWidth() - metric.stringWidth(message)) / 2, Game.getHeight() / 2);
    }
    */
    private void updateSpaceship(){
        if(State == STATE.GAME)
            spaceship.move();        
    }
   
    private void updateAliens(){
        
        for (int i = 0; i < aliens.size(); i++){
            Aliens in = aliens.get(i);
            
            if(in.isVisible() && State == STATE.GAME){
		in.move();
            }else if(!in.isVisible())
                aliens.remove(i);
            
        }
        
    }
    private void transicao(){
          if(spaceship.getScore() == qtd ){
              
            for (int i = 0; i < aliens.size() ; i++){
                Aliens in = aliens.get(i);
                
                in.setVisible(false);
                in.explode();
                //aliens.remove(i);
               
                
                count++;
               
                 if (count == 120 && spaceship.getScore() == 40){
                     count = 0;
                     qtd = 100;
                     
                 }
                 else if(count == 120 && spaceship.getScore() == 100){
                     count = 0;
                     qtd = 40;
                    
                 }
          }
      
       }
    }
    
    
    private void UpdateMissiles(){
        List<Missile> misseis = spaceship.getMissiles();
        for (int i = 0; i < misseis.size(); i++) {
            Missile in = misseis.get(i);
		if (in.isVisible()) 
                    in.move();
		else
                    misseis.remove(i);               				
        }
    }
    public void Clear(){
        
        if(State != STATE.GAME && State != STATE.PAUSE ){
            for (int i = 0; i < aliens.size(); i++){
                Aliens in = aliens.get(i);
                in.setVisible(false);
                aliens.remove(i);                           			
        }
            
          List<Missile> misseis = spaceship.getMissiles();
        for (int i = 0; i < misseis.size(); i++) {
            Missile in = misseis.get(i);
		in.setVisible(false);
                 misseis.remove(i);
                 
        }
            spaceship.resetPosition();
            spaceship.setVisible(false);
           
            //spaceship = null;
            //new Spaceship(SPACESHIP_X, SPACESHIP_Y);
            spaceship.resetScore();
            spaceship.setLive();
            
            
            
        }
        
    }
    
    public void checarColisoes() {
		Rectangle formaNave = spaceship.getBounds();
		Rectangle formaInimigo;
                Rectangle formaMissil;
		List<Missile> misseis = spaceship.getMissiles();

                
                
		for (int i = 0; i < aliens.size(); i++) {
                    Aliens tempInimigo = aliens.get(i);
                    formaInimigo = tempInimigo.getBounds();
                    Aliens in = aliens.get(i);
			if (formaNave.intersects(formaInimigo)) {
                            spaceship.setDano(in.getDanos());
                            tempInimigo.setVisible(false);                               
                            in.explode();
                            som.getSom().play();
                            if (spaceship.getDano() <= 0){
                            State  = State.GAMEOVER;
                            spaceship.setVisible(false);
                            }                                        				
			}
                }
		

		for (int i = 0; i < misseis.size(); i++) {
			Missile tempMissel = misseis.get(i);
			formaMissil = tempMissel.getBounds();
                        

			for (int j = 0; j < aliens.size(); j++) {
                            Aliens tempInimigo = aliens.get(j);
                            formaInimigo = tempInimigo.getBounds();
                            Aliens in = aliens.get(j);

				if (formaMissil.intersects(formaInimigo)) {
                                    tempInimigo.setVisible(false);
                                    tempMissel.setVisible(false);
                                    in.explode();
                                    som.getSom().play();
                                    spaceship.setScore(in.getScore());
                                    if (spaceship.getScore() >= 300){
                                        State  = State.GAMEOVER;
                                        spaceship.setVisible(false);
                                    }
				}
			}
		}
               
                        
		
    }
    
    private class KeyListerner extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        
    }
private void con(Graphics g){
                g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);
        
        for (int i = 0; i < aliens.size(); i++){
            Aliens in = aliens.get(i);
            g.drawImage(in.getImage(), in.getX(), in.getY(), this);
        }
        
        List<Missile> misseis = spaceship.getMissiles();
        
        for (int i = 0; i < misseis.size(); i++){
            Missile in = misseis.get(i);
            g.drawImage(in.getImage(), in.getX(), in.getY(), this);
	}
        Font fnt1 = new Font("italic",Font.BOLD,12);
        g.setFont(fnt1);
        g.setColor(Color.RED);
        g.drawString("Lives: " + spaceship.getDano(), 10, 10);
        g.setColor(Color.GREEN);
        g.drawString("Score: " + spaceship.getScore(), 10, 25);    
    }
}
 
    
