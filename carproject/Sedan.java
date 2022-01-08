package carproject;

public class Sedan extends Car{
	Sedan(int type, String name, String code, int price){
		super(type, name, code, price);
	}

	/* Print car info */
	@Override
	public void printAllInfo() {
		System.out.println("Type: Sedan");
		//Write your code
    printBasicInfo();
	}
}
