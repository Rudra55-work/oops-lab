import java.io.*;
import java.net.*;

public class MultiClientServer {
    public static void main(String[] args) {
        int port = 5002;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Multi-client server listening on port " + port);
            while (true) {
                Socket client = server.accept();
                Thread worker = new Thread(() -> handleClient(client));
                worker.start();
            }
        } catch (IOException e) { System.err.println("Server error: " + e.getMessage()); }
    }

    private static void handleClient(Socket client) {
        try (client;
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String message = in.readLine();
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                client.getInetAddress() + ": " + message);
        } catch (IOException e) {
            System.err.println("Client handler error: " + e.getMessage());
        }
    }
}
