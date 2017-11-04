/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news.groupf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RIA
 */
public class FirstPageController implements Initializable {

    @FXML
    private void ButtonCSE201(ActionEvent event) throws IOException {
        //System.out.println("You clicked me!");
        Parent goToCSE201 = FXMLLoader.load(getClass().getResource("CSE201.fxml"));
        Scene FirstScene = new Scene(goToCSE201);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
  
    @FXML
    private void ButtonCSE202(ActionEvent event) throws IOException {
        Parent goToCSE202 = FXMLLoader.load(getClass().getResource("CSE202.fxml"));
        Scene FirstScene = new Scene(goToCSE202);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
    @FXML
    private void ButtonCSE203(ActionEvent event) throws IOException {
        Parent goToCSE203 = FXMLLoader.load(getClass().getResource("CSE203.fxml"));
        Scene FirstScene = new Scene(goToCSE203);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
    @FXML
    private void ButtonCSE204(ActionEvent event) throws IOException {
        Parent goToCSE204 = FXMLLoader.load(getClass().getResource("CSE204.fxml"));
        Scene FirstScene = new Scene(goToCSE204);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
    @FXML
    private void ButtonCSE205(ActionEvent event) throws IOException {
        Parent goToCSE205 = FXMLLoader.load(getClass().getResource("CSE205.fxml"));
        Scene FirstScene = new Scene(goToCSE205);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
    @FXML
    private void ButtonCSE206(ActionEvent event) throws IOException {
        Parent goToCSE206 = FXMLLoader.load(getClass().getResource("CSE206.fxml"));
        Scene FirstScene = new Scene(goToCSE206);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
  
    @FXML
    private void ButtonEEE263(ActionEvent event) throws IOException {
        Parent goToEEE263 = FXMLLoader.load(getClass().getResource("EEE263.fxml"));
        Scene FirstScene = new Scene(goToEEE263);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
  
    @FXML
    private void ButtonEEE264(ActionEvent event) throws IOException {
        Parent goToEEE264 = FXMLLoader.load(getClass().getResource("EEE264.fxml"));
        Scene FirstScene = new Scene(goToEEE264);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }

    @FXML
    private void ButtonMATH241(ActionEvent event) throws IOException {
        Parent goToMATH241 = FXMLLoader.load(getClass().getResource("MATH241.fxml"));
        Scene FirstScene = new Scene(goToMATH241);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
