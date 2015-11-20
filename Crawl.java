/**
 * LRsoft Corp.
 * http://lrsoft.co.id
 *
 * Author : Zaf
 */

import java.util.List;

public class Crawl {

  public static void main(String[] args) {

    //String url = "http://ugm.ac.id";
    String url = args[0];
    String option = args[1];

    HTMLUtils test = new HTMLUtils();

    switch( option ) {
      case "source" :
        System.out.println( test.getSource(url) );
        break;
      case "metas" :
        System.out.println( test.getMetas(url) );
        break;
      case "links" :
        List<String> links = test.extractLinks(url);
        for (String link : links){
            System.out.println(link);
        }
        System.out.println( "\n\nTotal : " + links.size() + " links found!" );
        break;
      case "robots" :
        System.out.println( test.getRobotsTxtList(url) );
        break;
      default :
        System.out.println( "Format yang benar : Crawl  [url] [source|metas|links|robots]");
    }

  }

}
