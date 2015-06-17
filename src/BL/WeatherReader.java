/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author Claudio
 */
public class WeatherReader {


    File weather = new File(System.getProperty("user.dir") + "\\" + "src\\" + "weatherdata.xml");
    String url1 = "http://api.worldweatheronline.com/free/v2/weather.ashx?q=";
    String url2 = "&format=xml&num_of_days=1&key=56ebc33c237872f4d83754eb6372f";
    String testUrl = "api.worldweatheronline.com" + File.separator + "free" + File.separator + "v2" + File.separator + "weather.ashx?q=Graz&format=xml&num_of_days=5&key=56ebc33c237872f4d83754eb6372f";
    
    /**
     * Return the weather forecast from the given location and if errors occur,
     * @param location
     * @return curDay 
     */
    public WeatherDay read(String location) {
        WeatherDay curDay = null;
        if(location.equals(""))
        {
            location = "Kaindorf";
        }

        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url1 + location +url2).openStream());
            

            //Parsing of XML children
            Element child = (Element) doc.getElementsByTagName("current_condition").item(0);
            //getting the needed attributes for todays weather
            Element temp = (Element) child.getElementsByTagName("temp_C").item(0);
            Element weatherCode = (Element) child.getElementsByTagName("weatherCode").item(0);
            Element humidity = (Element) child.getElementsByTagName("humidity").item(0);
            Element precipMM = (Element) child.getElementsByTagName("precipMM").item(0);
            Element cloudcover = (Element) child.getElementsByTagName("cloudcover").item(0);
            Element iconLink = (Element) child.getElementsByTagName("weatherIconUrl").item(0);
            curDay = new WeatherDay(location, temp.getTextContent(), weatherCode.getTextContent(), precipMM.getTextContent(), humidity.getTextContent(), cloudcover.getTextContent(), iconLink.getTextContent());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return curDay;
    }
    
   

   

}
