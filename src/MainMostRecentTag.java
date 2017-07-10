
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainMostRecentTag {

    public static void main(String[] args) throws IOException {
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
//            System.out.println(link);
            linkList.add(link);

            String baslik = el.select("a > h2").first().ownText();
//            System.out.println(baslik);
            baslikList.add(baslik);

            String ozet = el.select("a > p").first().ownText();
//            System.out.println(ozet+"\n");
            ozetList.add(ozet);
        }

        String link = linkList.get(3);
//        System.out.println(link + "\n\n");
        connection = Jsoup.connect(link);
        connection.timeout(15000);
        doc = connection.get();

        Elements elements = doc.select("main.article-main-component__content");
        elements = doc.getAllElements();

        for (int i = 0; i < elements.size(); i++) {
            Element el = elements.get(i);
            if (el.tagName().equals("h1")) {
//                System.out.println(el.ownText() + "\n"); // BAŞLIKLAR
                break;
            }
        }

        ArrayList<Element> pList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            Element el = elements.get(i);
            Element elP = el.select("p").first();
            Element elH3 = el.select("h3").first();

            if (elP != null && !pList.contains(elP)) {
                if (!elP.ownText().equals("CNMN Collection")) {
                    pList.add(elP);
                    System.out.println(elP.text().trim()); // İçerik
                } else {
                    break;
                }
            }

            if (elH3 != null && !pList.contains(elH3)) { // Ara başlıklar
                pList.add(elH3);
                System.out.println(elH3.text().trim());
            }
        }

        for (int i = 0; i < pList.size(); i++) {
            if (!pList.get(i).ownText().trim().equals(" ")) {
                if (i == 0) {
//                    System.out.print(pList.get(i).ownText().trim().toUpperCase() + " "); // MAKALE    
                } else {
//                    System.out.println(pList.get(i).ownText().trim()); // MAKALE
                }

            }
        }

//        getFindArticles();
    }

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
//            System.out.println(link);
            linkList.add(link);

            String baslik = el.select("a").first().select("h2").first().ownText();
            baslikList.add(baslik);

            String ozet = el.select("a").last().select("p").last().ownText();
            ozetList.add(ozet);
        }

        for (int i = 0; i < 1; i++) {
            String link = linkList.get(i);
            connection = Jsoup.connect(link);
            connection.timeout(15000);
            doc = connection.get();

            String articleContent = "", articleTitle = "";

            Elements elements = doc.select("main.article-main-component__content");
            elements = doc.getAllElements();

            for (int j = 0; j < elements.size(); j++) {
                Element el = elements.get(j);
                if (el.tagName().equals("h1")) {
                    articleTitle = el.ownText();
//                    System.out.println("el : " + el.ownText()); // BAŞLIKLAR
                    break;
                }
            }

            ArrayList<Element> pList = new ArrayList<>();
            for (int j = 0; j < elements.size(); j++) {
                Element el = elements.get(j);
                if (el.tagName().equals("p")) {
                    pList.add(el);
                }
            }

            StringBuilder build = new StringBuilder();
            for (int j = 0; j < pList.size(); j++) {
                build.append(pList.get(j).ownText().trim() + "\n");
//                System.out.println(pList.get(j).ownText().trim()); // MAKALE
            }
            articleContent = build.toString();
//            System.out.println("articleTitle : " + articleTitle + "\n\n");
            System.out.println("articleContent : " + articleContent);
        }

    }

}
