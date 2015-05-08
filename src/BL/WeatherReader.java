/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import com.sun.org.apache.xalan.internal.xsltc.dom.DOMBuilder;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


/**
 *
 * @author Claudio
 */
public class WeatherReader {

        //http://xoap.weather.com/weather/local/30915
    //File request = new File("http://xoap.weather.com/weather/local/30915");
    //File fXmlFile = new File(System.getProperty("user.dir")+"\\"+"src\\"+"xml_file.xml"
    String url = "http://apidev.accuweather.com/locations/v1/cities/autocomplete?apikey=30915";
    //http://apidev.accuweather.com/locations/v1/search?q=graz&apikey=meSocYcloNe

    public void read() {
        
        try {
            //H:\Dropbox\POS\HomeUI\HomeUIFX\src\data\weatherdata.xml
            File fXmlFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"data"+File.separator+"weatherdata.xml");
            
            /*
            String temp_C;
	    String weatherCode;
	    String windspeedKmph;
	    String winddir16Point;
	    String precipMM;
	    String humidity;
	    String visibility;
	    String cloudcover;
            Baúl
            */
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(fXmlFile);
            Element child = (Element) doc.getElementsByTagName("current_condition").item(0);
            //getting the needed attributes for todays weather
            Element temp = (Element)child.getElementsByTagName("temp_C").item(0);
            Element weatherCode = (Element)child.getElementsByTagName("weatherCode").item(0);
            Element humidity = (Element)child.getElementsByTagName("humidity").item(0);
            Element precipMM = (Element)child.getElementsByTagName("precipMM").item(0);
            Element cloudcover = (Element)child.getElementsByTagName("cloudcover").item(0);
            WeatherDay curDay = new WeatherDay(temp.getTextContent(), weatherCode.getTextContent(), precipMM.getTextContent(), humidity.getTextContent(),cloudcover.getTextContent());
            
            System.out.println(temp.getTextContent());
             
           //System.out.println(nList.toString());
        } catch (Exception e) {
                System.out.println(e.toString());
        }
    }
    
    
    
    public static void main(String[] args) {
        
    }

}
