package BinarySearch.Q34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int left = left_bound(nums, target);
    int right = right_bound(nums, target);
    return new int[] {left, right};
  }

  private int left_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    if (right == 0) {
      return -1;
    }

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }

    if (left == nums.length) {
      return -1;
    }
    return nums[left] == target ? left : -1;
  }

  private int right_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    if (right == 0) {
      return -1;
    }

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }

    if (left == 0) {
      return -1;
    }
    return nums[right - 1] == target ? (right - 1) : -1;
  }
}

public class MainClass {
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static String integerArrayToString(int[] nums, int length) {
    if (length == 0) {
      return "[]";
    }

    StringBuilder result = new StringBuilder();
    for (int index = 0; index < length; index++) {
      int number = nums[index];
      result.append(number).append(", ");
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayToString(int[] nums) {
    return integerArrayToString(nums, nums.length);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);
      line = in.readLine();
      int target = Integer.parseInt(line);

      int[] ret = new Solution().searchRange(nums, target);

      String out = integerArrayToString(ret);

      System.out.print(out);
    }
  }
}
