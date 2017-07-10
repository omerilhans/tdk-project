
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainMostPopuler {

    public static void main(String[] args) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
