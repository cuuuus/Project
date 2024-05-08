import java.util.ArrayList;

public class Donut extends Entity{

    boolean visible = false;
    boolean work = false;
    Donut(int x, int y) {
        width = 25;
        height = 25;

        this.x = x;
        this.y = y;

        setImage("donut.png");
    }


}
