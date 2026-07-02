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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> st=new Stack<>();
        ListNode dummy=new ListNode(0);
        ListNode x=dummy;
        ListNode cur=head;
        while(cur!=null){
            st.push(cur.val);
            cur=cur.next;
        }
        while(!st.isEmpty()){
            x.next=new ListNode(st.pop());
            x=x.next;
        }
        return dummy.next;
    }
}