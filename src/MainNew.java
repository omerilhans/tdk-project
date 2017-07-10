
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainNew {

     public static void getFindArticles() throws IOException {
        String adr = "https://www.wired.com/most-recent/";
        Connection connection = Jsoup.connect(adr);
        connection.timeout(10000);
        Document doc = connection.get();

        Elements list = doc.select("div.main--archive-listing > div.main--archive-listing__wrapper > "
                + "div.archive-listing-main-component > div.archive-listing-component > "
                + "div.archive-list-component.archive-list-component-- > ul.archive-list-component__items > "
                + "li.archive-item-component");

        ArrayList<String> baslikList = new ArrayList<>();
        ArrayList<String> ozetList = new ArrayList<>();
        ArrayList<String> linkList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Element el = list.get(i);
            String link = el.select("a").first().attr("abs:href");
            linkList.add(link);

            String baslik = el.select("a").first().select("h2").first().ownText();
            baslikList.add(baslik);

            String ozet = el.select("a").last().select("p").last().ownText();
            ozetList.add(ozet);
        }

        for (int i = 0; i < linkList.size(); i++) {
            String link = linkList.get(i);
            connection = Jsoup.connect(link);
            connection.timeout(15000);
            doc = connection.get();

            Elements elements = doc.select("main.article-main-component__content");
            elements = doc.getAllElements();

            for (int j = 0; j < elements.size(); j++) {
                Element el = elements.get(j);
                if (el.tagName().equals("h1")) {
                    System.out.println("el : " + el.ownText()); // BAŞLIKLAR
                    break;
                }
            }

            ArrayList<Element> pList = new ArrayList<>();
            for (int j = 0; j < elements.size() - 3; j++) {
                Element el = elements.get(i);
                System.out.println(el.tagName());
                if (el.tagName().equals("p")) {
//                    pList.add(el);
//                    System.out.println(el);
                }
            }

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < pList.size(); j++) {
//                builder.append(pList.get(i).ownText());
                System.out.println(pList.get(i).ownText()); // MAKALE
//                break;
            }
//            String content = builder.toString();
//            System.out.println("Content : " + content);

        }
    }
     
}
