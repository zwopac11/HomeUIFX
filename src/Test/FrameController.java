/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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
        LinkedList <Integer> datum = new LinkedList<>();
        for (int i = 0; i < 42; i++) {
            datum.add(0);
        }
        Calendar now = Calendar.getInstance();
        int month= now.get(Calendar.MONTH);
        int max_day_this_month = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        int first_day_this_month = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println("Month: "+month+"last day: "+max_day_this_month+"???: "+first_day_this_month);
        
        for (int i = 0; i < max_day_this_month; i++) {
            datum.set(i+first_day_this_month, i);
        }
        for (Integer datum1 : datum) {
            System.out.println(datum+" ");
        }
        
        now.add(Calendar.MONTH, -1);
        int max_day_last_month = now.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("max_day_last_month:"+max_day_last_month);
        int i = max_day_last_month-first_day_this_month;
        for (int j = 0; j < datum.size(); j++) {
            if(datum.get(j)==0)
            {
                datum.set(j, i);
                if(i>=max_day_last_month)
                {
                    i=0;
                }
                i++;
            }
            
        }
               
        
        for (Integer datum1 : datum) {
            System.out.println(datum+" ");
        }
        
        
        
        
        
        
        for (int k = 0; k < 7; k++) {
            for (int j = 0; j < 6; j++) {
                lb = new Label();
                lb.setText(k+"_"+j);
                lb.setId(k+"_"+j);
                lb.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        onLableClick(event);
                    }

                });

                gpCal.setHalignment(lb, HPos.CENTER);
                gpCal.add(lb, k, j+1);

            }

        }
    }

    
    
    public void onLableClick(MouseEvent event)
    {
        System.out.println("hallo "+event);
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
