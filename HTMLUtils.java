import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLUtils {
    public String getSource(String url){
        String result = null;
        try {
            Document doc = Jsoup.connect(url).get();
            result = doc.outerHtml();
        } catch (IOException ex) {
            System.out.println("getSource error : "+ex.getMessage());
        }
        return result;
    }
    public List<String> extractLinks(String url){
        final ArrayList<String> result = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) result.add(link.attr("abs:href"));
        } catch (IOException ex) {
            System.out.println("extractLinks error : "+ex.getMessage());
        }
        return result;
    }
    public String getMetas(String url){
        String result = null;
        try {
            Document doc = Jsoup.connect(url).get();
            result = "Title :\n" + doc.select("title").text();
            result += "\nDescription :\n" + doc.select("meta[name=description]").attr("content");
            result += "\nKeywords :\n" + doc.select("meta[name=keywords]").attr("content");
        } catch (IOException ex) {
            System.out.println("getMetas error : "+ex.getMessage());
        }
        return result;
    }
    public String getRobotsTxtList(String host) {
  		String ss = "";
  		try {
  			URL url = new URL( host + "/robots.txt" );
  		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
  			String line;
  			while((line = in.readLine()) != null)
  			{
  			    ss += "\n"+line;
  			}
  		} catch (FileNotFoundException e) {
  			System.out.println("robots.txt not found : "+e.getMessage());
  		} catch (IOException e) {
  			System.out.println("IO error while get robots.txt, "+e.getMessage());
  		}
      return ss;
    }
}
