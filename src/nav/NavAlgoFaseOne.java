package nav;

import misc.Ball;
import misc.Robot;

import java.text.DecimalFormat;

public class NavAlgoFaseOne {
    public static final double ANGLE_ERROR = 0.03;
    public static final double DISTANCE_ERROR = 3;
    public static final boolean SIMULATE = true;



    private Ball nextBall;
    private Robot robot;
    //---------------------------
    //constructor
    //---------------------------
    public NavAlgoFaseOne() {
    }

    public NavAlgoFaseOne(Ball nextBall, Robot robot) {
        this.nextBall = nextBall;
        this.robot = robot;
    }

    //---------------------------
    //nav algo
    //---------------------------

    public String nextCommand(){
        String command = "";
        //turn
        double angleDelta = robot.getDirection() - Math.atan((nextBall.getyPos()-robot.getyPos())/(nextBall.getxPos()-robot.getxPos()));
        if (Math.abs(angleDelta) > ANGLE_ERROR) {
            command += "turn -";
            if (angleDelta < 0) {
                command += "r";
            } else {
                command += "l";
            }
            command += " -s" + String.format("%.2f", Math.abs(angleDelta / 2)).replace(',','.') + "";
        } else {
            command += "stop -t";
        }
        //drive
        if(Math.abs(angleDelta) > ANGLE_ERROR){
            if(SIMULATE){
                robot.setDirection(robot.getDirection()-angleDelta/2);
            }
            return command;
        }

        double distDelta = Math.sqrt(Math.pow((nextBall.getxPos()- robot.getxPos()), 2)+Math.pow((nextBall.getyPos()- robot.getyPos()), 2));
        if(distDelta > DISTANCE_ERROR){
            command += ";drive -s" + String.format("%.2f", distDelta/2).replace(',','.');
        } else {
            command += ";stop -d";
        }
        if(SIMULATE){
            robot.setDirection(robot.getDirection()-angleDelta/2);
            robot.setxPos((int) (robot.getxPos()+Math.cos(robot.getDirection())*distDelta/2));
            robot.setyPos((int) (robot.getyPos()+Math.sin(robot.getDirection())*distDelta/2));
        }
        return command;
    }

    //---------------------------
    //getter setter
    //---------------------------
    public Robot getRobot() {
        return robot;
    }
    public void setRobot(Robot robot) {
        this.robot = robot;
    }
    public Ball getNextBall() {
        return nextBall;
    }
    public void setNextBall(Ball nextBall) {
        this.nextBall = nextBall;
    }



}
