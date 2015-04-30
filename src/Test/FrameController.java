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
import javafx.scene.Node;
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
        
        resetGridPane();
        
        //gpCal.getChildren().removeAll();
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
        
        resetGridPane();
        
        //gpCal.getChildren().clear();
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }

    public void resetGridPane()
    {
                Node node1 = gpCal.getChildren().get(0);
                Node node2 = gpCal.getChildren().get(1);
                Node node3 = gpCal.getChildren().get(2);
                Node node4 = gpCal.getChildren().get(3);
                Node node5 = gpCal.getChildren().get(4);
                Node node6 = gpCal.getChildren().get(5);
                Node node7 = gpCal.getChildren().get(6);
                Node node8 = gpCal.getChildren().get(7);
                Node node9 = gpCal.getChildren().get(8);
                Node node10 = gpCal.getChildren().get(9);
                gpCal.getChildren().clear();
                gpCal.getChildren().add(0,node1);
                gpCal.getChildren().add(1,node2);
                gpCal.getChildren().add(2,node3);
                gpCal.getChildren().add(3,node4);
                gpCal.getChildren().add(4,node5);
                gpCal.getChildren().add(5,node6);
                gpCal.getChildren().add(6,node7);
                gpCal.getChildren().add(7,node8);
                gpCal.getChildren().add(8,node9);
                gpCal.getChildren().add(9,node10);
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
