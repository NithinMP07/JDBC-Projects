
class Cricketer1{
	String name;
	int run;
	float avg;
	public Cricketer1(String name,int run,float avg) {
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

public class launchCricket {
	public static void main(String args[]) {
		Cricketer1 c=new Cricketer1("Sachin",20000,45.5f);
		c.display();
	}
}
