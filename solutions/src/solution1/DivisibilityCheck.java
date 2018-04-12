package solution1;

import java.math.BigInteger;
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
      BigInteger number =sc.nextBigInteger();
      boolean add = output.add(divisibilityCheck.isDivisible(number));
      numTests--;
    }

    for(int num:output){
      System.out.println(num);
    }

  }

  private int isDivisible(BigInteger number){
    return number.mod(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO) ? 1 : -1;
  }
}
