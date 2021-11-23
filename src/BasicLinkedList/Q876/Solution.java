package BasicLinkedList.Q876;

import BasicLinkedList.ListNode;

public class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast!= null) {
      slow = slow.next;
    }
    return slow;
  }
}
