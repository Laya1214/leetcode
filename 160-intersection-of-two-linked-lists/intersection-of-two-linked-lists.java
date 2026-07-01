/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         HashSet<ListNode> set = new HashSet<>(); 
        ListNode cur=headA;
        ListNode cur2=headB;
        while(cur!=null){
            set.add(cur);
            cur=cur.next;
        }
         while(cur2!=null){
            if(set.contains(cur2)){
                return cur2;
                
            }
            set.add(cur2);
            cur2=cur2.next;
        }

        System.out.println(set);
        return null;
    }
}