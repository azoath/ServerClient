import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Multiclient {
  public static void main(String[] args) throws Exception {
    try {
      Socket s = new Socket("127.0.0.1", 8888);
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = "", str2 = "";
      while (!str.equals("bye")) {
        str = br.readLine();
        dout.writeUTF(str);
        dout.flush();
        str2 = din.readUTF();
        System.out.println("Server says: " + str2);
      }
      dout.close();
      dout.close();
      s.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}