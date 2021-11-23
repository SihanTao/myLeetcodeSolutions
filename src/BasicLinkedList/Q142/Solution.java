package BasicLinkedList.Q142;

import BasicLinkedList.ListNode;

public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      // The linked list has a cycle
      if (fast == slow) {
        break;
      }
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    slow = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
