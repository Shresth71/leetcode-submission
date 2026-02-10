/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//metting point
                slow = head;//giving the head to slow

                while (fast != slow) {
                    slow = slow.next;//moving 1 step 
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}