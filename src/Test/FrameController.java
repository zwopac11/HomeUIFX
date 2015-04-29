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
import BL.*;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FrameController implements Initializable {

    Label lb = new Label();
    Button bt = new Button();
    Cal cal = new Cal();

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

   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpCal.setStyle("-fx-border-color: red;");
        gpCal=cal.lables(gpCal);
//        XMLReader xmlr = new XMLReader();
//        xmlr.requestFile();
    }

}
