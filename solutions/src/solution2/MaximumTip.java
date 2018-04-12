package solution2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumTip {

  private static int waiter1_capacity;
  private static int waiter2_capacity;


  public class Order {

    private int waiter1_tip;
    private int waiter2_tip;
    private int tip_diff;

    Order(int waiter1_tip, int waiter2_tip, int tip_diff) {
      this.waiter1_tip = waiter1_tip;
      this.waiter2_tip = waiter2_tip;
      this.tip_diff = tip_diff;
    }


    public int getWaiter1_tip() {
      return waiter1_tip;
    }

    public int getWaiter2_tip() {
      return waiter2_tip;
    }

    public int getTip_diff() {
      return tip_diff;
    }

    @Override
    public String toString() {
      return "Order{" +
          "waiter1_tip=" + waiter1_tip +
          ", waiter2_tip=" + waiter2_tip +
          ", tip_diff=" + tip_diff +
          '}';
    }
  }


  public static void main(String[] args) {
    MaximumTip maximumTip = new MaximumTip();

    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();

    while (testcases > 0) {
      sc.nextLine();
      int numOrders = Integer.parseInt(sc.next()) * 2;
      waiter1_capacity = Integer.parseInt(sc.next());
      waiter2_capacity = Integer.parseInt(sc.next());

      ArrayList<Integer> tips = new ArrayList<>();

      for (int i = 0; i < numOrders; i++) {
        tips.add(sc.nextInt());
      }
      int maxTip = maximumTip.findMaxTip(maximumTip.sortTips(tips));
      System.out.println(maxTip);
      testcases--;
    }

  }

  private int findMaxTip(ArrayList<Order> sortedOrders) {
    int maxTip = 0;
    for (Order order : sortedOrders) {
      if ((waiter1_capacity > 0) && (waiter2_capacity > 0)) {
        if (order.getTip_diff() > 0) {
          maxTip = maxTip + order.getWaiter1_tip();
          waiter1_capacity--;
        } else {
          maxTip = maxTip + order.getWaiter2_tip();
          waiter2_capacity--;
        }
      } else {
        if (waiter1_capacity == 0) {
          maxTip = maxTip + order.getWaiter2_tip();
          waiter2_capacity--;
        } else {
          maxTip = maxTip + order.getWaiter1_tip();
          waiter1_capacity--;
        }
      }
    }
    return maxTip;
  }

  private ArrayList<Order> sortTips(ArrayList<Integer> tips) {
    int n = tips.size() / 2;
    int total_tips = 0;
    ArrayList<Order> orders = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int tip1 = tips.get(i);
      int tip2 = tips.get(i + n);
      orders.add(new Order(tip1, tip2, tip1 - tip2));
    }
    Comparator<Order> comparator = Comparator.comparing(o -> Math.abs(o.getTip_diff()));
    orders.sort(comparator.reversed());
    return orders;
  }

}




