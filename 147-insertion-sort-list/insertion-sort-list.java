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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        if(head==null)return null;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        for(int c:list){
            cur.next=new ListNode(c);
            cur=cur.next;
        }
        return dummy.next;
    }
}