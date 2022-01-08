package carproject;

import java.util.ArrayList;

public class CarMgmt implements CarMgmtInter{
	ArrayList<Car> carList = new ArrayList<Car>();
	
	/* Add new Car */
	public boolean addCar(int t, String n, String c, int p) {
		Car car;

		switch(t) {
			case 1: /* Sedan */ 
				car = new Sedan(t, n, c, p);
				break;
			case 2: /* Van */ 
				car = new Van(t, n, c, p, 0.1);
				break;
			case 3: /* Truck */ 
				car = new Truck(t, n, c, p, 0.1, 0.3);
				break;
			default:
				return false;
		}

		//Write your code
		carList.add(car);

		return true;
	}

	/* Get car info */
	public void getCarByName(String name){
		//Write your code
    for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).name.equalsIgnoreCase(name)) {
				carList.get(i).printAllInfo();
			}
		}

	}

	public void getCarByCode(String code){
		//Write your code
    for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).name.equalsIgnoreCase(code)) {
				carList.get(i).printAllInfo();
			}
		}
	}

	public void getCarByType(int type){
		//Write your code
    for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).name == type) {
				carList.get(i).printAllInfo();
			}
		}
	}

	public void getCarByPrice(int start, int end){
		//Write your code
    for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).price >= start && carList.get(i).price <= end) {
				carList.get(i).printAllInfo();
			}
		}
	}

	public void dump(){
		//Write your code - print info of all cars in arrayList
    for(int i = 0; i < carList.size(); i++) {
      carList.get(i).printAllInfo();
		}
	}

	/* Del a Car by name */
	public void delCarByName(String name){
		//Write your code
    for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).name.equalsIgnoreCase(name)) {
				carList.remove(i);
			}
		}

	}
}
