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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode li:lists){
            if(li!=null){
                pq.offer(li);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode x=dummy;
        while(!pq.isEmpty()){
            ListNode cur=pq.poll();
            x.next=cur;
            x=x.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
    return dummy.next;
    }
}