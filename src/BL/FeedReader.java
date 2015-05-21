///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package BL;
//
//import java.net.URL;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
///**
// *
// * @author Claudio
// */
//public class FeedReader {
//
//    
//    
//    private RssFeed _build(Document document) //http://stackoverflow.com/questions/16848244/java-jdom-xml-parsing
//    {
//       String str = "http://www.someurl.info/sitemap.xml";
//       URL url = new URL(str);
//       InputStream is = url.openStream();
//       int ptr = 0;
//       StringBuilder builder = new StringBuilder();
//       while ((ptr = is.read()) != -1) {
//           builder.append((char) ptr);
//       }
//       String xml = builder.toString();
//
//       org.jdom2.input.SAXBuilder saxBuilder = new SAXBuilder();
//       try {
//           org.jdom2.Document doc = saxBuilder.build(new StringReader(xml));
//           System.out.println(xml);
//           Element xmlfile = doc.getRootElement();
//           System.out.println("ROOT -->"+xmlfile);
//           List list = xmlfile.getChildren("url");
//           System.out.println("LIST -->"+list);
//       } catch (JDOMException e) {
//            handle JDOMExceptio n
//       } catch (IOException e) {
//            handle IOException
//       }
//
//       System.out.println("===========================");
//    }
//}
//
//http://www.tutorialspoint.com/java_xml/java_jdom_parse_document.htm