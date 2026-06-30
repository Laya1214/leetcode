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
    public ListNode swapPairs(ListNode head) {
        if (head == null ) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode gprev=dummy;
        while(true){
            ListNode kth=getk(gprev,2);
            if (kth == null) break;
            ListNode gnext=kth.next;
            ListNode prev=kth.next;
            ListNode cur=gprev.next;
            while(cur!=gnext){
                ListNode next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            ListNode temp=gprev.next;
            gprev.next=kth;
            gprev=temp;
        }
        return dummy.next;
    }
    public static ListNode getk(ListNode cur,int k){
        while(cur!=null && k>0){
            cur=cur.next;
            k--;
        }
        return cur;
    }
}