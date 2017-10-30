package com.loic.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicTCPServer {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(8000);
            while (true){
                Socket socket=server.accept();
                new Thread(new TransThread(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

class TransThread implements Runnable{
    private Socket socket;
    public TransThread(Socket socket){
        this.socket=socket;
    }


    public void run(){
        try{
            InputStream inputStream=socket.getInputStream();
           /* BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
            DataInputStream dataInputStream=new DataInputStream(bufferedInputStream);*/
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            System.out.println(bufferedReader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}