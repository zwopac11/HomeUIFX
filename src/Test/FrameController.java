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

import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import BL.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FrameController implements Initializable {

    Label lb = new Label();
    Button bt = new Button();
    Cal cal = new Cal();

    private int this_month;

    @FXML
    private GridPane gpCal;
    @FXML
    private Button last;
    @FXML
    private Button next;
    @FXML
    private Label month;

    //Definition des Action-Events:

    @FXML
    public void onLast(ActionEvent evt) {
        this_month--;
        gpCal.getChildren().removeAll();
        //gpCal.getChildren().remove(3,3);
//        gpCal.getRowConstraints().remove(4);
////        gpCal.getChildren().remove(3);
//        RowConstraints row = new RowConstraints();
//        //gpCal.getRowConstraints().add(row);
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }

    public void onNext(ActionEvent evt) {
        this_month++;
        //gpCal.getChildren().clear();
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }

    public void Month() {
        switch (this_month) {
            case 1:
                month.setText("Januar");
                break;
            case 2:
                month.setText("Februar");
                break;
            case 3:
                month.setText("März");
                break;
            case 4:
                month.setText("April");
                break;
            case 5:
                month.setText("Mai");
                break;
            case 6:
                month.setText("Juni");
                break;
            case 7:
                month.setText("Juli");
                break;
            case 8:
                month.setText("August");
                break;
            case 9:
                month.setText("September");
                break;
            case 10:
                month.setText("Oktober");
                break;
            case 11:
                month.setText("November");
                break;
            case 12:
                month.setText("Dezember");
                break;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpCal.setStyle("-fx-border-color: red;");
        gpCal = cal.lables(gpCal);
        
        this_month = cal.getThis_month();
        Month();
        //month.setText(this_month+"");
        //  System.out.println(month.getText());
        //month.setText("hallo");
//        XMLReader xmlr = new XMLReader();
//        xmlr.requestFile();
    }

}
