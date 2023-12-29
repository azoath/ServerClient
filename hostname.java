import java.net.*;

public class hostname {
    
    public static void main(String args[]) throws UnknownHostException{
        InetAddress address= InetAddress.getLocalHost();
        System.out.println("local host=");
        System.out.println("\t"+ address.getHostAddress() );
        System.out.println("\t"+ address.getHostName() );        
    }
}
