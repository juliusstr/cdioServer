package server;

import misc.Ball;
import misc.Robot;
import nav.NavAlgoFaseOne;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server=new Server();
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
        misc.Robot robot = new Robot(1,1,1);
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
