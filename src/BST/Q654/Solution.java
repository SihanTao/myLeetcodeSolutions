package BST.Q654;

import BST.TreeNode;

public class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return build(nums, 0, nums.length);
  }

  private TreeNode build(int[] nums, int start, int end) {
    if (start >= end) {
      return null;
    }

    // Find the maximum of the nums and record its index
    int index = 0;
    for (int i = start; i < end; i++) {
      if (nums[index] < nums[i]) {
        index = i;
      }
    }

    TreeNode root = new TreeNode(nums[index]);

    // Recursively building the left and right tree
    root.left = build(nums, start, index);
    root.right = build(nums, index + 1, end);
    return root;
  }
}
