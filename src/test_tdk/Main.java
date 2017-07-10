package test_tdk;

import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        try {
            String action = "index.php?option=com_gts&arama=gts&guid=TDK.GTS.595d09e34be0d4.32908282";
            String adr = "http://tdk.gov.tr/";
            adr += action;

            Connection connection = Jsoup.connect(adr);
            connection.timeout(10000);
            Document doc = connection.data("kelime", "kedi")
                    .post();

//            Elements list = doc.select("div.mainEventContent > div.content > div.main_body > div.moduletable-left");
// Güncel Türkçe Sözlük başlığı alınır. ***

            Elements list = doc.select("div.mainEventContent > div.content > div.main_body > "
                    + "table > tbody > tr > td > table#hor-minimalist-a > tbody > tr > td");
            // Kelimenin anlamlarını alır ***
            
//            Elements list = doc.select("div.mainEventContent > div.content > div.main_body > "
//                    + "table > tbody > tr > td > table#hor-minimalist-a > thead > tr > th");
//             Kelime özet cümlesinin tamamı HER İKİ SATIR ***
            
//            Elements list2 = doc.select("div.mainEventContent > div.content > div.main_body > "
//                    + "table > tbody > tr > td > table#hor-minimalist-a > thead > tr > th > i");
            // Kelime özet cümlesinin tamamı SON SATIR ***

//            String listAll = list.text();
//            String listLast = list2.text();
//            
//            String newStr = listAll.substring(0, listLast.length()-listAll.length());
//            System.out.println("newStr : " + newStr);
            
            System.out.println(list.text());
       
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
