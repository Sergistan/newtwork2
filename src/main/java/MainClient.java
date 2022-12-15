import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8088;
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String question1 = in.readLine();
            System.out.println(question1);

            String inputName = scanner.nextLine();
            out.println(inputName);
            out.flush();

            String question2 = in.readLine();
            System.out.println(question2);

            String inputChild = scanner.nextLine();
            out.println(inputChild);
            out.flush();

            String response = in.readLine();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
