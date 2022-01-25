package module3_1;
import java.util.Date;

public class Circle extends Shape {
  private double radius;

  public Circle() {
    super();
  }

  public Circle(Stirng color, boolean filled, Date dateCreated) {
    super(color, filled, dateCreated);
  }

  public Circle(String color, boolean filled, Date dateCreated, double radius){
    super(color, filled, dateCreated, radius);
  }
}