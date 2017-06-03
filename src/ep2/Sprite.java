package ep2;

import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {
        ImageIcon ii;
       
            ii = new ImageIcon(imageName);
            image = ii.getImage();
            getImageDimensions();
        
       
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean enable) {
        visible = enable;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}