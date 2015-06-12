import BL.RssItem;
import java.io.IOException;
import java.net.MalformedURLException;
    import java.net.URL;  
import java.util.logging.Level;
import java.util.logging.Logger;
    import javax.xml.parsers.DocumentBuilder;  
    import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;
    import org.w3c.dom.Document;  
    import org.w3c.dom.Element;  
    import org.w3c.dom.Node;  
    import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;
      
    public class FeedReader {  
      
       private static FeedReader instance = null;  
      
       private URL rssURL;  
      
       private FeedReader() {}  
      
//       public static FeedReader getInstance() {  
//          if (instance == null)  
//             instance = new FeedReader();  
//          return instance;  
//       }  
      
       public void setURL(URL url) {  
          rssURL = url;  
       }  
      
       public String  getFeed() {  
           String output="";
          try {  
             DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
             Document doc = builder.parse(rssURL.openStream());  
             
             NodeList items = doc.getElementsByTagName("item");  
      
             for (int i = 0; i < items.getLength(); i++) {  
                Element item = (Element)items.item(i);  
                RssItem it = new RssItem(getValue( item, "title"), getValue((Element) item, "description"), getValue((Element) item, "link"));
                output+=it.toString();
             }  
          } catch (ParserConfigurationException | IOException | SAXException e) {  
              System.out.println(e.toString());  
          }  
          return output;
       }  
      
       public String getValue(Element parent, String nodeName) {  
          return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();  
       }  
      
       public static void main(String[] args) {  
          try {  
             FeedReader reader = new FeedReader();
             reader.setURL(new URL("http://rss.orf.at/news.xml"));  
             reader.getFeed();  
          } catch (Exception e) {  
             e.printStackTrace();  
          }  
       }  
       
       
       public void feedSwitcher(String selection)
       {
           try {
               URL selectionUrl;
               switch(selection.toLowerCase())
               {
                   case "news" : selectionUrl = new URL("http://rss.orf.at/news.xml");
                   case "sport" :selectionUrl = new URL("http://rss.orf.at/sport.xml");
                   case "discussion":selectionUrl = new URL("http://rss.orf.at/debatten.xml");
                   case "help": selectionUrl = new URL("http://rss.orf.at/help.xml");
                   case "science": selectionUrl = new URL("http://rss.orf.at/science.xml");
                   case "oe3": selectionUrl = new URL("http://rss.orf.at/science.xml");
                   case "fm4": selectionUrl = new URL("http://rss.orf.at/fm4.xml");
                   default: selectionUrl = new URL("http://rss.orf.at/news.xml");
               }
           } catch (MalformedURLException ex) {
               System.out.println(ex.toString());
           }
       }
    }  