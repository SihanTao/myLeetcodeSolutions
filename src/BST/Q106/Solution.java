package BST.Q106;

import BST.TreeNode;

public class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }

  private TreeNode build(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
    if (inorderStart >= inorderEnd) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postorderEnd - 1]);

    // Find the root index in the inorder nums
    int rootIndex = 0;
    for (int i = inorderStart; i < inorderEnd; i++) {
      if (inorder[i] == postorder[postorderEnd - 1]) {
        rootIndex = i;
        break;
      }
    }

    int leftSize = rootIndex - inorderStart;

    // Recursively build the left and right tree
    root.left =
        build(
            inorder, inorderStart, rootIndex, postorder, postorderStart, postorderStart + leftSize);
    root.right =
        build(
            inorder, rootIndex + 1, inorderEnd, postorder, postorderStart + leftSize, postorderEnd - 1);

    return root;
  }
}
