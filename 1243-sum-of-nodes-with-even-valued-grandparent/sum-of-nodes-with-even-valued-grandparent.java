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
    public int sumEvenGrandparent(TreeNode root) {
        return pre(root,null,null);
    }
    public int pre(TreeNode root,TreeNode p,TreeNode gp){
        if(root==null)return 0;
        int cur=0;
        if(gp!=null && (gp.val&1)==0)cur+=root.val;
        
        return cur+pre(root.left,root,p)+pre(root.right,root,p);
    }
}