/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Test.NewAppointmentController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author Paul
 */
public class Cal {

    private int this_month=5;
    private int year = 2015;
    private LinkedList<Termin> termine = new LinkedList<>();
    Label lb = new Label();
    private Stage stage;

    /**
     * Initialize
     * @param stage 
     */
    public Cal(Stage stage){
        Calendar now = Calendar.getInstance();
        this_month=now.get(Calendar.MONTH)+1;
        year= now.get(Calendar.YEAR);
        this.stage = stage;
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
                lb.setTextFill(Color.web("#FFFFFF"));
                if (datum.get(l) == 0) {
                    lb.setText("");
                    lb.setId(datum.get(l) + "");
                    lb.setTextFill(Color.web("#0076a3"));//0076a3
                } else {
                    lb.setText(datum.get(l).toString());
                    lb.setId(datum.get(l) + "");
                    String tolltipString = "";
                    for (Termin termins : termine) {
                        
                        if(termins.getDay()==datum.get(l)&&termins.getMonth()==this_month&&termins.getYear()==year)
                        {
                            tolltipString+=termins.toString()+"\n";
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
                gpCal.add(lb, k, j + 1);
                l++;
            }

        }

        return gpCal;
    }

    /**
     *opens a new java FX window to create new appointment
     * @param event
     */
    public void onLableClick(MouseEvent event) {
        String[] tag = event.toString().split("id=");
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Test/NewAppointment.fxml"));
        try {
            root = fxmlLoader.load();
            NewAppointmentController controller = fxmlLoader.getController();

            stage.setScene(new Scene(root));
            stage.show();

            controller.setDay(tag[1].split(",")[0], this_month, year);
            controller.setAppointments();
            controller.setStage(stage);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

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

    /**
     * reads all appointments from the svg file
     * @throws FileNotFoundException
     * @throws IOException 
     */
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
         br.close();
    }

    
    public int getThis_month() {
        return this_month;
    }

}
