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
    public void onLast(ActionEvent evt)
    {
        this_month--;
        cal.setThis_month(this_month);
        gpCal=cal.lables(gpCal);
    }
    public void onNext(ActionEvent evt)
    {
        this_month++;
        cal.setThis_month(this_month);
        gpCal=cal.lables(gpCal);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpCal.setStyle("-fx-border-color: red;");
        gpCal=cal.lables(gpCal);
        this_month = cal.getThis_month();
        switch(this_month)
        {
            case 1:  month.setText("J");break;
            case 2:  month.setText("F");break;
            case 3:  month.setText("M");break;
            case 4:  month.setText("A");break;
        }
        //month.setText(this_month+"");
      //  System.out.println(month.getText());
        //month.setText("hallo");
//        XMLReader xmlr = new XMLReader();
//        xmlr.requestFile();
    }

}
