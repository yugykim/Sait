package manager;
import employee_exercise.*;
import java.io.*;
import java.util.*;

public class Manager {
  private ArrayList<Employee> employees = new ArrayList<Employee>(); 

  
  public Manager() throws FileNotFoundException{

    loadEmployeesFromFile();
    /*
    System.out.println("The average pay for all empolyees is: " + averagePay());
    System.out.println("The Wages employee with the highest pay is: " + highestPayWagesEmployee() );
    System.out.println("The Salaried employee with the lowest pay is: " + lowestPaySalariedEmployee() );
    System.out.println("Percentage of Salaried employees is: " + percentageOfSalaried() + "%");
    System.out.println("Percentage of Wages employees is: " + percentageOfWages() + "%");
    System.out.println("Percentage of Part Time employees is: " + percentageOfPartTime() + "%");
    */
  }

  public void loadEmployeesFromFile() throws FileNotFoundException{
    File inputFile = new File("./employees.txt");
		Scanner input = new Scanner(inputFile);

    while(input.hasNextLine()) {
      String line = input.nextLine();
			String splittedData[] = line.split(":");

      for (String e : splittedData){
        System.out.println(e);
      }
    }

  }

}
