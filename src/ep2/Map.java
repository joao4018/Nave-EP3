package ep2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
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
    private final Timer timer_map;
    private final Timer timer_aliens;
    private final Image background;
    private final Spaceship spaceship;
    public static Menu menu;
    private final ArrayList<Aliens> aliens = new ArrayList<>();
    public static enum STATE{
        MENU,
        GAME,
        HELP
    };
    
    public static STATE State = STATE.MENU;

    public Map() {
        
        addKeyListener(new KeyListerner());
        addMouseListener(new MouseInput());
        
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon image = new ImageIcon("images/space.jpg");
        this.background = image.getImage();
        
        menu = new Menu();
        spaceship = new Spaceship(SPACESHIP_X, SPACESHIP_Y);                     
        timer_map = new Timer(Game.getDelay(), this);     
        timer_map.start();
        timer_aliens = new Timer(150, new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                if(State == STATE.GAME)
                                                    aliens.add(new Aliens(0, 0));
     
                                            }          
                                });     
         timer_aliens.start();
         
                            
    }
   
    @Override
    public void paintComponent(Graphics g) {
        
       
        timer_aliens.start();
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);  
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g) {
       if(State == STATE.GAME)        
            con(g);
       
       else if(State == STATE.MENU){
           
           State = STATE.HELP;
           menu.render();
       }
       
               
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Clear();
        updateSpaceship();   
        updateAliens();
        UpdateMissiles();         
        checarColisoes();
        repaint();    
        Clear();
    }
    
    /*private void dranMissionAccomplished(Graphics g) {

        String message = "MISSION ACCOMPLISHED";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Game.getWidth() - metric.stringWidth(message)) / 2, Game.getHeight() / 2);
    }
    
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
            in.setImagem(spaceship.getScore());
            if(in.isVisible()){
		in.move();
            }else
                aliens.remove(i);                           			
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
        if(State != STATE.GAME){
            for (int i = 0; i < aliens.size(); i++){
                Aliens in = aliens.get(i);
                in.setVisible(false);
                aliens.remove(i);                           			
        }
            spaceship.resetPosition();            //spaceship = null;
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
                            if (spaceship.getDano() <= 0){
                            State  = State.MENU;
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
                                    spaceship.setScore(in.getScore());
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
        
        g.setColor(Color.RED);
        g.drawString("Lives: " + spaceship.getDano(), 10, 10);
        g.setColor(Color.GREEN);
        g.drawString("Score: " + spaceship.getScore(), 10, 25);    
    }
}
 
    
