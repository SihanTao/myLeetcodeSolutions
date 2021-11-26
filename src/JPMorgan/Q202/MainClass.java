package JPMorgan.Q202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (n != 1) {
      n = getNext(n);
      if (seen.contains(n)) {
        return false;
      }
      seen.add(n);
    }

    return true;
  }

  private int getNext(int n) {
    int res = 0;
    while (n != 0) {
      int digit = n % 10;
      n /= 10;
      res += digit * digit;
    }
    return res;
  }
}

public class MainClass {
  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int n = Integer.parseInt(line);

      boolean ret = new Solution().isHappy(n);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}
