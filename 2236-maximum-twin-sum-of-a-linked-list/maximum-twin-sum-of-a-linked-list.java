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
        if(head==null)return 0;
        ListNode slow=head;
        ListNode fast=head.next;
        List<Integer> list =new ArrayList<>();
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode cur=slow.next;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        ListNode first=head;
        ListNode second=prev;
        while(first!=null && second!=null){
            list.add(first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return Collections.max(list);
    }
}