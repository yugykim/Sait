package carproject;

abstract class Car {
	int type;
	String name;
	String code;
	int price;

	Car(int t, String n, String c, int p){
		this.type = t;
		this.name = n;
		this.code = c;
		this.price = p;
	}
	
	public void printBasicInfo() {
		System.out.println ("TypeNumber: " + this.type);
		System.out.println ("Name: " + this.name);
		System.out.println ("Code: " + this.code);
		System.out.println ("Price: " + this.price);
	}
	
	public abstract void printAllInfo();
}