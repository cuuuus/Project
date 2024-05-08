import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends  Entity implements KeyListener {

    boolean left;
    boolean right;
    boolean up;
    boolean down;
    double speed = 2;
    int score = 0;

    Player(int x, int y, String image) {

        width = 40;
        height = 40;

        this.x = x;
        this.y = y;

        setImage(image);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_S) {
            down = true;
        }

        if (keys == KeyEvent.VK_W) {
            up = true;
        }

        if (keys == KeyEvent.VK_D) {
            right = true;
        }

        if (keys == KeyEvent.VK_A) {
            left = true;
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_S) {
            down = false;
        }

        if (keys == KeyEvent.VK_W) {
            up = false;
        }

        if (keys == KeyEvent.VK_D) {
            right = false;
        }

        if (keys == KeyEvent.VK_A) {
            left = false;
        }

    }

    public void update(ArrayList<Box> boxes){

        if (down){
            y += speed;
            setImage("Player/player_front.png");
            for (Box box: boxes) {
                if (box.getRectangle().intersects(getRectangle())) {
                    y -= speed;
                }
            }
        }


        if (up){
            y -= speed;
            setImage("Player/player_back1.png");
            for (Box box: boxes) {
                if (box.getRectangle().intersects(getRectangle())) {
                    y += speed;
                }
            }
        }

        if (left){
            x -= speed;
            setImage("Player/player_side_left.png");
            for (Box box: boxes) {
                if (box.getRectangle().intersects(getRectangle())) {
                    x += speed;
                }
            }
        }

        if (right){
            x += speed;
            setImage("Player/player_side1.png");
            for (Box box: boxes) {
                if (box.getRectangle().intersects(getRectangle())) {
                    x -= speed;
                }
            }
        }

        if (x <= 50){
            x = 50;
        }

        if (x >= 750 - width){
            x = 750 - width;
        }

        if (y <= 50){
            y = 50;
        }

        if (y >= 550 - height){
            y = 550 - height;
        }
    }
}
