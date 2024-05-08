import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Entity extends Coordinates {

    int width, height;
    BufferedImage image;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRectangle(){
        return new Rectangle((int) x,(int) y, width, height);
    }
    public void draw(Graphics g){
        g.drawImage(image, (int) x, (int) y, width, height, null);

    }

    public void setImage(String file) {
        try {
            image = ImageIO.read(new File("src/main/resources/" + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
