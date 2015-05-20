/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

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

    @Override
    public String toString() {
        return "Termin{" + "day=" + day + "\n, year=" + year + ", month=" + month + ", name=" + name + ", von=" + von + ", bis=" + bis + '}';
    }
    
    
    
    
}
