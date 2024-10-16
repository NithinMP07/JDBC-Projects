import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class StringInOutput {
	public static void main(String args[]) {
		String path1="E:\\Eclipse\\iopgrm\\input.txt";
		String path2="E:\\Eclipse\\iopgrm\\output.txt";
		try {
		FileReader fr=new FileReader(path1);
		FileWriter fw=new FileWriter(path2);
		BufferedReader br=new BufferedReader(fr);
		BufferedWriter bw=new BufferedWriter(fw);
		String x;
		
		while((x=br.readLine())!=null) {
			bw.write(x);
		}
		bw.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
