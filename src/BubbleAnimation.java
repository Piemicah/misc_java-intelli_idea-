import javax.swing.*;
import java.awt.*;

public class BubbleAnimation extends JFrame {

    Bubbles bubbles = new Bubbles();

    public BubbleAnimation(){
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bubbles.add(50,200,200);
        bubbles.add(50,100,50);
        bubbles.add(50,300,120);
        bubbles.add(50,50,120);
        bubbles.add(50,250,20);
        setVisible(true);
        bubbles.print();
        timer.start();
    }

    Timer timer = new Timer(10,(e -> {
//        for(Ball ball:balls)

        bubbles.update(getWidth(),getHeight());

        repaint();
    }));

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {

            bubbles.draw(g);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new BubbleAnimation();
    }
}



class Bubbles {

    private Ball head,tail;

    public Bubbles(){
        head=tail=null;
    }

    public void add(int r, int x, int y){
        Ball ball;
        if(isEmpty()){
            ball=new Ball(null,null,r,x,y);
            head=tail=ball;
        }
        else{
            ball = new Ball(tail,head,r,x,y);
            tail = ball;

        }
    }

    public void update(int width,int height){

            Ball ball = tail;
            do{
                ball.updatePosition(width,height);
                ball=ball.getPrevBall();
            }while (ball!=null);

    }

    public void print(){
        Ball h = tail;
        do{
            System.out.println(h.getxPosition());
            h=h.getPrevBall();
        }while(h!=null);
    }

    public void draw(Graphics g){
        Ball ball = tail;
        do{
            ball.draw(g);
            ball=ball.getPrevBall();
        }while (ball!=null);
    }

    public boolean isEmpty(){
        return head==null;
    }
}

class Ball{
    private Ball prevBall,nextBall;
    private int radius,xPosition,yPosition;
    private int dx=2,dy=2;

    public Ball(Ball pb,Ball nb,int r,int x,int y){
        prevBall=pb;
        nextBall=nb;
        radius=r;
        xPosition=x;
        yPosition=y;
    }

    public void setPrevBall(Ball prevBall) {
        this.prevBall = prevBall;
    }

    public void setNextBall(Ball nextBall) {
        this.nextBall = nextBall;
    }

    public Ball getNextBall(){
        return  nextBall;
    }
    public  Ball getPrevBall(){ return prevBall;}
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(xPosition,yPosition,2*radius,2*radius);
    }
    public int getxPosition(){return xPosition;}

    public void updatePosition(int width,int height){
        xPosition+=dx;
        yPosition+=dy;

        if(xPosition<=0||xPosition>=width-2*radius){
            dx*=-1;
        }

        if(yPosition<=0||yPosition>=height-2*radius){
            dy*=-1;
        }

        if(prevBall!=null) {
            if (Math.abs(xPosition - prevBall.xPosition) <= 2 * radius && Math.abs(yPosition - prevBall.yPosition) <= 2 * radius) {
                dx *= -1;
                dy *= -1;
                prevBall.dx *= -1;
                prevBall.dy *= -1;

            }
        }
            if(nextBall!=null)
            {
            if(Math.abs(xPosition-nextBall.xPosition)<=2*radius && Math.abs(yPosition-nextBall.yPosition)<=2*radius){
                dx*=-1;
                dy*=-1;
                nextBall.dx*=-1;
                nextBall.dy*=-1;

            }
        }



    }
}