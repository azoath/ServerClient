
import java.net.*;

public class ipAddress {
    public static void main(String args[]) throws Exception {
        try{
            InetAddress ip= InetAddress.getByName("www.google.com");
            System.out.println("local host:"+ ip.getHostName());
            System.out.println("IP address:"+ ip.getHostAddress());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
