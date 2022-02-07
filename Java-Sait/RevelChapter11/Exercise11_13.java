/**
 * 
 */

 import java.util.Scanner;
 import java.util.ArrayList;

 public class Exercise11_13 {
   public static void main(String[] args){

     ArrayList<Integer> list = new ArrayList<>();

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter ten integers: ");
     int num;

     while (list.size() < 10){
       num = sc.nextInt();
       list.add(num);
     }

     for(int e = 0; e < list.size(); e++){
       for(int k = list.size() -1; k > e; k--){
         
        if (list.get(e) == list.get(k) && list.get(e) != -1){
          list.set(k, -1);
        }
      }

    }
    for (int i : list) {
      if (i != -1)
      System.out.print(i + " ");
    }
   } 
 }