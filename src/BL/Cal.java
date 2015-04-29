/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Paul
 */
public class Cal {
    
    private int this_month=4;
    Label lb = new Label();
    
     public GridPane lables(GridPane gpCal) {

        int[][] multi = new int[7][6];
        LinkedList<Integer> datum = new LinkedList<>();
        for (int i = 0; i < 42; i++) {
            datum.add(0);
        }
        int year = 2015;
        int month = this_month;
//        Calendar now = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("d");

        //LocalDate ld = LocalDate.
        LocalDate ld = LocalDate.of(year, month, 1);

        int last_day_of_this_month = LocalDate.of(year, month, 1).lengthOfMonth();

        int first_day_of_last_month = Integer.parseInt(ld.with(DayOfWeek.MONDAY).toString().split("-")[2]);

        int last_day_of_last_month = LocalDate.of(year, month - 1, 1).lengthOfMonth();

        System.out.println("last_day_of_this_month: " + last_day_of_this_month + " last_day_of_last_month: " + last_day_of_last_month);
        System.out.println("-----------------");

        int help = last_day_of_this_month +1+ last_day_of_last_month - first_day_of_last_month;
        int help2 = first_day_of_last_month;
        int help3 = 1;
        for (int i = 0; i < help; i++) {
            if (i <= last_day_of_last_month - first_day_of_last_month) {
                datum.set(i, help2);
                help2++;
            } else {
                
                datum.set(i, help3);
                help3++;
            }

        }
        int m=1;
        for (int j = 0; j < datum.size(); j++) {
            if (datum.get(j) == 0) {
                datum.set(j, m);
                m++;
            }

        }
        
//        for (Integer datum1 : datum) {
//            System.out.println(datum + " ");
//        }

        
        
        //System.out.println(now.getTime());
//        int month_alt = now.get(Calendar.MONTH);
//        int max_day_this_month = now.getActualMaximum(Calendar.DAY_OF_MONTH);
//        int first_day_this_month = now.get(Calendar.DAY_OF_WEEK);
//        System.out.println("Month: " + sdf.format(month_alt) + " last day: " + max_day_this_month + " ???: " + first_day_this_month);
//
//        for (int i = 0; i < max_day_this_month; i++) {
//            datum.set(i + first_day_this_month - 1, i + 1);
//        }
////        for (Integer datum1 : datum) {
////            System.out.println(datum+" ");
////        }
//
//        now.add(Calendar.MONTH, -1);
//        int max_day_last_month = now.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("max_day_last_month:" + max_day_last_month);
//        System.out.println("first_day_this_month-1: " + (first_day_this_month - 1));
//        int i = max_day_last_month - ((first_day_this_month - 1) - 1);
//        System.out.println("i:" + i);
//        for (int j = 0; j < datum.size(); j++) {
//            if (datum.get(j) == 0) {
//                datum.set(j, i);
//                if (i >= (max_day_last_month)) {
//                    i = 0;
//                }
//                i++;
//            }
//
//        }

//        
//        for (Integer datum1 : datum) {
//            System.out.println(datum+" ");
//        }
        int l = 0;
        for (int j = 1; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                lb = new Label();
                lb.setText(datum.get(l).toString());
                lb.setId(k + "_" + j);
                lb.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        onLableClick(event);
                    }

                });

                gpCal.setHalignment(lb, HPos.CENTER);
                gpCal.add(lb, k, j + 1);
                l++;
            }

        }

        return gpCal;
    }
     
     
     
    public void onLableClick(MouseEvent event) {
        System.out.println("hallo " + event);
    }

    public int getThis_month() {
        return this_month;
    }

    public void setThis_month(int this_month) {
        this.this_month = this_month;
    }
    
    
    
    
}
