/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.io.*;
import java.util.*;
import java.net.*;
/**
 * This is the server
 * @author madhura phatak
 * version 1.0
 */
public class Server {
    
    static BufferedReader br = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
        DataTransform dt = new DataTransform();
        File file = new File("transformedDataset.txt");
        BufferedReader br = new BufferedReader(new FileReader(file.getCanonicalPath()));
        String line = br.readLine();
        if(line==null)
        {
            dt.transformDataset();
            System.out.println("DataSet transformed");
        }
        ServerSocket s = new ServerSocket(6789); 
        while(true)
        {
            System.out.println("Listening....");
            Socket s1=s.accept();
            InputStream is = s1.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            client.Packet p = (client.Packet)ois.readObject();
            p.displayPacket();
            if(packetSize(p)==41)
            {
                //Data Transformation of live packet                
                dt.getSocketConnection(s1);
                String packet = dt.transformPacket(p);
                BufferedWriter out = new BufferedWriter(new FileWriter("output.txt", true));  
                out.append(packet);
                out.newLine();
                out.close();
            }
            else 
               System.out.println("Invalid Packet");
        }
    }
    
    /**
     * 
     * @param pack packet sent by server to client
     * @return size of the packet 
     */
    public static int packetSize(client.Packet pack)
    {
        LinkedList l = pack.decodePacket();
        return l.size();
    }    
}

