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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        
        ListNode ne=dummy;
        while(l1!=null &l2!=null){
            if(l1.val<=l2.val){
                ne.next=l1;
                l1=l1.next;
            }
            else{
                ne.next=l2;
                l2=l2.next;
            }
            ne=ne.next;
        }
        if(l1!=null){
            ne.next=l1;
        }
        else{
            ne.next=l2;
        }
        return dummy.next;
    }
}