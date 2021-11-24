package BST.Q116;

public class Solution {
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    connectTwoNodes(root.left, root.right);
    return root;
  }

  private void connectTwoNodes(Node left, Node right) {
    if (left == null || right == null) {
      return;
    }

    left.next = right;

    connectTwoNodes(left.left, left.right);
    connectTwoNodes(right.left, right.right);
    connectTwoNodes(left.right, right.left);
  }
}
