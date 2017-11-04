/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import news.groupf.CSE201Controller;

/**
 *
 * @author RIA
 */
public class server implements Runnable{
    private int PostNo;
    private String UserName;
    private String FromUser;
    private String filename = "";
    private String readFromFile;
    //private static int PostNumber = 0;
    private String[] users;
    private ServerSocket sSocket;
    private Socket conSocket;
    private Thread t;
    private File existingFile = null;
    public ConnectionUtilities connection;

    public server(){
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            sSocket = new ServerSocket(22222);
            while(true){
                //System.out.println("server started");
                conSocket = sSocket.accept();
                connection = new ConnectionUtilities(conSocket);
                FromUser = connection.read().toString();
                //System.out.println(FromUser);
                users = FromUser.split(":");
                if(users[0].equals("login")){
                    UserName = users[1];
                    
                    //match password from file
                    String[] readPass;
                    readPostFile("UserName and Passwords.txt");
                    readPass = readFromFile.split("#");
                    //System.out.println(readFromFile);
                    int index = 0;
                    while(index<8){
                        if(readPass[index].equals(users[1]) && readPass[index+1].equals(users[2])){
                            //System.out.println("found true");
                            connection.write("true");
                        }
                        else if(index==7)
                        {
                            connection.write("false");
                        }
                        index++;
                    }
                }
                
                
                //CSE201 course...............
                else if(users[0].equals("CSE201")){
                    ReadPostNo("CSE201PostNo.txt");
                    UpdatePostNo("CSE201PostNo.txt");
                    filename = "CSE201 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE201comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE201 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE201")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE201PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE201")){
                    System.out.println("showing all posts");
                    filename = "CSE201 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }  
                //end of CSE201 course  
                
                
                //CSE202 course...............
                else if(users[0].equals("CSE202")){
                    ReadPostNo("CSE202PostNo.txt");
                    UpdatePostNo("CSE202PostNo.txt");
                    filename = "CSE202 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE202comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE202 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE202")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE202PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE202")){
                    System.out.println("showing all posts");
                    filename = "CSE202 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }  
                //end of CSE202 course   
                
                
                //starting CSE203 course
                else if(users[0].equals("CSE203")){
                    ReadPostNo("CSE203PostNo.txt");
                    UpdatePostNo("CSE203PostNo.txt");
                    filename = "CSE203 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE203comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE203 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE203")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE203PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE203")){
                    System.out.println("showing all posts");
                    filename = "CSE203 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of CSE203 course   
                
                
                //starting CSE204 course
                else if(users[0].equals("CSE204")){
                    ReadPostNo("CSE204PostNo.txt");
                    UpdatePostNo("CSE204PostNo.txt");
                    filename = "CSE204 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE204comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE204 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE204")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE204PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE204")){
                    System.out.println("showing all posts");
                    filename = "CSE204 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of CSE204 course    
                
                
                //starting CSE205 course
                else if(users[0].equals("CSE205")){
                    ReadPostNo("CSE205PostNo.txt");
                    UpdatePostNo("CSE205PostNo.txt");
                    filename = "CSE205 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE205comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE205 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE205")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE205PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE205")){
                    System.out.println("showing all posts");
                    filename = "CSE205 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of CSE205 course    
                
                
                //starting CSE206 course
                else if(users[0].equals("CSE206")){
                    ReadPostNo("CSE206PostNo.txt");
                    UpdatePostNo("CSE206PostNo.txt");
                    filename = "CSE206 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("CSE206comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "CSE206 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsCSE206")){
                    //System.out.println("initializer sending");
                    ReadPostNo("CSE206PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllCSE206")){
                    System.out.println("showing all posts");
                    filename = "CSE206 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of CSE206 course 
                
                //for EEE263 course...........
                else if(users[0].equals("EEE263")){
                    ReadPostNo("EEE263PostNo.txt");
                    UpdatePostNo("EEE263PostNo.txt");
                    filename = "EEE263 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("EEE263comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "EEE263 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsEEE263")){
                    //System.out.println("initializer sending");
                    ReadPostNo("EEE263PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllEEE263")){
                    System.out.println("showing all posts");
                    filename = "EEE263 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of EEE263 course.......

                //for EEE264 course...........
                else if(users[0].equals("EEE264")){
                    ReadPostNo("EEE264PostNo.txt");
                    UpdatePostNo("EEE264PostNo.txt");
                    filename = "EEE264 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("EEE264comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "EEE264 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsEEE264")){
                    //System.out.println("initializer sending");
                    ReadPostNo("EEE264PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllEEE264")){
                    System.out.println("showing all posts");
                    filename = "EEE264 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of EEE264 course.......    
                
                
                //for MATH241 course...........
                else if(users[0].equals("MATH241")){
                    ReadPostNo("MATH241PostNo.txt");
                    UpdatePostNo("MATH241PostNo.txt");
                    filename = "MATH241 " + PostNo + ".txt";
                    doPost(filename);
                    readPostFile(filename);
                    connection.write(readFromFile + "#" +PostNo);
                }
                
                else if(users[0].equals("MATH241comment")){   
                    //users[1] e comment number paowa jabe
                    filename = "MATH241 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        doPost(filename);
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }
                }
                else if(users[0].equals("NoOfPostsMATH241")){
                    //System.out.println("initializer sending");
                    ReadPostNo("MATH241PostNo.txt");
                    connection.write(PostNo);
                }
                else if(users[0].equals("ShowAllMATH241")){
                    System.out.println("showing all posts");
                    filename = "MATH241 " + users[1] + ".txt";
                    existingFile = new File(filename);
                    if(existingFile.exists()){
                        System.out.println("file exists");
                        readPostFile(filename);
                        connection.write(readFromFile);
                    }
                    else{
                        connection.write("no post found!");
                    }                    
                }
                //end of MATH241 course.......                
                
                
                
                connection.write(true);
            }
            
        } catch (IOException ex) {
            System.out.println("server failed");
        }
    }
    
    
    private void readPostFile(String fileName){
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader file = new FileReader(fileName);
            reader = new BufferedReader(file);
            String text;
            while((text = reader.readLine()) != null){
                stringBuilder.append(text);
                if(text.isEmpty()){
                    stringBuilder.append("\n");
                }
                System.out.println(text);
            }
            readFromFile = stringBuilder.toString();
            
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CSE201Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(null != reader){
                try{
                    reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    private void doPost(String fileName){
        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            String post = FromUser +" "+ UserName;
            bufferedWritter.newLine();
            bufferedWritter.write(post);            
            //bufferedWritter.append('\n');//added
            bufferedWritter.newLine();
            bufferedWritter.flush();
            
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(bufferedWritter != null){
                try{
                    bufferedWritter.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void ReadPostNo(String fileName){
        BufferedReader reader = null;
        
        StringBuilder stringBuilder = new StringBuilder();
        try {
            
            FileReader file = new FileReader(fileName);
            reader = new BufferedReader(file);
            String text;
            while((text = reader.readLine()) != null){
                stringBuilder.append(text);
                if(text.isEmpty()){
                    stringBuilder.append("\n");
                }
                System.out.println(text);
            }
            PostNo = Integer.parseInt(stringBuilder.toString());

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CSE201Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(null != reader){
                try{
                    reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }         
    }
    
    private void UpdatePostNo(String fileName){
        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            bufferedWritter = new BufferedWriter(fileWriter);
            String post = Integer.toString(PostNo+1);
            bufferedWritter.write(post);
            
            bufferedWritter.flush();          

            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(bufferedWritter != null){
                try{
                    bufferedWritter.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }        
        
    }
   
}
