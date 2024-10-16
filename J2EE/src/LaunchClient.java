import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LaunchClient {
	 public static void main(String args[]) throws IOException {
		 Socket csoc=new Socket("localhost",4000);
		 OutputStream os=csoc.getOutputStream();
		 DataOutputStream dos=new DataOutputStream(os);
		 Scanner sc=new Scanner(System.in);
		 String msg=sc.nextLine();
		 dos.writeUTF(msg);		 
		 
//		 InputStream is=csoc.getInputStream();
//		 DataInputStream dis=new DataInputStream(is);
//		 msg=dis.readUTF();
//		 System.out.println(msg);
		 
	 }
}
