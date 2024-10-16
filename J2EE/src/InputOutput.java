import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutput {
	public static void main(String args[]) {
		String path1="E:\\Eclipse\\iopgrm\\input.txt";
		String path2="E:\\Eclipse\\iopgrm\\output.txt";
		try {
		FileInputStream fis=new FileInputStream(path1);
		FileOutputStream fos=new FileOutputStream(path2);
		int x;
		while((x=fis.read())!=-1) {
			fos.write(x);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
