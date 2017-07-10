package test_tdk;
import java.net.URL;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestTdk {

    public static void main(String[] args) {

        String adr = "http://www.tdk.gov.tr/index.php?option=com_gts&arama=gts&guid=TDK.GTS.595e92726e8f99.66657794";
        try {
            Connection connection = Jsoup.connect(adr);
            connection.timeout(10000);
            Document doc = connection.data("kelime", "kedi").post();
            Elements list = doc.select("div.main_body table tbody tr td table thead span#deyimLabel");

            for (int i = 0; i < list.size(); i++) {
                Element el = list.get(i);
               // System.out.println(i + " : " + el.text());
            }
            /*
                result:
                        0 : Atasˆz¸, deyim ve birle˛ik fiiller
                        1 : Birle˛ik Sˆzler
             */
            
            list = doc.select("div.main_body table tbody tr td table tbody tr td a");
            for (int i = 0; i < list.size(); i++) {
                Element el = list.get(i);
                 String url = el.attr("abs:href");
                System.out.println(i + " : " + url);
            }
            
            /*
            0 : http://www.tdk.gov.tr/index.php?option=com_gts&arama=gts&kelime=kedi 
            ciere bakar gibi bakmak (veya s¸zmek veya seyretmek)&cesit=1&guid=TDK.GTS.595f473c100652.88834370
            1 : http://www.tdk.gov.tr/index.php?option=com_gts&arama=gts&kelime=kedi 
            gibi&cesit=2&guid=TDK.GTS.595f473c1007a2.51484174
            */
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


