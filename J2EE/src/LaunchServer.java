import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LaunchServer {
 public static void main(String args[]) throws IOException {
	 ServerSocket listener =new ServerSocket(4000);
	 System.out.println("Server is ready to accept request");
	 Socket ssoc=listener.accept();
	 InputStream is=ssoc.getInputStream();
	 DataInputStream dis=new DataInputStream(is);
	 String msg=dis.readUTF();
	 System.out.println(msg);
	 }
}
