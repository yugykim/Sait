import java.util.*;

public class hyunju {
  /** Main method */
	public static void main(String[] args) {
		// Create a Scanner
      Scanner in = new Scanner(System.in);
        // Create an ArrayList
      ArrayList<Integer> list = new ArrayList<Integer>();
      
      // Prompt input from user
      System.out.print("Enter the integers: ");
      for (int i = 0; i < 10; i++) {
        list.add(in.nextInt());
      }

      // Invoke removeDuplicate method (Send)
      list = removeDuplicate(list);
      
      // Display the distinct integer
      System.out.print("The distinct integer are ");
      for (int num : list) {
        System.out.print(num + " ");
		}

	}
  
  /** Removes the duplicate elements from an arrayList */
  public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> list) {
      ArrayList<Integer> tempList = new ArrayList<Integer>();
      for (int num : list) {
        if (!tempList.contains(num))
          tempList.add(num);
      }
      return tempList;
  }
}
