package server;

import misc.Ball;
import misc.Robot;
import misc.Vector2D;
import routePlaner.RoutePlanerFaseOne;

import java.awt.*;

public class TestMain {
    public static void main(String[] args) {
        RoutePlanerFaseOne route = new RoutePlanerFaseOne();
        Ball ball = new Ball(20,0,10,new Color(2,2,2),true);
        Ball ball1 = new Ball(20,20,10,new Color(1,1,1), true);
        Ball ball2 = new Ball(-20,-10,10,new Color(0,0,0), true);
        Robot robot = new Robot(0,0, new Vector2D(0,1));
        route.addBallToList(ball);
        route.addBallToList(ball1);
        route.addBallToList( ball2);
        route.setRobot(robot);
        route.init();
        String command = "";
        do {
            command = route.nextCommand();
            if(!route.isDone()) {
                System.out.println(command + "  :  " + route.getRobot().getxPos() + " " + route.getRobot().getyPos() + " " + route.getRobot().getDirection().getAngle() + "  :  " + route.getNextBall().getxPos() + " " + route.getNextBall().getyPos());
            } else {
                System.out.println(command);
            }
        } while (!route.isDone());
    }
}
