import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("HelloServer waiting on port " + port + "...");
            try (Socket client = server.accept()) {
                System.out.println("Client connected");
            }
        } catch (Exception e) { System.err.println("Server error: " + e.getMessage()); }
    }
}
