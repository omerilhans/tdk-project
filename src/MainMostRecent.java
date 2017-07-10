
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainMostRecent {

    public static void main(String[] args) throws IOException {

        String adr = "https://www.wired.com/most-recent/";

        Connection connection = Jsoup.connect(adr);
        connection.timeout(10000);
        Document doc = connection.get();

        Elements list = doc.select("div.main--archive-listing > div.main--archive-listing__wrapper > "
                + "div.archive-listing-main-component > div.archive-listing-component > "
                + "div.archive-list-component.archive-list-component-- > ul.archive-list-component__items > "
                + "li.archive-item-component");
        
//        System.out.println(list.size());
        
        ArrayList<String> baslikList = new ArrayList<>();
        ArrayList<String> ozetList = new ArrayList<>();
        ArrayList<String> linkList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Element el = list.get(i);
            String link = el.select("a").first().attr("abs:href");
            System.out.println(link);
            linkList.add(link);

            String baslik = el.select("a").first().select("h2").first().ownText();
//            System.out.println(baslik);
            baslikList.add(baslik);

            String ozet = el.select("a").last().select("p").last().ownText();
//            System.out.println(ozet + "\n\n");
            ozetList.add(ozet);
        }
        
        

        String l1 = "https://www.wired.com/story/flight-rail-vectorr-atmospheric-railway-train/";
        String l2 = "https://www.wired.com/story/world-best-cycling-cities-copenhagenize/";
        String l3 = "https://www.wired.com/story/mircosoft-ai-ms-pac-man/";
        String l4 = "https://www.wired.com/story/instagram-sponsored-posts/";
        String l5 = "https://www.wired.com/story/vicarious-schema-networks-artificial-intelligence-atari-demo/";
        String l6 = "https://www.wired.com/story/robert-mueller-special-counsel-investigation-team/";
        String l7 = "https://www.wired.com/story/the-maker-of-the-most-iconic-chair-wants-you-to-stand-up/";
        String l8 = "https://www.wired.com/story/urban-heat-islands-can-be-deadly-and-theyre-only-getting-hotter/";
        String l9 = "https://www.wired.com/story/physics-proves-no-one-can-safely-text-and-drive/";
        String l10 = "https://www.wired.com/story/jeff-sessions-war-on-medical-marijuana-gets-public-health-all-wrong/";

        for (int i = 0; i < linkList.size(); i++) {
            connect(linkList.get(i));
        }
        
    }
    
    
    
    public static void connect(String link) throws IOException{
        System.out.println("Gelen link : " + link);
        Connection connection = Jsoup.connect(link);
            connection.timeout(15000);
            Document doc = connection.get();
            Elements makaleBaslik = doc.select("div.article-main-component.article-main-component--default.article-main-component--has-photo > "
                    + "div.article-main-component__wrapper.article-main-component__wrapper--default.article-main-component__wrapper--has-photo > "
                    + "div.article-main-component__columns > main.article-main-component__content > "
                    + "header.content-header-component.article-main-component__header.article-main-component__header--default.article-main-component__header--inner > "
                    + "h1.title");

            System.out.println(makaleBaslik.first().ownText() + "\n");

            Elements makale = doc.select("div.article-main-component.article-main-component--default.article-main-component--has-photo > "
                    + "div.article-main-component__wrapper.article-main-component__wrapper--default.article-main-component__wrapper--has-photo > "
                    + "div.article-main-component__columns > main.article-main-component__content > "
                    + "article.article-body-component > div > p");

            for (int j = 0; j < makale.size(); j++) {
                Element el = makale.get(j);
//                System.out.println(el.text());
            }
    }

}
