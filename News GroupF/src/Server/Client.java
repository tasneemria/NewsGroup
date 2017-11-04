/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author RIA
 */
public class Client implements Runnable{
    private Thread t;
    public ConnectionUtilities connection;
    public static String ClientName;
    private static int ClientId;
    public static String Password;
    
    public Client(ConnectionUtilities con)
    {
        connection = con;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        
    }
}
