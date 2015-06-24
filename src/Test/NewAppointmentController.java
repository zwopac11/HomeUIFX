/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import BL.Termin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.ColumnConstraints;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class NewAppointmentController implements Initializable {

    private int month, year, day;
    private Stage stage;

    final Spinner spStundenVon = new Spinner();

    final Spinner spMinVon = new Spinner();

    final Spinner spStundenBis = new Spinner();

    final Spinner spMinBis = new Spinner();

    private LinkedList<Termin> termine = new LinkedList<>();

    @FXML
    private TextField tfName;
//    @FXML
//    private TextField tfVon;
//    @FXML
//    private TextField tfBis;
    @FXML
    private Label lbTitle;
    @FXML
    private GridPane gpVon_Bis;
    @FXML
    private GridPane gpMain;
    
    @FXML
    private ScrollPane spTest;

    @FXML
    /**
     * Saves the data and makes sure that the time is a date
     *
     * @param evt
     */
    public void onOkay(ActionEvent evt) {

        FileOutputStream fos = null;
        try {
            //tfName.getText();
            DateFormat format = new SimpleDateFormat("kk:mm", Locale.ENGLISH);
            Date date = format.parse(spStundenVon.getValue() + ":" + spMinVon.getValue());//tfVon.getText()

            Date date2 = format.parse(spStundenBis.getValue() + ":" + spMinBis.getValue());//tfBis.getText()
            //System.out.println(date+" "+date2);

            Termin termin = new Termin(day, month, year, tfName.getText(), format.format(date), format.format(date2));
            termine.add(termin);
            writeFileNew();
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

    /**
     * Sets the day of the appointment you want to create
     *
     * @param day
     * @param month
     * @param year
     */
    public void setDay(String day, int month, int year) {
        this.day = Integer.parseInt(day);
        this.year = year;
        this.month = month;
        lbTitle.setText("Date: " + day + "." + month + "." + year);
    }
    
    
    /**
     * Show all the Appointments
     */
    public void setAppointments() {
        GridPane gpTest = new GridPane();
        gpTest.setStyle("-fx-background-color: #212121;");
        try {
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(NewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        for (final Termin termin_now : termine) {

            if (termin_now.getDay() == day && termin_now.getMonth() == month && termin_now.getYear() == year) {
                final TextField text = new TextField();

                text.setStyle("-fx-background-color:  #64DD17;");
                text.setText(termin_now.getName());
                text.setMinWidth(260);

                gpTest.add(text, 0, i);
                
                GridPane gp = new GridPane();
                gp.setVgap(2);

                final TextField von = new TextField();

                von.setText(termin_now.getVon());
                von.setMaxWidth(115);
                gp.add(von, 0, 0);
                final TextField bis = new TextField();

                bis.setText(termin_now.getBis());
                bis.setMaxWidth(115);
                gp.add(bis, 1, 0);

                gpTest.add(gp, 1, i);             
                
                GridPane gp2 = new GridPane();
                ColumnConstraints cc1 = new ColumnConstraints(10, 100, Double.MAX_VALUE);
                 List<ColumnConstraints> cc = gp2.getColumnConstraints();
                 cc.add(cc1);
                 cc.add(cc1);
                
                Button delete = new Button();
                
                delete.setStyle("-fx-background-color: #0097a8;-fx-text-fill: #FFFFFF;");
                delete.setText("Delete");
                
                delete.setMaxWidth(Double.MAX_VALUE);
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        termine.remove(termin_now);
                        System.out.println(termin_now);
                        try {
                            writeFileNew();
                        } catch (FileNotFoundException ex) {
                            System.out.println(ex.toString());
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "Not a time!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                gp2.add(delete, 0, 0);
                
                Button edit = new Button();
                edit.setMaxWidth(Double.MAX_VALUE);
                edit.setText("Edit");
                edit.setStyle("-fx-background-color: #0097a8;-fx-text-fill: #FFFFFF;");
                gp2.add(edit, 1, 0);
                edit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        termine.remove(termin_now);
                        Termin termin = new Termin(day, month, year, text.getText(), von.getText(), bis.getText());
                        termine.add(termin);
                        try {
                            writeFileNew();
                        } catch (FileNotFoundException ex) {
                            System.out.println(ex.toString());
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "Not a time!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                gpTest.add(gp2, 2, i);
                spTest.setContent(gpTest);
                
                i++;
            }
        }
    }
    
    /**
     * Saves the data
     * @throws ParseException
     * @throws IOException 
     */
    public void writeFileNew() throws ParseException, IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "data" + File.separator + "termine.svg");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();

        FileOutputStream fos = null;

        DateFormat format = new SimpleDateFormat("kk:mm", Locale.ENGLISH);
        FileWriter fw = new FileWriter(file, true);
        for (Termin termine1 : termine) {

            
            fw.write(termine1.getDay() + ";" + termine1.getMonth() + ";" + termine1.getYear() + ";" + termine1.getName() + ";" + termine1.getVon() + ";" + termine1.getBis() + ";" + termine1.getId() + "\n");//tfVon.getText()+";"+tfBis.getText()
            
        }
        fw.close();
        //Fehler wenn man selber ein Zahl eingibt
        Stage stage = (Stage) lbTitle.getScene().getWindow();
        stage.close();

    }

    /**
     * reads all appointments from the svg file
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readFile() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "data" + File.separator + "termine.svg");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";

        while ((zeile = br.readLine()) != null) {
            String[] str = zeile.split(";");
            Termin termin = new Termin(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], str[4], str[5],str[6]);
            termine.add(termin);
        }
        br.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gpVon_Bis.getChildren().clear();

        spStundenVon.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24));
        spStundenVon.setEditable(true);
        spMinVon.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
        spMinVon.setEditable(true);

        spStundenBis.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24));
        spStundenBis.setEditable(true);
        spMinBis.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
        spMinBis.setEditable(true);

        spStundenVon.setStyle("-fx-background-color: #0097a8;");
        spStundenBis.setStyle("-fx-background-color: #0097a8;");
        spMinVon.setStyle("-fx-background-color: #0097a8;");
        spMinBis.setStyle("-fx-background-color: #0097a8;");

        spStundenVon.setMaxHeight(Double.MAX_VALUE);
        spStundenBis.setMaxHeight(Double.MAX_VALUE);
        spMinBis.setMaxHeight(Double.MAX_VALUE);
        spMinVon.setMaxHeight(Double.MAX_VALUE);

        GridPane gp = new GridPane();
        gp.setVgap(2);

        gp.add(spStundenVon, 0, 1);
        gp.add(spMinVon, 1, 1);
        gpVon_Bis.add(gp, 0, 0);

        GridPane gp2 = new GridPane();
        gp2.setVgap(2);

        gp2.add(spStundenBis, 0, 1);
        gp2.add(spMinBis, 1, 1);
        gpVon_Bis.add(gp2, 1, 0);

    }

    /**
     * Closes the window
     *
     * @param evt
     */
    public void onCancel(ActionEvent evt) {
        Stage stage = (Stage) lbTitle.getScene().getWindow();
        stage.close();
    }
}
