public class Box extends Entity{
    Box(int x, int y){
        width = 50;
        height = 50;

        this.x = x;
        this.y = y;

        setImage("box.png");
    }
}
