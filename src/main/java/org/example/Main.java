package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static final int CACHE_PORT = 6379;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(CACHE_PORT);
            serverSocket.setReuseAddress(true);
            while(!serverSocket.isClosed() && !Thread.currentThread().isInterrupted()){
                Socket clientSocket = serverSocket.accept();
            }
        } catch (Exception ex){
            System.out.println();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e){
                System.out.println("IOException: "+e.getMessage());
            }
        }
    }
}
