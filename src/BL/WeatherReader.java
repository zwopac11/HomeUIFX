/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import com.sun.jndi.toolkit.url.Uri;
import com.sun.org.apache.xalan.internal.xsltc.dom.DOMBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import static java.net.Proxy.Type.HTTP;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import static javafx.css.StyleOrigin.USER_AGENT;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.*;

/**
 *
 * @author Claudio
 */
public class WeatherReader {

    //http://xoap.weather.com/weather/local/30915
    //File request = new File("http://xoap.weather.com/weather/local/30915");
    File weather = new File(System.getProperty("user.dir")+"\\"+"src\\"+"weatherdata.xml");
    String url = "api.worldweatheronline.com/free/v2/weather.ashx?q=Graz&format=xml&num_of_days=5&key=56ebc33c237872f4d83754eb6372f";
    String testUrl = "api.worldweatheronline.com"+File.separator+"free"+File.separator+"v2"+File.separator+"weather.ashx?q=Graz&format=xml&num_of_days=5&key=56ebc33c237872f4d83754eb6372f";
    //C

    public WeatherDay read() {
        WeatherDay curDay = null;
        try {
            //H:\Dropbox\POS\HomeUI\HomeUIFX\src\data\weatherdata.xml
            //File fXmlFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"data"+File.separator+"weatherdata.xml");


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //java.net.URL urlTemp = new java.net.URL(url);
//           System.out.println(URLEncoder.encode(url, java.nio.charset.StandardCharsets.UTF_8.toString()));
//            String tempUrl = URLEncoder.encode(url, "UTF-8");
            
            Document doc = db.parse(new URL("http://api.worldweatheronline.com/free/v2/weather.ashx?q=Graz&format=xml&num_of_days=5&key=56ebc33c237872f4d83754eb6372f").openStream());
            System.out.println(doc.toString());

            //Parsing of XML children
            Element child = (Element) doc.getElementsByTagName("current_condition").item(0);
            //getting the needed attributes for todays weather
            Element temp = (Element) child.getElementsByTagName("temp_C").item(0);
            Element weatherCode = (Element) child.getElementsByTagName("weatherCode").item(0);
            Element humidity = (Element) child.getElementsByTagName("humidity").item(0);
            Element precipMM = (Element) child.getElementsByTagName("precipMM").item(0);
            Element cloudcover = (Element) child.getElementsByTagName("cloudcover").item(0);
            curDay = new WeatherDay(temp.getTextContent(), weatherCode.getTextContent(), precipMM.getTextContent(), humidity.getTextContent(), cloudcover.getTextContent());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return curDay;
    }

    public static void main(String[] args) {

    }

}
