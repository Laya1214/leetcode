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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> ls=new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            ls.add(p.val);
            p=p.next;
        }
        int[] nums=new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            nums[i]=ls.get(i);
        }
        return construct(nums,0,nums.length-1);
    }
     public TreeNode construct(int[] nums,int l,int r){
        if(l>r)return null;
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=construct(nums,l,mid-1);
        root.right=construct(nums,mid+1,r);
        return root;
    }

}