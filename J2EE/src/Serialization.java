import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cricketer implements Serializable{
	String name;
	int run;
	float avg;
	public Cricketer(String name,int run,float avg) {
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

public class Serialization {
	public static void main(String args[]) throws Exception {
		Cricketer c=new Cricketer("Sachin",20000,45.5f);
		c.display();
		String path="E:\\Eclipse\\iopgrm\\input.txt";
		FileOutputStream fos=new FileOutputStream(path);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(c);
	}
}
