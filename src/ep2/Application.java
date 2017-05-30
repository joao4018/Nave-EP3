package ep2;

import static ep2.Map.menu;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class Application extends JFrame {
    
    
    public Application(){
        add(new Map());
        setSize(Game.getWidth(), Game.getHeight());
        setTitle("Space Combat Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        
        menu = new Menu();
        
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                
                Application app = new Application();
                
                app.setVisible(true);
            }
        });
    }
}