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
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur=head;
        int c=1;
        while(cur.next!=null){
            c++;
            cur=cur.next;
        }
        cur.next=head;
        int l=k%c;
        if (l == 0) {
            cur.next = null;
            return head; 
        }
        
        ListNode tail=head;
        for (int i = 1; i < c - l; i++) {
            tail = tail.next;
        }
        ListNode newn=tail.next;
        tail.next=null;
        return newn;
    }
}