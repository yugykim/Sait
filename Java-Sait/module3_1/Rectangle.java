package module3_1;
import java.util.Date;

public class Rectangle extends Shape{
  private double width;
  private double height;

  public Rectangle() {
    super();

  }

  public Rectangle(double width, double height){
     super();
     this.width = width;
     this.height = height;
     
  }

  public Rectangle(String color, boolean filled, Date dateCreated, double width, double height){
    super(color, filled, dateCreated);

    this.width = width;
    this.height = height;
  }

  



}

