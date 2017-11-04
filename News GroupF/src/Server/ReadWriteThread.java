/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author RIA
 */
public class ReadWriteThread implements Runnable{
    private Thread t;
    private ConnectionUtilities connection;
    public String getPost;
    //private int PostNo = 0;
    
    public ReadWriteThread(ConnectionUtilities connection){
        this.connection = connection;
        t = new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        getPost = (String) connection.read();
        connection.write(getPost);
    }
  
    
}
