package com.task01.se2einzelphase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Networker extends Thread{
    private String inputString;
    private String outputString;

    private Socket clientSocket;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;

    public Networker(String in){
        this.inputString = in;
    }

    public void run(){
        try{
            clientSocket = new Socket("se2-isys.aau.at", 53212);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(inputString + '\n');
            outputString = inFromServer.readLine();
            clientSocket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getOutputString(){
        return this.outputString;
    }

}
