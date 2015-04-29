/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 *
 * @author Claudio
 */
public class XMLReader {
    
        //http://xoap.weather.com/weather/local/30915
        //File request = new File("http://xoap.weather.com/weather/local/30915");
        //File fXmlFile = new File(System.getProperty("user.dir")+"\\"+"src\\"+"xml_file.xml");
	
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        String str = "http://apidev.accuweather.com/locations/v1/cities/autocomplete?apikey=30915";
        
        
        public void requestFile()
        {
            try {
            URL url = new URL(str);
            InputStream is = url.openStream();
            int ptr = 0;
            StringBuilder builder = new StringBuilder();
            while ((ptr = is.read()) != -1) {
                builder.append((char) ptr);
            }
            
            String xml = builder.toString();
            
                System.out.println(xml.toString());
            
        } catch (Exception ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
