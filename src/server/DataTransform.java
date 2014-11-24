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
 *
 * @author madhura phatak
 * version 1.0
 * This class transforms the data (live packet and training set) for the neural network
 */
public class DataTransform 
{    
    public static String packet = new String(); // This variable stores the transformed packet
    public static LinkedList l;
    public static Socket s2;
    
    /**
     * Constructor to create an object of class DataTransform
     */
    public DataTransform()
    {
    }
    
    /**
     * 
     * @param str duration value of the packet
     */
    private void transformDuration(String str)throws Exception
    { 
        if(isNumeric(str))
        {
            packet = packet + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str protocol_type value of the packet
     */
    private void transformProtocolType(String str)throws Exception
    {
        if(str.equalsIgnoreCase("tcp"))
            packet = packet + " 2";
        else if(str.equalsIgnoreCase("udp"))
            packet = packet + " 3";
        else if(str.equalsIgnoreCase("icmp"))
            packet = packet + " 4";
        else 
            packet = packet + "invalid";
    }
    
/**
     * 
     * @param str service value of the packet
     */
     private void transformService(String str)throws Exception
    {
        if(str.equalsIgnoreCase("auth"))
           packet  = packet + " 16";
        else if(str.equalsIgnoreCase("bgp"))
           packet  = packet + " 17";
        else if(str.equalsIgnoreCase("courier"))
           packet  = packet + " 18";
        else if(str.equalsIgnoreCase("csnet_ns"))
           packet  = packet + " 19";
        else if(str.equalsIgnoreCase("ctf"))
           packet  = packet + " 20";
        else if(str.equalsIgnoreCase("daytime"))
           packet  = packet + " 21";
        else if(str.equalsIgnoreCase("discard"))
           packet  = packet + " 22";
        else if(str.equalsIgnoreCase("domain"))
           packet  = packet + " 23";
        else if(str.equalsIgnoreCase("domain_u"))
           packet  = packet + " 24";
        else if(str.equalsIgnoreCase("echo"))
           packet  = packet + " 25";
        else if(str.equalsIgnoreCase("eco_i"))
           packet  = packet + " 26";
        else if(str.equalsIgnoreCase("ecr_i"))
           packet  = packet + " 27";
        else if(str.equalsIgnoreCase("efs"))
           packet  = packet + " 28";
        else if(str.equalsIgnoreCase("exec"))
           packet  = packet + " 29";
        else if(str.equalsIgnoreCase("finger"))
           packet  = packet + " 30";
        else if(str.equalsIgnoreCase("ftp"))
           packet  = packet + " 31";
        else if(str.equalsIgnoreCase("ftp_data"))
           packet  = packet + " 32";
        else if(str.equalsIgnoreCase("gopher"))
           packet  = packet + " 33";
        else if(str.equalsIgnoreCase("hostnames"))
           packet  = packet + " 34";
        else if(str.equalsIgnoreCase("http"))
           packet  = packet + " 35";
        else if(str.equalsIgnoreCase("http_443"))
           packet  = packet + " 36";
        else if(str.equalsIgnoreCase("http_8001"))
           packet  = packet + " 37";
        else if(str.equalsIgnoreCase("imap4"))
           packet  = packet + " 38";
        else if(str.equalsIgnoreCase("IRC"))
           packet  = packet + " 39";
        else if(str.equalsIgnoreCase("iso_tsap"))
           packet  = packet + " 40";
        else if(str.equalsIgnoreCase("klogin"))
           packet  = packet + " 41";
        else if(str.equalsIgnoreCase("kshell"))
           packet  = packet + " 42";
        else if(str.equalsIgnoreCase("ldap"))
           packet  = packet + " 43";
        else if(str.equalsIgnoreCase("link"))
           packet  = packet + " 44";
        else if(str.equalsIgnoreCase("login"))
           packet  = packet + " 45";
        else if(str.equalsIgnoreCase("mtp"))
           packet  = packet + " 46";
        else if(str.equalsIgnoreCase("name"))
           packet  = packet + " 47";
        else if(str.equalsIgnoreCase("netbios_dgm"))
           packet  = packet + " 48";
        else if(str.equalsIgnoreCase("netbios_ns"))
           packet  = packet + " 49";
        else if(str.equalsIgnoreCase("netbios_ssn"))
           packet  = packet + " 50";
        else if(str.equalsIgnoreCase("netstat"))
           packet  = packet + " 51";
        else if(str.equalsIgnoreCase("nnsp"))
           packet  = packet + " 52";
        else if(str.equalsIgnoreCase("nntp"))
           packet  = packet + " 53";
        else if(str.equalsIgnoreCase("ntp_u"))
           packet  = packet + " 54";
        else if(str.equalsIgnoreCase("pm_dump"))
           packet  = packet + " 55";
        else if(str.equalsIgnoreCase("pop_2"))
           packet  = packet + " 56";
        else if(str.equalsIgnoreCase("pop_3"))
           packet  = packet + " 57";
        else if(str.equalsIgnoreCase("printer"))
           packet  = packet + " 58";
        else if(str.equalsIgnoreCase("private"))
           packet  = packet + " 59";
        else if(str.equalsIgnoreCase("red_i"))
           packet  = packet + " 60";
        else if(str.equalsIgnoreCase("remote_job"))
           packet  = packet + " 61";
        else if(str.equalsIgnoreCase("rje"))
           packet  = packet + " 62";
        else if(str.equalsIgnoreCase("shell"))
           packet  = packet + " 63";
        else if(str.equalsIgnoreCase("smtp"))
           packet  = packet + " 64";
        else if(str.equalsIgnoreCase("sql_net"))
           packet  = packet + " 65";
        else if(str.equalsIgnoreCase("ssh"))
           packet  = packet + " 66";
        else if(str.equalsIgnoreCase("sunrpc"))
           packet  = packet + " 67";
        else if(str.equalsIgnoreCase("supdup"))
           packet  = packet + " 68";
        else if(str.equalsIgnoreCase("systat"))
           packet  = packet + " 69";
        else if(str.equalsIgnoreCase("telnet"))
           packet  = packet + " 70";
        else if(str.equalsIgnoreCase("tim_i"))
           packet  = packet + " 71";
        else if(str.equalsIgnoreCase("time"))
           packet  = packet + " 72";
        else if(str.equalsIgnoreCase("urh_i"))
           packet  = packet + " 73";
        else if(str.equalsIgnoreCase("urp_i"))
           packet  = packet + " 74";
        else if(str.equalsIgnoreCase("uucp"))
           packet  = packet + " 75";
        else if(str.equalsIgnoreCase("uucp_path"))
           packet  = packet + " 76";
        else if(str.equalsIgnoreCase("vmnet"))
           packet  = packet + " 77";
        else if(str.equalsIgnoreCase("whois"))
           packet  = packet + " 78";
        else if(str.equalsIgnoreCase("X11"))
           packet  = packet + " 79";
        else if(str.equalsIgnoreCase("Z39_50"))
           packet  = packet + " 80";
        else if(str.equalsIgnoreCase("other"))
           packet  = packet + " 81";
       
        else 
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str flag value of the packet
     */
    private void transformFlag(String str)throws Exception
    {
        if(str.equalsIgnoreCase("oth"))
           packet  = packet + " 5";
        else if(str.equalsIgnoreCase("rej"))
           packet  = packet + " 6";
        else if(str.equalsIgnoreCase("rsto"))
           packet  = packet + " 7";
        else if(str.equalsIgnoreCase("rstos0"))
           packet  = packet + " 8";
        else if(str.equalsIgnoreCase("rstr"))
           packet  = packet + " 9";
        else if(str.equalsIgnoreCase("s0"))
           packet  = packet + " 10";
        else if(str.equalsIgnoreCase("s1"))
           packet  = packet + " 11";
        else if(str.equalsIgnoreCase("s2"))
           packet  = packet + " 12";
        else if(str.equalsIgnoreCase("s3"))
           packet  = packet + " 13";
        else if(str.equalsIgnoreCase("sf"))
           packet  = packet + " 14";
        else if(str.equalsIgnoreCase("sh"))
           packet  = packet + " 15";
        else 
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str src_byte value of the packet
     */
    private void transformSrc_bytes(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str dst_byte value of packet
     */
    private void transformDst_bytes(String str)throws Exception
    { 
        if(isNumeric(str))
        {
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
     /**
      * 
      * @param str land value of packet 
      */
    private void transformLand(String str)throws Exception
    { 
        if(isNumeric(str))
        {
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str wrong_format value of packet 
     */
    private void transformWrong_format(String str)throws Exception
    { 
        if(isNumeric(str))
        {
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str urgent field of packet
     */
    private void transformUrgent(String str)throws Exception
    { 
        if(isNumeric(str))
        {
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str hot value of the packet
     */
    private void transformHot(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str num_failed_login value of the packet
     */
    private void transformNum_failed_login(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Logged_in value of the packet
     */
    private void transformLogged_in(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_Compromised value of the packet
     */
    private void transformNum_Compromised(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Root_shell value of the packet
     */
    private void transformRoot_shell(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Su_attempted value of the packet
     */
    private void transformSu_attempted(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_root value of the packet
     */
    private void transformNum_root(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_file_creations value of the packet
     */
    private void transformNum_file_creations(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_shells value of the packet
     */
    private void transformNum_shells(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_access_files value of the packet
     */
    private void transformNum_access_files(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Num_outbond_cmds value of the packet
     */
    private void transformNum_outbond_cmds(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Is_host_login value of the packet
     */
    private void transformIs_host_login(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Is_guest_login value of the packet
     */
    private void transformIs_guest_login(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Count value of the packet
     */
    private void transformCount(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Srv_count value of the packet
     */
    private void transformSrv_count(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Serror_rate value of the packet
     */
    private void transformSerror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Srv_Serror_rate value of the packet
     */
    private void transformSrv_Serror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Rerror_rate value of the packet
     */
    private void transformRerror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Srv_Rerror_rate value of the packet
     */
    private void transformSrv_Rerror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Same_srv_rate value of the packet
     */
    private void transformSame_srv_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Diff_srv_rate value of the packet
     */
    private void transformDiff_srv_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Srv_diff_host_rate value of the packet
     */
    private void transformSrv_diff_host_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_count value of the packet
     */
    private void transformDst_host_count(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_srv_count value of the packet
     */
    private void transformDst_host_srv_count(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_same_srv_rate value of the packet
     */
    private void transformDst_host_same_srv_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_diff_srv_rate value of the packet
     */
    private void transformDst_host_diff_srv_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_sname_src_port_rate value of the packet
     */
    private void transformDst_host_sname_src_port_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_sev_diff_host_rate value of the packet
     */
    private void transformDst_host_sev_diff_host_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_serror_rate value of the packet
     */
    private void transformDst_host_serror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_srv_serror_rat value of the packet
     */
    private void transformDst_host_srv_serror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_rerror_rate value of the packet
     */
    private void transformDst_host_rerror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    /**
     * 
     * @param str Dst_host_srv_rerror_rate value of the packet
     */
    private void transformDst_host_srv_rerror_rate(String str)throws Exception
    { 
        if(isNumeric(str))
        {  
            packet = packet + " " + str;
        }
        else
            packet = packet + "invalid";
    }
    
    public static void getSocketConnection(Socket s)
    {
        s2 = s;
    }
    
    public void transformDataset()
    {
        
    }
            
    
    /**
     * 
     * @param p packet received by server from client
     * @return decoded packet as required by the neural network
     */
    public String transformPacket(client.Packet p)throws Exception
    {
        packet = new String();
       LinkedList l = p.decodePacket();
       
       //call all the 41 methods for data transformation
       transformDuration(l.remove().toString());
       transformProtocolType(l.remove().toString());
       transformService(l.remove().toString());
       transformFlag(l.remove().toString());
       transformSrc_bytes(l.remove().toString());
       transformDst_bytes(l.remove().toString());
       transformLand(l.remove().toString());
       transformWrong_format(l.remove().toString());
       transformUrgent(l.remove().toString());
       transformHot(l.remove().toString());
       transformNum_failed_login(l.remove().toString());
       transformLogged_in(l.remove().toString());
       transformNum_Compromised(l.remove().toString());
       transformRoot_shell(l.remove().toString());
       transformSu_attempted(l.remove().toString());
       transformNum_root(l.remove().toString());
       transformNum_file_creations(l.remove().toString());
       transformNum_shells(l.remove().toString());
       transformNum_access_files(l.remove().toString());
       transformNum_outbond_cmds(l.remove().toString());
       transformIs_host_login(l.remove().toString());
       transformIs_guest_login(l.remove().toString());
       transformCount(l.remove().toString());
       transformSrv_count(l.remove().toString());
       transformSerror_rate(l.remove().toString());
       transformSrv_Serror_rate(l.remove().toString());
       transformRerror_rate(l.remove().toString());
       transformSrv_Rerror_rate(l.remove().toString());
       transformSame_srv_rate(l.remove().toString());
       transformDiff_srv_rate(l.remove().toString());
       transformSrv_diff_host_rate(l.remove().toString());
       transformDst_host_count(l.remove().toString());
       transformDst_host_srv_count(l.remove().toString());
       transformDst_host_same_srv_rate(l.remove().toString());
       transformDst_host_diff_srv_rate(l.remove().toString());
       transformDst_host_sname_src_port_rate(l.remove().toString());
       transformDst_host_sev_diff_host_rate(l.remove().toString());
       transformDst_host_serror_rate(l.remove().toString());
       transformDst_host_srv_serror_rate(l.remove().toString());
       transformDst_host_rerror_rate(l.remove().toString());
       transformDst_host_srv_rerror_rate(l.remove().toString());
       
       return packet; 
    }
    
    /**
     * 
     * @param str
     * @return whether the string is numeric or not
     */
    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }
}

