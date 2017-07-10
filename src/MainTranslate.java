
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainTranslate {

    public static void main(String[] args) throws IOException {

        String from = "en";
        String to = "tr";
        String word = "hello"; //this will be user input text really
        String URL = "https://translation.googleapis.com/language/translate/v2" + from + "/" + to + "/" + word;

        Connection connection = Jsoup.connect(URL);
        connection.timeout(10000);
        Document doc = connection.get();

        System.out.println(doc);

    }
    
    
}
/*

 POST https://translation.googleapis.com/language/translate/v2?key=YOUR_API_KEY
{
  'q': 'Hello world',
  'q': 'My name is Jeff',
  'target': 'de'
}

If the request is successful, the server returns a 200 OK HTTP status code and the response in JSON format:


{
  "data": {
    "translations": [
      {
        "translatedText": "Hallo Welt",
        "detectedSourceLanguage": "en"
      },
      {
        "translatedText": "Mein Name ist Jeff",
        "detectedSourceLanguage": "en"
      }
    ]
  }
}


*/