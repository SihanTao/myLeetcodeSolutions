package JPMorgan.Q91;

public class Solution {
  public int numDecodings(String s) {
    int n = s.length();
    int[] f = new int[n + 1];
    f[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      if (s.charAt(i - 1) != 0) {
        f[i] += f[i - 1];
      }
      if (i >= 2
          && s.charAt(i - 2) != 0
          && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
        f[i] += f[i - 2];
      }
    }

    return f[n];
  }
}
