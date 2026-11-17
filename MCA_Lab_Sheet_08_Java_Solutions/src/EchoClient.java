import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5001);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter message (bye to stop): ");
            String message = keyboard.readLine();
            out.println(message);
            System.out.println("Echo: " + in.readLine());
        } catch (Exception e) { System.err.println("Client error: " + e.getMessage()); }
    }
}
