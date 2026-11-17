import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;

public class FileDownloader {
    public static void main(String[] args) {
        String address = "https://www.example.com/sample.txt";
        Path destination = Paths.get("sample.txt");
        try {
            URLConnection connection = new URL(address).openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            try (InputStream in = connection.getInputStream()) {
                Files.copy(in, destination, StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("Downloaded to: " + destination.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Download failed. The example URL may not host sample.txt: " + e.getMessage());
        }
    }
}
