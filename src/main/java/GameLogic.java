import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class GameLogic implements KeyListener {
    Player player;
    public ArrayList<Police> police;

    public ArrayList<Donut> donuts;
    public ArrayList<Donut> donutsRemove;

    public ArrayList<Point> points;
    public ArrayList<Point> pointsRemove;

    public ArrayList<Box> boxes;
    boolean GameActive;
    Random random;
    int pointTimer;
    int donutTimer;
    GameLogic(){
        this.police = new ArrayList<>();
        this.boxes = new ArrayList<>();
        this.donuts = new ArrayList<>();
        this.donutsRemove = new ArrayList<>();
        this.points = new ArrayList<>();
        this.pointsRemove = new ArrayList<>();
        random = new Random();

        player = new Player(50, 520, "Player/player_front.png");

        Police police1 = new Police(50, 50, "Police/police_front.png");
        Police police2 = new Police(700, 520, "Police/police_front.png");


        //line1
        Box box1 = new Box(150, 100);
        Box box2 = new Box(150, 150);
        Box box3= new Box(150, 200);
        Box box4 = new Box(150, 250);
        Box box5 = new Box(150, 350);
        Box box6 = new Box(150, 400);
        Box box7 = new Box(150, 500);

        //line2
        Box box8 = new Box(250, 100);
        Box box9 = new Box(250, 50);
        Box box10= new Box(250, 200);
        Box box11 = new Box(250, 250);
        Box box12 = new Box(250, 300);
        Box box13 = new Box(250, 350);
        Box box14 = new Box(250, 400);
        Box box15 = new Box(250, 450);

        //line 3
        Box box16 = new Box(350, 100);
        Box box17 = new Box(350, 150);
        Box box18= new Box(350, 200);
        Box box19 = new Box(350, 500);
        Box box20 = new Box(350, 300);
        Box box21 = new Box(350, 350);
        Box box23 = new Box(350, 450);

        //line4
        Box box24 = new Box(450, 50);
        Box box25 = new Box(450, 100);
        Box box26= new Box(450, 200);
        Box box27 = new Box(450, 250);
        Box box28 = new Box(450, 300);
        Box box29 = new Box(450, 350);
        Box box30 = new Box(450, 400);
        Box box31 = new Box(450, 450);

        //line 5
        Box box32 = new Box(550, 100);
        Box box33 = new Box(550, 150);
        Box box34= new Box(550, 200);
        Box box35 = new Box(550, 250);
        Box box36 = new Box(550, 350);
        Box box37 = new Box(550, 400);
        Box box38 = new Box(550, 500);

        //line 6
        Box box39 = new Box(650, 100);
        Box box40 = new Box(650, 50);
        Box box41= new Box(650, 200);
        Box box42 = new Box(650, 250);
        Box box43 = new Box(650, 300);
        Box box44 = new Box(650, 350);
        Box box45 = new Box(650, 400);
        Box box46 = new Box(650, 500);




        police.add(police1);
        police.add(police2);


        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);
        boxes.add(box5);
        boxes.add(box6);
        boxes.add(box7);

        boxes.add(box8);
        boxes.add(box9);
        boxes.add(box10);
        boxes.add(box11);
        boxes.add(box12);
        boxes.add(box13);
        boxes.add(box14);
        boxes.add(box15);

        boxes.add(box16);
        boxes.add(box17);
        boxes.add(box18);
        boxes.add(box19);
        boxes.add(box20);
        boxes.add(box21);
        boxes.add(box23);

        boxes.add(box24);
        boxes.add(box25);
        boxes.add(box26);
        boxes.add(box27);
        boxes.add(box28);
        boxes.add(box29);
        boxes.add(box30);
        boxes.add(box31);

        boxes.add(box32);
        boxes.add(box33);
        boxes.add(box34);
        boxes.add(box35);
        boxes.add(box36);
        boxes.add(box37);
        boxes.add(box38);

        boxes.add(box39);
        boxes.add(box40);
        boxes.add(box41);
        boxes.add(box42);
        boxes.add(box43);
        boxes.add(box44);
        boxes.add(box45);
        boxes.add(box46);


    }
    public void update(){
        collision();

        pointTimer++;
        player.update(boxes);
        points.removeAll(pointsRemove);
        if(pointTimer >= 110){
            pointTimer = 0;
            points.add(new Point(random.nextInt(50, 725), random.nextInt(50, 525)));
        }

        donutTimer++;
        player.update(boxes);
        donuts.removeAll(donutsRemove);
        if(donutTimer >= 700){
            donutTimer = 0;
            donuts.add(new Donut(random.nextInt(50, 725), random.nextInt(50, 525)));
        }


        for(Police police: police){
            police.move(player, boxes);
        }

    }

    public void collision(){

        for(Point point: points){
            if (point.getRectangle().intersects(player.getRectangle())&& point.visible){
                pointsRemove.add(point);
                player.score++;
                System.out.println(player.score);
            }
            for(Box box: boxes){
                if (point.getRectangle().intersects(box.getRectangle())){
                    pointsRemove.add(point);

                }else {
                    point.visible = true;
                }
            }
        }

        for(Donut donut: donuts){
            if (donut.getRectangle().intersects(player.getRectangle())&& donut.visible){
                donutsRemove.add(donut);
                player.speed += 0.2;
            }
            for(Box box: boxes){
                if (donut.getRectangle().intersects(box.getRectangle())){
                    donutsRemove.add(donut);

                }else {
                    donut.visible = true;
                }
            }
        }

        for(Police police2: police){
            if (police2.getRectangle().intersects(player.getRectangle())){
                GameActive = false;

            }
            for (Police police1: police){
                if (police2.getRectangle().intersects(police1.getRectangle())){
                    if (police1.getX() > police2.getX()) {
                        police1.x += police1.speed;

                    } else if (police1.getX() < police2.getX()) {
                        police1.x -= police2.speed;

                    }
                        if (police1.getY() > police2.getY()) {
                            police1.y += police1.speed;

                        } else if (police1.getY() < police2.getY()) {
                            police1.y -= police2.speed;

                        }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE&&!GameActive){
            GameActive = true;
    }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
