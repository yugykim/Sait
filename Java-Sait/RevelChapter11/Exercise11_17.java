import java.util.Scanner;
import java.util.ArrayList;

public class Exercise11_17 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    System.out.print("Enter an integer m: ");
    int input = sc.nextInt();
    int oddNumResult = 1;
    int m = input;
    while (input != 1){
      for (int i = 1; i < 10; i++){
        if ((input % i) == 0 ){
          input = input / i;
          list.add(i);
          //System.out.println(i);
        }
      }
    }
    
    for(int j=0; j < list.size(); j++){
      for(int k = list.size()-1; k > j; k--){
        if(list.get(j) == list.get(k)){
          list.set(k, -1);
          list.set(j, -1);
        }
      }
    }


    
    for(int e : list){
      if(e != -1){
        oddNumResult *= e;
      }
    }
    
    
    System.out.println("The smallest number n for m x n to be a perfect square is " + oddNumResult);
    System.out.println("m x n is " + (m * oddNumResult));
  }
}


