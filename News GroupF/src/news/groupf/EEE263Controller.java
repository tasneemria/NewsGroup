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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RIA
 */
public class EEE263Controller implements Initializable {
        
    @FXML
    private TextArea WritePost;
    @FXML
    private TextArea[] ShowPost = new TextArea[100];
    @FXML
    private VBox pane_main_grid = new VBox(); 
    
    @FXML
    private Button[] comment = new Button[100] ;
    
    private String post;
    private String filename = "";
    private String readFromServer;
    private int NoOfPost = 0;
    private String commentLine;
    private String sendToServer;
    
    private ConnectionUtilities con;

    
    @FXML
    private void postButtonAction(ActionEvent event) throws IOException{
        pane_main_grid.setSpacing (10);
        post = WritePost.getText();
        sendToServer = "EEE263: "+ post +" This is posted by:";
        //System.out.println(sendToServer);
        con = new ConnectionUtilities("localhost",22222);
        con.write(sendToServer);
        readFromServer = con.read().toString();
        WritePost.clear();
        //String[] postnumber = readFromServer.split("#");
        //NoOfPost = Integer.parseInt(postnumber[1]);
        ShowPost[NoOfPost] = new TextArea();
        comment[NoOfPost] = new Button();
        
        pane_main_grid.getChildren().add(ShowPost[NoOfPost]);
        pane_main_grid.getChildren().add(comment[NoOfPost]);
        
        ShowPost[NoOfPost].setText(readFromServer);
        comment[NoOfPost].setText("comment");
        //System.out.println(readFromServer);
        ShowPost[NoOfPost].setEditable(false);
        CommentUpdating(NoOfPost);
        //ShowAllPosts();
        //CommentUpdating(NoOfPost);

        NoOfPost++;
    }
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Parent goToFirstPage = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        Scene FirstScene = new Scene(goToFirstPage);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(FirstScene);
        stg.show();
    }      
    
    void CommentUpdating(int number){
        comment[number].setOnAction((event) -> {
            // Button was clicked, do something...
            //System.out.println("comment button is working");
            commentLine = WritePost.getText();
            con = new ConnectionUtilities("localhost",22222);
            con.write("EEE263comment:"+number+":"+commentLine+" This is replied by ");
            readFromServer = con.read().toString();
            WritePost.clear();
            ShowPost[number].setText(readFromServer);
            ShowPost[number].setEditable(false);
        });
    }
    
    void ShowAllPosts(){
        pane_main_grid.getChildren().clear();
        int startPost;
        for(startPost=0;startPost<NoOfPost;startPost++){
            
            con = new ConnectionUtilities("localhost",22222);
            sendToServer = "ShowAllEEE263:"+startPost+":";
            con.write(sendToServer);
            readFromServer = con.read().toString();
            ShowPost[startPost] = new TextArea();
            comment[startPost] = new Button();            

            pane_main_grid.getChildren().add(ShowPost[startPost]);
            pane_main_grid.getChildren().add(comment[startPost]);
            
            ShowPost[startPost].setText(readFromServer);
            comment[startPost].setText("comment"); 
            ShowPost[startPost].setEditable(false);
            CommentUpdating(startPost);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pane_main_grid.setSpacing (10);
        con = new ConnectionUtilities("localhost",22222);
        sendToServer = "NoOfPostsEEE263:ria";
        con.write(sendToServer);
        readFromServer = con.read().toString();
        NoOfPost = Integer.parseInt(readFromServer);
        ShowAllPosts();
    }

}
