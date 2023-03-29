package server;

import exceptions.NoGoodCircleData;
import imageRecognition.ImgRec;
import imageRecognition.ImgRecFaseOne;
import misc.*;
import misc.Robot;
import nav.NavAlgoFaseOne;
import org.opencv.core.Core;
import routePlaner.RoutePlanerFaseOne;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerController server=new ServerController();
        server.start(6666);
        server.stop();
    }
}

class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Scanner scanner = new Scanner(System.in);

    public void start(int port) throws IOException, InterruptedException {

        NavAlgoFaseOne nav = new NavAlgoFaseOne();
        Ball ball = new Ball(20,20,10,new Color(2,2,2),true);
        misc.Robot robot = new Robot(1,1,new Vector2D(1,1));
        nav.setNextBall(ball);
        nav.setRobot(robot);

        serverSocket = new ServerSocket(port);
        System.out.println("ready to recive");
        clientSocket = serverSocket.accept();
        System.out.println("er her");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting;
        String respons = "NA";
        do {
            greeting = in.readLine();
            if (greeting != null)
                System.out.println("in: " + greeting);
            if ("Got it".equals(greeting)) {
                Thread.sleep(1000);
                respons = nav.nextCommand();
                out.println(respons);
                System.out.println("sendt : \"" + respons + "\" end.");
            } else {
                out.println("unrecognised greeting");
            }
        } while (!respons.equals("exit"));
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}

class ServerController {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException, InterruptedException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.err.println("lib loaded");
        ImgRecFaseOne imgRec = new ImgRecFaseOne();

        List<Ball> balls = new ArrayList<>();
        RoutePlanerFaseOne routePlanerFaseOne = new RoutePlanerFaseOne();

        Ball initBall = new Ball(0,0,0,null,false);

        Robot robot = new Robot(0,0,new Vector2D(1,1));

        routePlanerFaseOne.setRobot(robot);

        serverSocket = new ServerSocket(port);
        System.out.println("ready to recive");
        clientSocket = serverSocket.accept();
        System.out.println("er her");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting;
        String respons = "NA";

        balls = imgRec.captureBalls();
        BallStabilizer stabilizer = new BallStabilizer();
        routePlanerFaseOne.clearBalls();
        stabilizer.addBalls(balls);
        try{
            for (Ball ball :
                    stabilizer.getStableBalls()) {
                routePlanerFaseOne.addBallToList(ball);
            }
            ArrayList<Ball> roBall = stabilizer.getStableRobotCircels();
            robot.updatePos(roBall.get(0), roBall.get(1));
        } catch (NoGoodCircleData e){}
        routePlanerFaseOne.addBallToList(initBall);
        routePlanerFaseOne.init();

        do {
            greeting = in.readLine();
            if (greeting != null)
                System.out.println("in: " + greeting);
            if ("Got it".equals(greeting)) {

                balls = imgRec.captureBalls();
                stabilizer.addBalls(balls);
                routePlanerFaseOne.clearBalls();
                try {

                    for (Ball ball :
                            stabilizer.getStableBalls()) {
                        routePlanerFaseOne.addBallToList(ball);
                    }
                    ArrayList<Ball> roBall = stabilizer.getStableRobotCircels();
                    robot.updatePos(roBall.get(0), roBall.get(1));
                    respons = routePlanerFaseOne.nextCommand();
                } catch (NoGoodCircleData e){}

                out.println(respons);
                System.out.println("sendt : \"" + respons + "\" end.");
            } else {
                out.println("unrecognised greeting");
            }
        } while (!respons.equals("exit"));
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
