package carproject;

public class Van extends Car{
	double familyDiscount;

	Van(int type, String name, String code, int price, double fd){
		super(type, name, code, price);
		familyDiscount = fd;
	}

	/* Print car info */
	@Override
	public void printAllInfo() {
		System.out.println("Type: Van");
		//Write your code
    printBasicInfo();
    System.out.println("familyDiscount: " + familyDiscount);
	}
}
