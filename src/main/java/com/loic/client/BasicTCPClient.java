package com.loic.client;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BasicTCPClient {
    public static void main(String[] args){
        int i=0;
        while (i<5){
            try{
                Socket client=new Socket(InetAddress.getLocalHost().getHostAddress(),8000);
                OutputStream outputStream = client.getOutputStream();
                BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
                DataOutputStream dataOutputStream=new DataOutputStream(bufferedOutputStream);
                dataOutputStream.writeChars("Hello Server, I'm client.");
                dataOutputStream.flush();
                client.shutdownOutput();
                outputStream.close();
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            i++;
        }
    }
}
