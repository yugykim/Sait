package carproject;

public class Truck extends Car {
	double extraDiscount;
	double enviromentFee;

	Truck(int type, String name, String code, int price, double ed, double ef){
		super(type, name, code, price);
		this.extraDiscount = ed;
		this.enviromentFee = ef;
	}

	/* Print car info */
	@Override
	public void printAllInfo() {
		System.out.println("Type: Truck");
		//Write your code
    printBasicInfo();
    System.out.println("extraDiscount: " + extraDiscount);
    System.out.println("enviromentFee: " + enviromentFee);
	}
}
