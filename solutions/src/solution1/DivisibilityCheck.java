package solution1;

import java.util.ArrayList;
import java.util.Scanner;

public class DivisibilityCheck {
  private final int divisor=8;

  public static void main(String[] args) {
    DivisibilityCheck divisibilityCheck= new DivisibilityCheck();
    Scanner sc = new Scanner(System.in);
    int numTests = sc.nextInt();
    ArrayList<Integer> output= new ArrayList<>();
    while(numTests>0) {
      int number = sc.nextInt();
      output.add(divisibilityCheck.isDivisible(number));
      numTests--;
    }

    for(int num:output){
      System.out.println(num);
    }

  }

  private int isDivisible(int number){
    if(number%divisor==0)
      return 1;
    else
      return -1;
  }
}
