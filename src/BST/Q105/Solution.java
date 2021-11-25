package BST.Q105;

import BST.TreeNode;

public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode build(
          int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);

    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == rootVal) {
        index = i;
        break;
      }
    }

    int leftSize = index - inStart;

    root.left =
            build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
    root.right = build(preorder, preStart + 1 + leftSize, preEnd, inorder, index + 1, inEnd);

    return root;
  }
}

