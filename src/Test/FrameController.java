/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FrameController implements Initializable {

    Label lb = new Label();
    Button bt = new Button();

    @FXML
    private GridPane gpCal;
    //Definition des Action-Events:
//    @FXML
//    public void onMo(MouseEvent evt)
//    {
//        System.out.println("hallo");
//    }
//    public void onAction(MouseEvent evt)
//    {
//        System.out.println("Hallo");
//        System.out.println(tfName.getText());
//    }

    public void lables() {

        int[][] multi = new int[7][6];
        LinkedList<Integer> datum = new LinkedList<>();
        LinkedList<Integer> datum2 = new LinkedList<>();
        for (int i = 0; i < 42; i++) {
            datum.add(0);
        }
        int year = 2015;
        int month = 4;
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

    }

    public void onLableClick(MouseEvent event) {
        System.out.println("hallo " + event);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpCal.setStyle("-fx-border-color: red;");

        lables();

    }

}
