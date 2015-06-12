/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.FlowLayout;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class NewAppointmentController implements Initializable {

    private int month, year, day;
    private Stage stage;

//    final SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
//		Spinner spinner = new Spinner(spinnerDateModel);
//                
//    final SpinnerDateModel spinnerDateModel1 = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
//		Spinner spinner1 = new Spinner(spinnerDateModel1);
    
    
       final Spinner spStundenVon = new Spinner();
       
       final Spinner spMinVon = new Spinner();
       
       final Spinner spStundenBis = new Spinner();
       
       final Spinner spMinBis = new Spinner();
       
    
    
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfVon;
    @FXML
    private TextField tfBis;
    @FXML
    private Label lbTitle;
    @FXML
    private GridPane gpVon_Bis;
    
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
            Date date = format.parse(spStundenVon.getValue()+":"+spMinVon.getValue());//tfVon.getText()
            
            Date date2 = format.parse(spStundenBis.getValue()+":"+spMinBis.getValue());//tfBis.getText()
            //System.out.println(date+" "+date2);
            
            File file=new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"data"+File.separator+"termine.svg");
            FileWriter fw = new FileWriter(file,true);
            fw.write(day+";"+month+";"+year+";"+tfName.getText()+";"+format.format(date)+";"+format.format(date2)+"\n");//tfVon.getText()+";"+tfBis.getText()
            fw.close();
            
            //Fehler wenn man selber ein Zahl eingibt
            
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

//    public NewAppointmentController() {
////         Slider slider = new Slider(0, 1, 0.5);
////       gpVon_Bis.getChildren().clear();
//       
//       final Spinner spinner = new Spinner();
//       spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000));
//       spinner.setEditable(true);
//       
//      
//       gpVon_Bis.add(new Label("Spinner:"), 0, 1);
//       gpVon_Bis.add(spinner, 0, 0);
//       
////       gpVon_Bis.getChildren().add(slider);
//        
//    }
    
    
    
    
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
        
        
        //         Slider slider = new Slider(0, 1, 0.5);
       gpVon_Bis.getChildren().clear();
       
       spStundenVon.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24));
       spStundenVon.setEditable(true);
       spMinVon.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
       spMinVon.setEditable(true);
       spStundenBis.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24));
       spStundenBis.setEditable(true);
       spMinBis.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
       spMinBis.setEditable(true);
       
       //System.out.println("spinner.getValue(); "+spStundenVon.getValue());
      
       
       
       //gpVon_Bis.add(new Label(""), 0, 1);
       GridPane gp = new GridPane();
       gp.setVgap(2);
       
       gp.add(spStundenVon, 0, 1);
       gp.add(spMinVon, 1, 1);
       gpVon_Bis.add(gp, 0, 0);
       
       
             
       
       //gpVon_Bis.add(new Label(""), 0, 1);
       GridPane gp2 = new GridPane();
       gp2.setVgap(2);
       
       gp2.add(spStundenBis, 0, 1);
       gp2.add(spMinBis, 1, 1);
       gpVon_Bis.add(gp2, 1, 0);
       
       
       
       
//       gpVon_Bis.getChildren().add(slider);
        
    }  
    public void setDay(String day,int month,int year)
    {
        this.day=Integer.parseInt(day);
        this.year = year;
        this.month = month;
        lbTitle.setText("Date: "+day+"."+month+"."+year);
    }
    
    public void setStage(Stage stage)
    {
        this.stage=stage;
    }
}
