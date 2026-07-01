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
    public ListNode partition(ListNode head, int x) {
        ListNode d1=new ListNode(0);
        ListNode d2=new ListNode(0);
        ListNode c1=d1;
        ListNode c2=d2;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                c1.next=new ListNode(cur.val);
                c1=c1.next;
            }
            else{
                c2.next=new ListNode(cur.val);
                c2=c2.next;
            }
            cur=cur.next;
        }
        c1.next=d2.next;
        return d1.next;
    }
}