package server;

import exceptions.NoGoodCircleData;
import imageRecognition.ImgRecFaseOne;
import misc.*;
import misc.Robot;
import org.opencv.core.Core;
import org.opencv.highgui.HighGui;
import routePlaner.RoutePlanerFaseOne;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.err.println("lib loaded");
        ImgRecFaseOne imgRec = new ImgRecFaseOne();
        List<Ball> balls = new ArrayList<>();
        BallStabilizer stabilizer = new BallStabilizer();
        for (int i = 0; i < 100; i++) {
            balls = imgRec.captureBalls();
            stabilizer.addBalls(balls);
            System.out.println("ball");

            try {
                for (Ball ball :
                        stabilizer.getStableBalls()) {
                    System.out.println(ball.toString());
                }
            } catch (NoGoodCircleData e){
                System.out.println(e.getMessage());
            }

            System.out.println("robot");
            try {
                for (Ball ball :
                        stabilizer.getStableRobotCircels()) {
                    System.out.println(ball.toString());
                }
            } catch (NoGoodCircleData e){
                System.out.println(e.getMessage());
            }

            System.err.println("i" + i);
            Thread.sleep(1000);
        }

        imgRec.destroy();

        /*RoutePlanerFaseOne route = new RoutePlanerFaseOne();
        Ball ball = new Ball(20,0,10,new Color(2,2,2),true);
        Ball ball1 = new Ball(20,20,10,new Color(1,1,1), true);
        Ball ball2 = new Ball(20,5,10,new Color(0,0,0), true);
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
         */

    }
}
