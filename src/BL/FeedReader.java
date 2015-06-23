package BL;

import BL.RssItem;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FeedReader {
    private String urlStr1 = "http://rss.orf.at/news.xml";
    
    private URL rssURL= null;

    public void setURL(URL url) {
        rssURL = url;
    }

    public String getFeed(String str) {
        String output = "";
        try {
            if(str.equals("discussion"))
            {
                str= "debatten";
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("http://rss.orf.at/"+str+".xml").openStream());            
            System.out.println("Feed Reader document parsing: "+doc.toString());
            

            NodeList items = doc.getElementsByTagName("item");
            System.out.println("Node list size:"+items.getLength());
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                RssItem it = new RssItem(item.getElementsByTagName("title").item(0).getTextContent(),item.getElementsByTagName("link").item(0).getTextContent() );
                output += it.toString();
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.toString());
        }
        return output;
    }

    public String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getNodeValue();
    }

    public URL feedSwitcher(String selection) {
        URL selectionUrl=null;
        try {
            
            switch (selection.toLowerCase()) {
                case "news":
                    selectionUrl = new URL("http://rss.orf.at/news.xml");
                case "sport":
                    selectionUrl = new URL("http://rss.orf.at/sport.xml");
                case "discussion":
                    selectionUrl = new URL("http://rss.orf.at/debatten.xml");
                case "help":
                    selectionUrl = new URL("http://rss.orf.at/help.xml");
                case "science":
                    selectionUrl = new URL("http://rss.orf.at/science.xml");
                case "oe3":
                    selectionUrl = new URL("http://rss.orf.at/science.xml");
                case "fm4":
                    selectionUrl = new URL("http://rss.orf.at/fm4.xml");
                default:
                    selectionUrl = new URL("http://rss.orf.at/news.xml");
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        }
        System.out.println(selectionUrl.toString());
        return selectionUrl;
    }
}
