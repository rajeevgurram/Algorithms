package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpUtils {
    public static String readDataFromURL(final String URL) {
        StringBuilder data = new StringBuilder();
        try {
            final URL url = new URL(URL);

            // read text returned by server
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                data.append(System.getProperty("line.separator"));
                data.append(line);
            }
            in.close();
        } catch (final Exception e) {
            System.out.println("Exception occurred while reading data from " + URL + ", reason: " + e.getMessage());
        }
        return data.toString();
    }
}
