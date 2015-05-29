/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Test.FrameController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul
 */
public class Termin {
    
    private int day,year,month;
    private String name,von,bis;

    public Termin(int day, int month, int year, String name, String von, String bis) {
        this.day = day;
        this.year = year;
        this.month = month;
        this.name = name;
        this.von = von;
        this.bis = bis;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getBis() {
        return bis;
    }

    public void setBis(String bis) {
        this.bis = bis;
    }

    /**
     * checks if the time is a date
     * @return text of appointments 
     */
    @Override
    public String toString() {
//        Date date = new SimpleDateFormat("HH:mm").parse(von+"");
//        String newString = new SimpleDateFormat("H:mm").format(date);
        
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
        DateFormat format = new SimpleDateFormat("kk:mm", Locale.ENGLISH);
        Date date,date2;
        Date start_date,end_date;
        try {
            date = format.parse(von);
            start_date=date;
            date2 = format.parse(bis);
            end_date=date2;
            //System.out.println(date); 
            return  name + "\n" + sdf.format(start_date) + " - " + sdf.format(end_date) + ' ';
        } catch (ParseException ex) {
            Logger.getLogger(FrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return  name + "\n" + von + " - " + bis + ' ';
    }
    
    
    
    
}
