/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        //two pointer slow,fast and a previous pointer to keep track node before slow
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        //whi
        while(fast!=null && fast.next!=null){
            prev =slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        //remove the middle node(slow)
        prev.next = slow.next;
        return head;
    }
}