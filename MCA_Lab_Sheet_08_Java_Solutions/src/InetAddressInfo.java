import java.net.InetAddress;

public class InetAddressInfo {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Host name: " + local.getHostName());
            System.out.println("IP address: " + local.getHostAddress());
        } catch (Exception e) {
            System.err.println("Unable to get host information: " + e.getMessage());
        }
    }
}
