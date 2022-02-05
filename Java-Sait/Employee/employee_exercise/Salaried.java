package employee_exercise;

public class Salaried extends Employee {
  private double salary;

  public Salaried(String id, String name, String address, String phone, String dob, String dept, double salary) {
    super(id, name, address, phone, dob, dept);
    
    this.salary = salary;
  }

  public double getSalary() {
    return this.salary;
  }

  public double getPay() {
    return this.salary;
  }

  @Override
  public String toString() {
    return "Employee [id=" + getId() + ", name=" + getNmae() + ", address=" + getAddress() + ", phone=" +  ", dob=" + getDob() + ", dept=" + getDept() + "]" + ", salary=" + this.salary;
  }
}
