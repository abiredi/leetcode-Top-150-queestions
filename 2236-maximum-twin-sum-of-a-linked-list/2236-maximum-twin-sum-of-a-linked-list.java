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
    public int pairSum(ListNode head) {
        if(head == null || head.next == null) return 0;

        ListNode slow= head, fast=head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode prev=null, curr = slow;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr = temp; 
        }

        int maxSum =0;
        ListNode first = head, second = prev;
        while(second !=null){
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;

    }
}