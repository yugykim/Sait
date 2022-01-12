package carproject;

public interface CarMgmtInter {
	/* Add new Car */
	public boolean addCar(int type, String name, String code, int price);

	/* Get car info */
	public void getCarByName(String name);
	public void getCarByCode(String Code);
	public void getCarByType(int type);
	public void getCarByPrice(int start, int end);
	public void dump();

	/* Del new Car */
	public void delCarByName(String name);
}
