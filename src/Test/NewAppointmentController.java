/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class NewAppointmentController implements Initializable {

    private int month, year, day;
    private Stage stage;
    
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfVon;
    @FXML
    private TextField tfBis;
    @FXML
    private Label lbTitle;
    
     @FXML
    /**
     * Saves the data and makes sure that the time is a date
     * @param evt
     */
    public void onOkay(ActionEvent evt)  {
        
        
        FileOutputStream fos=null;
        try {
            //tfName.getText();
            DateFormat format = new SimpleDateFormat("kk:mm", Locale.ENGLISH);
            Date date = format.parse(tfVon.getText());
            Date date2 = format.parse(tfBis.getText());
            //System.out.println(date+" "+date2);
            
            File file=new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"data"+File.separator+"termine.svg");
            FileWriter fw = new FileWriter(file,true);
            fw.write(day+";"+month+";"+year+";"+tfName.getText()+";"+tfVon.getText()+";"+tfBis.getText()+"\n");
            fw.close();
            
            Stage stage = (Stage) lbTitle.getScene().getWindow();
            stage.close();    
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Not a time!", "Error", JOptionPane.ERROR_MESSAGE);
        }

       
    }
    
     /**
     * Closes the window
     * @param evt
     */
    public void onCancel(ActionEvent evt) {
        Stage stage = (Stage) lbTitle.getScene().getWindow();
        stage.close();
        //stage.close();
    }
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    public void setDay(String day,int month,int year)
    {
        this.day=Integer.parseInt(day);
        this.year = year;
        this.month = month;
        lbTitle.setText(day+"."+month+"."+year);
    }
    
    public void setStage(Stage stage)
    {
        this.stage=stage;
    }
}
