package BasicLinkedList.Q19;

import BasicLinkedList.ListNode;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    assert head != null;
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode fast = head;
    ListNode slow = head;
    ListNode slowPrev = dummy;

    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slowPrev = slowPrev.next;
      slow = slow.next;
      fast = fast.next;
    }

    // Now we should remove the slow pointer
    slowPrev.next = slow.next;
    return dummy.next;
  }
}
