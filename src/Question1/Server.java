/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author BLANK
 */
public class Server {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;
    
    public Server(){
        try{
            DatagramSocket serverSocket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName(INET_ADDR);
            
            while(true){
                long epochTime = System.currentTimeMillis()/1000;
                String msg = Long.toString(epochTime);
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                msg.getBytes().length, addr, PORT);
                serverSocket.send(msgPacket);
                System.out.println("Server sent packet with msg: " + msg);
                Thread.sleep(500);
            }
        }catch(UnknownHostException ex){
            ex.printStackTrace();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[]args){
        new Server();
    }
}
