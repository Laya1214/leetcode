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
     public static ListNode reverse(ListNode head){
            ListNode cur=head;
            ListNode prev=null;
            while(cur!=null){
                ListNode next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            return prev;
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode x=dummy;
        ListNode p1=reverse(l1);
        ListNode p2=reverse(l2);
        int c=0;
        while(p1!=null || p2!=null|| c>0){
            int d1=(p1 == null) ? 0 : p1.val;
            int d2=(p2==null)?0:p2.val;
            int digit=d1+d2+c;
            
            
                c=digit/10;
            
            x.next=new ListNode(digit%10);
            x=x.next;
            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;

        }
        return reverse(dummy.next);
    }
}