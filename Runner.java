package solution5;

import java.util.Scanner;

/**
 * Created by A222186 on 2018/04/10.
 */
public class Runner {

  public static void main(String[] args) {
    //Display products
    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();
    String answer = "Y";

    while ("Y".equals(answer)) {
      controller.displayProducts();
      System.out.println("Please enter the product id:");
      String productID = sc.next();
      controller.acceptOrder(productID);
      controller.checkValidityProduct();
      System.out.println();
      System.out.println("Please insert cash:");
      Double inputAmount = sc.nextDouble();
      controller.comparePrice(inputAmount);
      controller.dispenseProduct();
      controller.getChange();
      System.out.println();
      System.out.println("If you would like to order something else, enter \"Y\"");
      answer = sc.next();
    }



  }
}
