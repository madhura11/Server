/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.io.*;
import java.net.*;
/**
 * This is the server
 * @author madhura phatak
 * version 1.0
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
            ServerSocket s = new ServerSocket(6789); 
            while(true)
            {
                Socket s1=s.accept();
                InputStream is = s1.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                client.Packet p = (client.Packet)ois.readObject();
                p.displayPacket();
            }
    }
    
}
