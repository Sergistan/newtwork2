import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8088);
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Write your name");
        out.flush();

        final String name = in.readLine();

        out.println("Are you child?");
        out.flush();

        final String checkAge = in.readLine();

        if (checkAge.equals("yes")) {
            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            out.flush();
        } else if (checkAge.equals("no")) {
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            out.flush();
        } else {
            out.println("Error input!");
            out.flush();
        }
    }
}
