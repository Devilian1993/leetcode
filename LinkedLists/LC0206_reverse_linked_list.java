package LinkedLists;

/*
LeetCode #206 - Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the head of the reversed list.

Pattern:
- Linked list manipulation
- Two approaches: iterative (in-place) and recursive

Approach (Iterative):
1. Initialize three pointers:
   - prev = null (previous node)
   - curr = head (current node)
   - next (temporary to store curr.next)
2. Iterate while curr != null:
   - Store next = curr.next
   - Reverse pointer: curr.next = prev
   - Move prev to curr
   - Move curr to next
3. After loop, prev will be the new head of the reversed list.

Time Complexity: O(n) — we visit each node exactly once
Space Complexity: O(1) — constant space usage

Example:
Input:  1 -> 2 -> 3 -> 4 -> null
Output: 4 -> 3 -> 2 -> 1 -> null


Approach (Recursive):
1. Base case: if head is null or head.next is null, return head
2. Recursively reverse the rest of the list: ListNode newHead = reverseList(head.next)
3. Reverse the pointer of head.next to point back to head: head.next.next = head
4. Set head.next = null to avoid cycle
5. Return newHead

Time Complexity: O(n) — each node processed once
Space Complexity: O(n) — recursion stack depth is n in worst case

Example:
Input:  1 -> 2 -> 3 -> 4 -> null
Output: 4 -> 3 -> 2 -> 1 -> null
*/

public class LC0206_reverse_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
