package employee_exercise;
public class Wages extends PartTime{

  private static final int REGULAR_HOURS = 40;
	private static final double OVERTIME_RATE = 1.5;

  //public Wages(String id, String name, String address, String phone, String dob, String dept, double rate, double hours) {
  //  super(id, name, address, phone, dob, dept, rate, hours);
  //}

  @Override
  public double getPay()	{
    double hours = getHours();
    double rate = getRate();

		if (hours > REGULAR_HOURS) {
			return (REGULAR_HOURS * rate) + ((hours - REGULAR_HOURS) * OVERTIME_RATE * rate);
		}
		else	{
			return rate * hours;
		}
	}

}
