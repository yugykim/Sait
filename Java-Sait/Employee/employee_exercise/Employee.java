package employee_exercise;
import java.util.*;


public class Employee {
  private  String id, name, address, phone, dob, dept;
  private long sin;

  public Employee() {

  }

  public Employee(String id, String name, String address, String phone, String dob, String dept){
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.dob = dob;
    this.dept = dept;
  }

  public String getId() {
    return id;
  }

  public String getNmae() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getDob() {
    return dob;
  }

  public String getDept() {
    return dept;
  }

  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + ", sin=" + sin + ", dob=" + dob + ", dept=" + dept + "]";
  }
}
