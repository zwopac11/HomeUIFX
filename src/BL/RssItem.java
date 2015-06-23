/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Claudio
 */
public class RssItem {
    public  String title;
    public  String link;

    public RssItem(String title, String link) {
        this.title = title;
        this.link = link;
    }

    @Override
    public String toString() {
        return "<p style=\"background-color:#212121;color:#FFFFFF\"><b>" + title + "</b><br> Source: <a href='"+link+"' style='color:#FFFFFF;text-decoration:none' >" + link+"</a><br><br><p>";
        //<a href="url">link text</a>
    }  
}