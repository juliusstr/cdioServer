package server;

import misc.Ball;
import misc.Robot;
import nav.NavAlgoFaseOne;

import java.awt.*;

public class TestMain {
    public static void main(String[] args) {
        NavAlgoFaseOne nav = new NavAlgoFaseOne();
        Ball ball = new Ball(20,20,10,new Color(2,2,2),true);
        Robot robot = new Robot(1,1,0.5);
        nav.setNextBall(ball);
        nav.setRobot(robot);
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());
        System.out.println(nav.nextCommand() + "  :  " + nav.getRobot().getxPos() + " " + nav.getRobot().getyPos()+ " "+ nav.getRobot().getDirection()+"  :  " + nav.getNextBall().getxPos() +" "+ nav.getNextBall().getyPos());

    }
}
