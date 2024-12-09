import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class DrawDemo extends JFrame {

    ArrayList<Ball2> balls = new ArrayList<>();
  Color []colors = {Color.BLACK,Color.BLUE,Color.RED,Color.CYAN,Color.MAGENTA};

    Random ran = new Random();
    Ball2 a,b;
    public DrawDemo(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);

        a = new Ball2(150,200,50,colors[2]);
        b = new Ball2(40,100,50,colors[1]);

//        for(int i=0;i<3;i++){
//            int r = 20+ran.nextInt(100);
//            int x =ran.nextInt(200);
//            int y = ran.nextInt(200);
//            int index = ran.nextInt(colors.length);
//            balls.add(new Ball(x,y,r,colors[index]));
//        }

        timer.start();


    }

    Timer timer = new Timer(10,(e -> {
//        for(Ball ball:balls)
        a.updatePosition(getWidth(),getHeight(),b);
        b.updatePosition(getWidth(),getHeight(),a);
        repaint();
    }));
//    private void draw() throws InterruptedException {
//Graphics g=getGraphics();
//        Graphics2D g2 = (Graphics2D)g;
//        g2.setColor(Color.BLUE);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
//
//        g2.fillOval(xPosition,yPosition,radius,radius);
//
//    }

//    private void updatePosition(){
//        xPosition+=dx;
//        yPosition+=dy;
//
//        if(xPosition<=0||xPosition>=getWidth()-radius){
//            dx*=-1;
//        }
//
//        if(yPosition<=0||yPosition>=getHeight()-radius){
//            dy*=-1;
//        }
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            //for(Ball ball:balls)
            a.draw(g);
            b.draw(g);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    private class myThread extends Thread{
//        @Override
//        public void run() {
//            super.run();
//            try {
//                draw();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    public static void main(String[] args) {
       new DrawDemo();
    }

}

class Ball2 {
    int xPosition,yPosition,radius;
    int dx=2;
    int dy=2;
    Color color;
    Color []colors = {Color.white,Color.BLUE,Color.RED,Color.cyan,Color.MAGENTA,Color.GREEN,Color.yellow,Color.pink,Color.ORANGE};
    Random ran = new Random();
    public Ball2(int x, int y, int r, Color c){
        radius=r;
        xPosition=x;
        yPosition=y;
        color=c;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(xPosition,yPosition,2*radius,2*radius);
    }

    public  void updatePosition(int width, int height, Ball2 b){
        xPosition+=dx;
        yPosition+=dy;

        if(xPosition<=0||xPosition>=width-2*radius){
            dx*=-1;
        }

        if(yPosition<=0||yPosition>=height-2*radius){
            dy*=-1;
        }


        if(Math.abs(xPosition-b.xPosition)<=2*radius && Math.abs(yPosition-b.yPosition)<=2*radius){
           dx*=-1;
           dy*=-1;
           b.dx*=-1;
           b.dy*=-1;
           color = colors[ran.nextInt(colors.length)];
        }
    }

    public double from(Ball2 b){
        int x1 = xPosition+radius;
        int y1 = yPosition+radius;
        int x2 = b.xPosition+b.radius;
        int y2 = b.yPosition+b.radius;

        return Math.sqrt(Math.pow(x1-x2,2)-Math.pow(y1-y2,2));
    }
}
