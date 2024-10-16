import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Cricket implements Serializable{
	String name;
	int run;       //transient int run;
	float avg;
	public Cricket(String name,int run,float avg) {
		super();
		this.name=name;
		this.run=run;      
		this.avg=avg;
	}
	void display() {
		System.out.println(name);
		System.out.println(run);
		System.out.println(avg);
	}
	
}

public class DeSerialization {
	public static void main(String args[]) throws Exception {
		String path="E:\\Eclipse\\iopgrm\\input.txt";
		FileInputStream fis=new FileInputStream(path);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Cricket c=(Cricket)ois.readObject();
		c.display();
	}
}
