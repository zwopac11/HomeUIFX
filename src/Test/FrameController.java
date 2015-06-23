/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import BL.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Paul, claudio
 */
public class FrameController implements Initializable {

    Label lb = new Label();
    Button bt = new Button();
    Cal cal;
    WeatherReader weatherReader; 
    WebEngine weatherEngine,newsEngine  ;
    WeatherDay curDay;

    private int this_month;

    @FXML
    private GridPane gpCal;
    @FXML
    private BorderPane bpNews;
    @FXML
    private BorderPane bpWeather;
    @FXML
    private Button last;
    @FXML
    private Button next;
    @FXML
    private Label month;
    @FXML
    private TextField tfWeather;
    @FXML
    private WebView wbWeather;
    @FXML
    private WebView wbNews;
    
    @FXML
    private ComboBox cbNews;
    
    //Definition des Action-Events:

    @FXML
    /**
     * Goes to the month before
     * @param evt
     */
    public void onLast(ActionEvent evt) {
        this_month=cal.getThis_month();
        this_month--;
        
        resetGridPane();
        
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }
    /**
     * Goes to the next Month
     * @param evt 
     */
    public void onNext(ActionEvent evt) {
       this_month=cal.getThis_month();
        this_month++;
        resetGridPane();
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }
    
    
    /**
     * 
     * @param evt 
     */
    public void onLocation(ActionEvent evt) {
       try
       {
       String location = tfWeather.getText();
       curDay = weatherReader.read(location);
       weatherEngine = wbWeather.getEngine();
       weatherEngine.loadContent(curDay.toString());
       }catch(Exception ex)
       {
           weatherEngine = wbWeather.getEngine();
           weatherEngine.loadContent("Sorry, an error occured while requesting your location! ");
       }
    }
    /**
     * 
     * @param evt 
     */
    public void onCbChange(ActionEvent evt)
    {
        try {
            String output = (String) cbNews.getValue();
            
            System.out.println(output);
            
            FeedReader reader = new FeedReader();
            newsEngine = wbNews.getEngine();
            newsEngine.loadContent(reader.getFeed(output));
        } catch (Exception ex) {
            System.out.println(ex.toString());
            
        }
    }
    /**
     * reloads the calendar GridPane using the resetGridPaun()
     */
    private void Reload()
    {
        resetGridPane();
        cal.setThis_month(this_month);
        gpCal = cal.lables(gpCal);
        Month();
    }
    
    /**
     * Resets the calendar GridPane too the original state
     */
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
    
    /**
     * sets the month and the year on the label month, which is the label in the first row of the calendar Gridpane 
     */
    public void Month() {
        int year = cal.getYear();
        switch (this_month) {
            case 1:
                month.setText("Januar "+year);
                break;
            case 2:
                month.setText("Februar "+year);
                break;
            case 3:
                month.setText("März "+year);
                break;
            case 4:
                month.setText("April "+year);
                break;
            case 5:
                month.setText("Mai "+year);
                break;
            case 6:
                month.setText("Juni "+year);
                break;
            case 7:
                month.setText("Juli "+year);
                break;
            case 8:
                month.setText("August "+year);
                break;
            case 9:
                month.setText("September "+year);
                break;
            case 10:
                month.setText("Oktober "+year);
                break;
            case 11:
                month.setText("November "+year);
                break;
            case 12:
                month.setText("Dezember "+year);
                break;
        }
    }

    
    public FrameController() {
        Stage stage = new Stage();
        stage.setOnHiding(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    Reload();   
                }
            });  
        cal  = new Cal(stage);
        
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //gpCal.setStyle("-fx-border-color: red;");
        //gpNews.setStyle("-fx-border-color: blue;");
        
        gpCal = cal.lables(gpCal);
        
        this_month = cal.getThis_month();
        Month();
        
        
        
        
        gpCal.setStyle("-fx-border: 2px solid; -fx-border-color: #EEEEEE;");
        bpNews.setStyle("-fx-border: 2px solid; -fx-border-color: #EEEEEE;");
        bpWeather.setStyle("-fx-border: 2px solid; -fx-border-color: #EEEEEE;");
        //gpCal.setStyle("-fx-background-color: #b2ebf2;");
        cbNews.setStyle("-fx-text-fill: #FFFFFF;");
        
        
        
        //tfWeather.setStyle("-fx-text-fill: #FFFFFF;");
        //tfWeather.setStyle("-fx-control-inner-background: #64DD17");
//        tfWeather.setStyle("-fx-background-color: #64DD17;-fx-background-radius: 4.0; -fx-border-radius: 4.0");
        
        //cbNews.setStyle("-fx-border-color: #9E9E9E;");
        
        cbNews.setStyle("-fx-background-color: #64DD17;");
        
        //String string = "January 2, 2010";
         
        
        weatherReader = new WeatherReader();
        curDay= weatherReader.read("");
        weatherEngine = wbWeather.getEngine();
        weatherEngine.loadContent("<html style=\"background-color:#212121;color:#FFFFFF\">"+curDay.toString()+"</html>");
        cbNews.getItems().addAll("news","sport","discussion","help","science","oe3","fm4");
//        cbNews.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//          @Override
//          public ListCell<String> call(ListView<String> param) {
//            final ListCell<String> cell = new ListCell<String>() {
//              {
//                super.setPrefWidth(100);
//              }
//
//              @Override
//              public void updateItem(String item, boolean empty) {
//                super.updateItem(item, empty);
//                if (item != null) {
//                  setTextFill(Color.RED);
//                  if (item.contains("A")) {
//                    setTextFill(Color.RED);
//                  } else if (item.contains("B")) {
//                    setTextFill(Color.GREEN);
//                  } else {
//                    setTextFill(Color.BLACK);
//                  }
//                } else {
//                  setText(null);
//                }
//              }
//            };
//            return cell;
//          }
//        });
        
        cbNews.setValue("news");
        
        FeedReader fr = new FeedReader();
        System.out.println(fr.toString());
            newsEngine = wbNews.getEngine();
            newsEngine.loadContent("<html style=\"background-color:#212121;color:#FFFFFF\">"+fr.getFeed("news")+"</html>");

    }

}
