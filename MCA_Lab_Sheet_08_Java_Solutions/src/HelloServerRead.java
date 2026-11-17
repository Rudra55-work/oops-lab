import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServerRead {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Waiting for client on port 5000...");
            try (Socket socket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message = in.readLine();
                System.out.println("Received from client: " + message);
            }
        } catch (Exception e) { System.err.println("Server error: " + e.getMessage()); }
    }
}
