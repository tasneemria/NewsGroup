/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news.groupf;

import Server.ConnectionUtilities;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author RIA
 */
public class FXMLDocumentController implements Initializable {
    
    private String name;
    private String pass;
    private ConnectionUtilities connection;    
    
    @FXML
    private Label label;
    @FXML
    private TextField userName;
    @FXML
    private TextField error;
    @FXML
    private PasswordField password;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        name = userName.getText();
        pass = password.getText();
        connection = new ConnectionUtilities("localhost",22222);
        String sendToServer = "login:"+name+":"+pass;
        connection.write(sendToServer);
        String FromServer = connection.read().toString();

        
        if(FromServer.equals("true")){
            Parent goToFirstPage = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
            Scene FirstScene = new Scene(goToFirstPage);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(FirstScene);
            stg.show();
        }
        else{
            error.setText("Login Failed");
            userName.clear();
            password.clear();
            
        }


    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
