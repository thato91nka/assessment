package solution3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by A222186 on 2018/04/08.
 */
public class BinaryTree {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    while (testcases > 0) {
      int size = sc.nextInt();
      sc.nextLine();
      ArrayList<Integer> input = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        input.add(sc.nextInt());
      }
      int i = 0;
      int maxLevels = (int) Math.ceil(Math.log(input.size()) / Math.log(2));
      while (i < maxLevels) {
        int from = (int) Math.pow(2, i) - 1;
        int to = (int) Math.pow(2, i + 1) - 1;
        if (to > input.size()) {
          to = input.size();
        }
        List<Integer> templist = input.subList(from, to);
        templist.stream().sorted().distinct().forEach(a -> System.out.print(a + " "));
        System.out.println();
        i++;
      }
      testcases--;
    }
  }


}
