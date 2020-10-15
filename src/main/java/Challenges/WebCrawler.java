package Challenges;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create a webcrawler that fetches the data from given url,
 * and fetches any href links present
 *
 * It's a graph problem
 */
public class WebCrawler {
    private final Queue<String> queue = new LinkedList<>();
    private final List<String> visitedURLs = new ArrayList<>();

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        crawler.crawl("https://bbc.com");
    }

    public void crawl(final String url) {
        queue.add(url);
        visitedURLs.add(url);

        while (!queue.isEmpty()) {
            final String _url = queue.remove();
            final String rawHTML = getHTML(_url);

            final String urlRegex = "http[s]?://(\\w+\\.)[a-z1-9]+\\.com";
            Pattern regex = Pattern.compile(urlRegex);
            Matcher urls = regex.matcher(rawHTML);

            while (urls.find()) {
                final String deepURL = urls.group();
                if(!visitedURLs.contains(deepURL)) {
                    queue.add(deepURL);
                    visitedURLs.add(deepURL);
                    System.out.println(deepURL);
                }
            }
        }
    }

    private String getHTML(final String url) {
        StringBuilder html = new StringBuilder();
        try {
            URL httpURL = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURL.openStream()));

            String line;
            while ((line = br.readLine()) != null) {
                html.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return html.toString();
    }
}
