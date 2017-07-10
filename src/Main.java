
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {


    public static void main(String[] args) throws IOException {
        String adr = "https://www.wired.com/most-popular";

        Connection connection = Jsoup.connect(adr);
        connection.timeout(10000);
        Document doc = connection.get();
        
        Elements list = doc.select("ul#most-pop-list > li > a");
        ArrayList<String> linkList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Element el = list.get(i);
            String url = el.attr("href");
            linkList.add(url);
            System.out.println(url);
        }
        
        String subAdr = linkList.get(0);
        connection = Jsoup.connect(subAdr);
        connection.timeout(15000);
        doc = connection.get();
        
        Elements subList = doc.select("main#main > div#post-2256016 > section.post-container.clearfix.relative > article.content.link-underline.relative.body-copy > p");
        for (int i = 0; i < subList.size(); i++) {
            Element el = subList.get(i);
            System.out.println(el.ownText());
        }
        
        
        

        
//        Document doc = Jsoup.connect(URL).get();
        
//        System.out.println("title : " + title);

//        System.out.println(doc);
//con();

// get all links in page
//      Elements links = doc.select("a[href]");
//      for (Element link : links) {
//        // get the value from the href attribute
//        System.out.println("\nlink: " + link.attr("href"));
//        System.out.println("text: " + link.text());
//      }
//      
//
//        for (Element table : doc.select("table.DataTbl")) {
//            for (Element row : table.select("tr")) {
//                Elements tds = row.select("td");
//                if (tds.size() > 1) {
//                    System.out.println(tds.get(0).text() + ":"
//                            + tds.get(2).text());
//                }
//            }
//        }

    }

    public static void con() {//OK
        try {
            URL url = new URL("http://google.com/");
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            String line = null;
            StringBuilder tmp = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            while ((line = in.readLine()) != null) {
                tmp.append(line);
            }

            Document doc = Jsoup.parse(tmp.toString());
            System.out.println(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
