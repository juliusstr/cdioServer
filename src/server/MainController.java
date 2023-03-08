package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) throws IOException {
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

    public void start(int port) throws IOException {
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
            System.out.println("in: " + greeting);
            if ("Got it".equals(greeting)) {
                respons = scanner.nextLine();
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
