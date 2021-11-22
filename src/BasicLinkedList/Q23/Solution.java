package BasicLinkedList.Q23;

import BasicLinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode();
    ListNode p = dummy;

    PriorityQueue<ListNode> priorityQueue =
        new PriorityQueue<>(Comparator.comparingInt(t -> t.val));

    for (ListNode listNode : lists) {
      if (listNode != null) {
        priorityQueue.add(listNode);
      }
    }

    while (!priorityQueue.isEmpty()) {
      ListNode smallest = priorityQueue.poll();
      p.next = smallest;
      p = p.next;
      if (smallest.next != null) {
        priorityQueue.add(smallest.next);
      }
    }

    return dummy.next;
  }
}
