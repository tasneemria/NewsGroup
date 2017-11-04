/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RIA
 */
public class ConnectionUtilities {
    public Socket sc;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;
    
    public ConnectionUtilities(String host, int port){
        try {
            sc=new Socket(host,port);
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public ConnectionUtilities(Socket socket){
        try {
            sc=socket;
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void write(Object o){
        try {
            oos.writeObject(o);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Object read(){
        try {
            Object o=ois.readObject();
            return o;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
	public void closeConnection() 
        {
            try {
                ois.close();
                oos.close();
            } catch (Exception e) {
                    System.out.println("Error occured");
            }
        }
    
}
