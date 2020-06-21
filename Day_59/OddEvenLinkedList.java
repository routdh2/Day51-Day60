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
//Problem Statement: https://leetcode.com/problems/odd-even-linked-list/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        ListNode oddPtr=head;
        ListNode evenPtr=head.next;
        ListNode first=oddPtr;
        ListNode second=evenPtr;
        while(oddPtr!=null && evenPtr!=null) {
            if(oddPtr.next.next==null)
                break;
            oddPtr.next=oddPtr.next.next;
            oddPtr=oddPtr.next;
            evenPtr.next=evenPtr.next.next;
            evenPtr=evenPtr.next;
        }
        oddPtr.next=second;
        return first;
    }
}
