package CarBooking.Controller;

import java.net.URL;

public class URLHelper {

    public static String getPrevious(String urlString) {
        try {
            URL url = new URL(urlString);
            String path = url.getPath();
            String[] pathSegments = path.split("/");
            String fileName = pathSegments[pathSegments.length - 1];
            if(!fileName.contains(".jsp")) fileName = "index.jsp";
            return fileName;
        } catch (Exception e) {
            System.err.println("Invalid URL: " + e.getMessage());
            return "index.jsp";
        }
    }
}
