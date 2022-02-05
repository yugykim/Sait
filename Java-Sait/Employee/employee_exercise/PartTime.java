package employee_exercise;

public class PartTime extends Employee{
  private double rate;
	private double hours;

  public PartTime() {

  }

  public PartTime(String id, String name, String address, String phone, String dob, String dept, double rate, double hours) {
    super(id, name, address, phone, dob, dept);
  }

  public double getRate () {
    return this.rate;
  }

  public double getHours () {
    return this.hours;
  }

  public double getPay() {
    return this.rate * this.hours;
  }

  @Override
  public String toString() {
    return "Employee [id=" + getId() + ", name=" + getNmae() + ", address=" + getAddress() + ", phone=" +  ", dob=" + getDob() + ", dept=" + getDept() + "]" + ", rate=" + this.hours + ", rate=" + this.rate + ", pay=" + getPay();
  }
}
