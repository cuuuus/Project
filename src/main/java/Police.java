import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Police extends  Entity {

    double speed = 1;

    Police(int x, int y, String image) {

        width = 40;
        height = 40;

        this.x = x;
        this.y = y;

        setImage(image);
    }


    public void move(Player player, ArrayList<Box> boxes) {

        if (player.getX() > x) {
            x += speed;

            setImage("Police/police_front.png");
            for (Box box: boxes){
                if (box.getRectangle().intersects(getRectangle())){
                    x -= speed;
                }
            }

        } else if (player.getX() < x) {
            x -= speed;
            setImage("Police/police_front_left.png");
            for (Box box: boxes){
                if (box.getRectangle().intersects(getRectangle())){
                    x += speed;
                }
            }
        }

        if (player.getY() > y) {
            y += speed;
            setImage("Police/police_front.png");
            for (Box box: boxes){
                if (box.getRectangle().intersects(getRectangle())){
                    y -= speed;
                }
            }

        } else if (player.getY() < y) {
            y -= speed;
            setImage("Police/police_back.png");
            for (Box box: boxes){
                if (box.getRectangle().intersects(getRectangle())){
                    y += speed;

                }
            }
        }
    }
}