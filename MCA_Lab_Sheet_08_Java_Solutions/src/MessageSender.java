import java.net.*;

public class MessageSender {
    public static void main(String[] args) {
        byte[] data = "Ping".getBytes();
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getByName("localhost"), 6000);
            socket.send(packet);
            System.out.println("UDP message sent: Ping");
        } catch (Exception e) { System.err.println("UDP sender error: " + e.getMessage()); }
    }
}
