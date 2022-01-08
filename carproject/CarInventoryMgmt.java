package carproject;

import java.util.Scanner;

public class CarInventoryMgmt {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CarMgmt cm = new CarMgmt();
		System.out.println("This is my Car book program");
		while (true) {
			int menu;
			System.out.println("\n------------------------");
			System.out.println("1. Add Car");
			System.out.println("2. Del Car");
			System.out.println("3. Search Car by Name");
			System.out.println("4. Search Car by Code");
			System.out.println("5. Search Cars by Type");
			System.out.println("6. Search Cars by Price");
			System.out.println("7. Print all cars");
			System.out.println("8. Exit");
			System.out.print("Select the number : ");
			menu = scan.nextInt();
			switch(menu) {
				case 1:
					int type, price;
					String name, code; 
					System.out.print(" Enter the type (1: Sedan, 2: Truck, 3: Van) : "); type = scan.nextInt();
					System.out.print(" Enter the name : "); name = scan.next();
					System.out.print(" Enter the code : "); code = scan.next();
					System.out.print(" Enter the price: "); price = scan.nextInt();
					cm.addCar(type, name, code, price);
					break;
				case 2:
					System.out.print(" Del: Enter the name: ");
					cm.delCarByName(scan.next());
					break;
				case 3:
					System.out.print(" Get: Enter the name: ");
					cm.getCarByName(scan.next());
					break;
				case 4:
					System.out.print(" Get: Enter the code: ");
					cm.getCarByCode(scan.next());
					break;
				case 5:
					System.out.print(" Get: Enter the type (1: Sedan, 2: Truck, 3: Van) : ");
					cm.getCarByType(scan.nextInt());
					break;
				case 6:
					int start, end;
					System.out.print(" Get: Enter start price: "); start = scan.nextInt();
					System.out.print(" Get: Enter end price: "); end = scan.nextInt();
					cm.getCarByPrice(start, end);
					break;
				case 7:
					cm.dump();
					break;
				case 8:
          
					System.exit(0);
					break;
			}
		}
	}
}
