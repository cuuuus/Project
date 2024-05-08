import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

    GameLogic logic;
    GameGraphics graphics;
    int width = 800, height = 600;
    GamePanel(){
        setPreferredSize(new Dimension(width,height));

    logic = new GameLogic();

    graphics= new GameGraphics(logic);

    Thread thread = new Thread(this);
            thread.start();

           addKeyListener(logic.player);
            setFocusable(true);
            requestFocus();
    addKeyListener(logic);
}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics.draw(g);

    }

    @Override
    public void run() {
        while (true){
            if (logic.GameActive){
                logic.update();
            }
            repaint();
            try{
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

