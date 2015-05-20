/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Test.NewAppointmentController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TooltipBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 *
 * @author Paul
 */
public class Cal {

    private int this_month=5;
    private int year = 2015;
    private LinkedList<Termin> termine = new LinkedList<>();
    Label lb = new Label();

    public Cal() {
        Calendar now = Calendar.getInstance();
        this_month=now.get(Calendar.MONTH)+1;
        year= now.get(Calendar.YEAR);
    }

    /**
     * Sets on the GridPane all the Labels with alle the dayes of the month
     *
     * @param gpCal
     * @return gpCal
     */
    public GridPane lables(GridPane gpCal) {

        int[][] multi = new int[7][6];
        LinkedList<Integer> datum = new LinkedList<>();
        for (int i = 0; i < 42; i++) {
            datum.add(0);
        }
         //System.out.println("this_month: "+this_month);
//        int month = this_month;
//        Calendar now = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("d");

        //LocalDate ld = LocalDate.
        LocalDate ld = LocalDate.of(year, this_month, 1);

        int last_day_of_this_month = LocalDate.of(year, this_month, 1).lengthOfMonth();

        int first_day_of_last_month = Integer.parseInt(ld.with(DayOfWeek.MONDAY).toString().split("-")[2]);

        String adfas = LocalDate.of(year, this_month, 1).getDayOfWeek().toString();
        int first_day = 0;
        switch (adfas) {
            case "SATURDAY":
                first_day = 5;
                break;
            case "SUNDAY":
                first_day = 6;
                break;
            case "MONDAY":
                first_day = 0;
                break;
            case "TUESDAY":
                first_day = 1;
                break;
            case "WEDNESDAY":
                first_day = 2;
                break;
            case "THURSDAY":
                first_day = 3;
                break;
            case "FRIDAY":
                first_day = 4;
                break;
        }
        int hallo = 1;
        for (int i = first_day; i < first_day + last_day_of_this_month; i++) {
            datum.add(i, hallo);
            hallo++;

        }
//        System.out.println(datum);
//        System.out.println(adfas);
//         //System.out.println("year: "+year);
//        int last_month = this_month - 1;
//        int last_year = year;
//        if (this_month == 1) {
//            last_month = 12;
//            last_year = year - 1;
//        }
//        int last_day_of_last_month = LocalDate.of(last_year, last_month, 1).lengthOfMonth();
//
//        if (first_day_of_last_month == 1) {
//            first_day_of_last_month = last_day_of_last_month;
//        }
//        
//
////        System.out.println("last_day_of_this_month: " + last_day_of_this_month + " last_day_of_last_month: " + last_day_of_last_month);
////        System.out.println("-----------------");
//        int help = last_day_of_this_month + 1 + last_day_of_last_month - first_day_of_last_month;
//        int help2 = first_day_of_last_month;
//        int help3 = 1;
//        int help4 = first_day_of_last_month;
//        for (int i = 0; i < help; i++) {
//            System.out.println("last_day_of_last_month: "+last_day_of_last_month+" first_day_of_last_month: "+first_day_of_last_month);
//            
//            if (last_day_of_last_month != help4) {
//                System.out.println("hallo");
//                if (i <= last_day_of_last_month - first_day_of_last_month) {
//                    datum.set(i, help2+100);
//                    help2++;
//                    System.out.println(datum);
//                }
//                help4++;
//                
//            } else {
////                System.out.println("size: "+datum.size()+"i: "+i);
//                System.out.println(datum);
//                datum.set(i, help3);
//                help3++;
//            }
//
//        }
//        help3 = 0;
//        int m = 1;
//        for (int j = 0; j < datum.size(); j++) {
//            if (datum.get(j) == 0) {
//
//                datum.set(j, m+100);
//                m++;
//            }
//
//        }
////        System.out.println(datum);
////        for (Integer datum1 : datum) {
////            System.out.println(datum + " ");
////        }
//
//        //System.out.println(now.getTime());
////        int month_alt = now.get(Calendar.MONTH);
////        int max_day_this_month = now.getActualMaximum(Calendar.DAY_OF_MONTH);
////        int first_day_this_month = now.get(Calendar.DAY_OF_WEEK);
////        System.out.println("Month: " + sdf.format(month_alt) + " last day: " + max_day_this_month + " ???: " + first_day_this_month);
////
////        for (int i = 0; i < max_day_this_month; i++) {
////            datum.set(i + first_day_this_month - 1, i + 1);
////        }
//////        for (Integer datum1 : datum) {
//////            System.out.println(datum+" ");
//////        }
////
////        now.add(Calendar.MONTH, -1);
////        int max_day_last_month = now.getActualMaximum(Calendar.DAY_OF_MONTH);
////        System.out.println("max_day_last_month:" + max_day_last_month);
////        System.out.println("first_day_this_month-1: " + (first_day_this_month - 1));
////        int i = max_day_last_month - ((first_day_this_month - 1) - 1);
////        System.out.println("i:" + i);
////        for (int j = 0; j < datum.size(); j++) {
////            if (datum.get(j) == 0) {
////                datum.set(j, i);
////                if (i >= (max_day_last_month)) {
////                    i = 0;
////                }
////                i++;
////            }
////
////        }
////        
////        for (Integer datum1 : datum) {
////            System.out.println(datum+" ");
////        }
        termine.clear();

        try {
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(Cal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        int l = 0;
        for (int j = 1; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                lb = new Label();
                if (datum.get(l) == 0) {
                    //int dat = datum.get(l)-100;
                    lb.setText("");
                    lb.setId(datum.get(l) + "");
                    lb.setTextFill(Color.web("#0076a3"));
                  //lb.setStyle("-fx-background-color: white;");
                    //lb.setStyle("-fx-background-color: white; -fx-padding: 10px;");
                } else {
                    lb.setText(datum.get(l).toString());
                    lb.setId(datum.get(l) + "");
                    String tolltipString = "";
                    for (Termin termins : termine) {
                        
                        if(termins.getDay()==datum.get(l)&&termins.getMonth()==this_month&&termins.getYear()==year)
                        {
                            tolltipString+=termins.toString()+"\n";
//////                            Tooltip tp = new Tooltip(termins.toString());
                            
                            
//                            Tooltip.TooltipBehavior BEHAVIOR = new Tooltip.TooltipBehavior(new Duration(1000), new Duration(5000), new Duration(200), false);
                            
                            //Tooltip.install(lb, tp);
                            
                            
//////////                            lb.setTooltip(tp);
//////////                            lb.setTextFill(Color.web("#0076a3"));
//////////                            
//////////                            tp.setAutoHide(true);
//                            Tooltip tooltip = new Tooltip();
//                            tooltip.setText("hallo");
//                            lb.setTooltip(tooltip);
                            
                            //lb.setTooltip(new Tooltip("Tooltip for Button"));
//                            lb.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//                            
//                                @Override
//                                public void handle(MouseEvent event) {
//                                    System.out.println("adfs");
//                                    //lb.setTooltip(new Tooltip("Tooltip for Button"));
//                                    
//                                }
//                                
//                            });
                            //http://www.java2s.com/Code/Java/JavaFX/MouseinandouteventforButton.htm
                            //https://www.google.at/webhp?sourceid=chrome-instant&rlz=1C1GKLA_enAT598AT598&ion=1&espv=2&ie=UTF-8#q=javafx+mouse+over+event
                        }
                    }
                    if(!tolltipString.equals(""))
                    {
                     Tooltip tp = new Tooltip(tolltipString);
                     lb.setTooltip(tp);
                     lb.setTextFill(Color.web("#0076a3"));
                     tp.setAutoHide(true);   
                    }
                    
                    
                    lb.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            onLableClick(event);
                        }

                    });
                }
                gpCal.setHalignment(lb, HPos.CENTER);
                //gpCal.setConstraints(lb, k, j + 1);
                gpCal.add(lb, k, j + 1);
                l++;
            }

        }

        return gpCal;
    }

    /**
     *
     * @param event
     */
    public void onLableClick(MouseEvent event) {
        System.out.println(event.toString());
        String[] tag = event.toString().split("id=");
        System.out.println(tag[1].split(",")[0]);
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Test/NewAppointment.fxml"));
        try {
            root = fxmlLoader.load();
            NewAppointmentController controller = fxmlLoader.getController();

            System.out.println("controller: " + controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println(fxmlLoader);
            System.out.println(tag[1].split(",")[0] + " " + this_month + " " + year);

            controller.setDay(tag[1].split(",")[0], this_month, year);
            controller.setStage(stage);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public int getThis_month() {
        return this_month;
    }

    /**
     * Is the set methode to get the month, but also makes sure, that the month
     * is only between 1 and 12, if not it edits the year
     *
     * @param this_month
     */
    public void setThis_month(int this_month) {
        if (this_month == 0) {
            year--;
            this_month = 12;
        }
        if (this_month == 13) {
            year++;
            this_month = 1;
        }
        this.this_month = this_month;
    }

    public int getYear() {
        return year;
    }

    public void readFile() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "data" + File.separator + "termine.svg");
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";
        
        while( (zeile = br.readLine()) != null )
        {
             String [] str = zeile.split(";");
             Termin termin = new Termin(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5]);
             termine.add(termin);
        }
        for (Termin termins : termine) {
            System.out.println(termins.toString());
        }
         br.close();
    }

}
