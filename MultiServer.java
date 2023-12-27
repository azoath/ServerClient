import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
  public static void main(String[] args) throws Exception {
    try {
      try (ServerSocket ss = new ServerSocket(8888)) {
        int counter = 0;
        System.out.println("Server Started ....");
        while (true) {
          counter++;
          Socket s = ss.accept(); 
          System.out.println(" >> " + "Client No:" + counter + " started!");
          ServerClientThread sct = new ServerClientThread(s, counter); 
          sct.start();
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class ServerClientThread extends Thread {
  Socket s;
  int clientNo;

  ServerClientThread(Socket inSocket, int counter) {
    s = inSocket;
    clientNo = counter;
  }

  public void run() {
    try {
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = "", str2 = "";
      while (!str.equals("stop")) {
        str = din.readUTF();
        System.out.println("From Client-" + clientNo + ": Number is :" + str);
        str2 = br.readLine();
        dout.writeUTF(str2);
        dout.flush();
      }
      din.close();
      dout.close();
      s.close();
    } catch (Exception ex) {
      System.out.println(ex);
    } finally {
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}