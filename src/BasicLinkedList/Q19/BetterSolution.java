package BasicLinkedList.Q19;

import BasicLinkedList.ListNode;

public class BetterSolution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    // If we want to delete the nth from end
    // we need to know the n+1 th from the end
    ListNode x = findFromEnd(dummy, n + 1);
    // Delete the nth node from the end
    x.next = x.next.next;
    return dummy.next;
  }

  private ListNode findFromEnd(ListNode head, int k) {
    ListNode p1 = head;
    for (int i = 0; i < k; i++) {
      p1 = p1.next;
    }
    ListNode p2 = head;
    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }
    // p2 now points to the (n - k)th node
    return p2;
  }
}
