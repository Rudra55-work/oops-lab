import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5001)) {
            System.out.println("Echo server listening on port 5001...");
            try (Socket socket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String message;
                while ((message = in.readLine()) != null) {
                    out.println(message);
                    if ("bye".equalsIgnoreCase(message)) break;
                }
            }
        } catch (Exception e) { System.err.println("Echo server error: " + e.getMessage()); }
    }
}
