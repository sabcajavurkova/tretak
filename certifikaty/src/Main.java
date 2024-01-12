import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;

public class Main {
    public static void main(String[] args) throws IOException {

        URL destinationURL = new URL("https://www.google.com");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();

        System.out.println(certs[2]);
    }
}