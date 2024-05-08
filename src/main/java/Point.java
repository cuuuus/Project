public class Point extends Entity{

    boolean visible = false;
    Point(int x, int y) {
        width = 25;
        height = 25;

        this.x = x;
        this.y = y;

        setImage("point.jpg");
    }


}
