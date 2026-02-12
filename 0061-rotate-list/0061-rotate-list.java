/**

* Definition for singly-linked list.
* public class ListNode {
* ```
  int val;
  ```
* ```
  ListNode next;
  ```
* ```
  ListNode() {}
  ```
* ```
  ListNode(int val) { this.val = val; }
  ```
* ```
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  ```
* }
  */

class Solution {
public ListNode rotateRight(ListNode head, int k) {

```
    // Edge case: if list is empty or has only one node
    if(head == null || head.next == null) return head;

    // Step 1: Find length of linked list
    // Also move temp to the last node (tail)
    ListNode temp = head;
    int count = 1;   // start from 1 because we are already at head

    while(temp.next != null){
        count++;          // increase length
        temp = temp.next; // move to next node
    }

    // Step 2: Optimize k
    // Rotating more than length is useless
    k = k % count;

    // If k becomes 0 → list remains same
    if(k == 0) return head;

    // Step 3: Make the linked list circular
    // Connect tail to head
    temp.next = head;

    // Step 4: Find new tail
    // New tail will be at (count - k)th position
    int len = count - k;
    ListNode newtail = head;

    // Move to the new tail node
    for(int i = 1; i < len; i++){
        newtail = newtail.next;
    }

    // Step 5: New head is next of new tail
    ListNode newhead = newtail.next;

    // Step 6: Break the circular link
    newtail.next = null;

    // Return rotated list head
    return newhead;
}
```

}
