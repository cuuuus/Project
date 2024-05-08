import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel panel;
    public GameFrame() {

        panel = new GamePanel();
        add(panel);

        setTitle("Moje Hra");

        setSize(600,800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();

        setVisible(true);
    }
}
