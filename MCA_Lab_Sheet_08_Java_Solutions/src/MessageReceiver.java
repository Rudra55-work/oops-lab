import java.net.*;

public class MessageReceiver {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(6000)) {
            System.out.println("UDP receiver listening on port 6000...");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + message + " from " + packet.getAddress());
        } catch (Exception e) { System.err.println("UDP receiver error: " + e.getMessage()); }
    }
}
