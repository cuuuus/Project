import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGraphics {
    BufferedImage photo;
    GameLogic logic;
    BufferedImage menu;
    GameGraphics(GameLogic logic){
        try {
            photo = ImageIO.read(new File("src/main/resources/map.jpg"));
            menu = ImageIO.read(new File("src/main/resources/sigma.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.logic = logic;

    }

    public void draw(Graphics g){
        g.drawImage(photo, 0, 0,800,600, null);

        if (!logic.GameActive){
            g.drawImage(menu, 0, 0,800,600, null);

        }

        if (logic.GameActive){

            for (Point points: logic.points){
                if (points.visible){
                    points.draw(g);
                }
            }
            for (Donut donut: logic.donuts){
                if (donut.visible){
                    donut.draw(g);
                }
            }

            logic.player.draw(g);

            for (Police police: logic.police){
                police.draw(g);
            }

            for (Box boxes: logic.boxes){
                boxes.draw(g);
            }
        }
    }
}
